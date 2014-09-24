/*
 * Created on 6 Jan 2014 21:13:57 
 */
package bank.ui.graphic.action;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import java.util.List;

import javax.swing.Action;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.AbstractTableModel;

import bank.business.AccountOperationService;
import bank.business.BusinessException;
import bank.business.domain.CurrentAccountId;
import bank.business.domain.Transfer;
import bank.ui.TextManager;
import bank.ui.graphic.BankGraphicInterface;
import bank.ui.graphic.GUIUtils;

/**
 * @author ingrid
 * 
 */
public class PendingAction extends AccountAbstractAction {


	private class TransferTableModel extends AbstractTableModel {

		private static final long serialVersionUID = 2497950520925208080L;

		private CurrentAccountId id;
		private List<Transfer> transfers;

		public TransferTableModel(
				List<Transfer> transfers) {
			this.transfers = new ArrayList<>(transfers);
		}

		@Override
		public int getColumnCount() {
			return 5;
		}

		@Override
		public String getColumnName(int column) {
			String key = null;
			switch (column) {
			case 0:
				key = "date";
				break;
			case 1:
				key = "location";
				break;
			case 2:
				key = "source.tag";
				break;
			case 3:
				key = "destination.tag";
				break;
			case 4:
				key = "amount";
				break;
			default:
				assert false;
				break;
			}
			return textManager.getText(key);
		}

		@Override
		public int getRowCount() {
			return transfers.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Transfer t = transfers.get(rowIndex);
			Object val = null;
			switch (columnIndex) {
			case 0:
				val = GUIUtils.DATE_TIME_FORMAT.format(t.getDate());
				break;
			case 1:
				val = t.getLocation();
				break;
			case 2:
				if (t instanceof Transfer) {
					Transfer transfer = (Transfer) t;
					StringBuffer sb = new StringBuffer();
					CurrentAccountId otherId = transfer.getAccount().getId()
							.equals(id) ? transfer.getAccount()
							.getId() : transfer.getAccount().getId();
					sb.append("AG ").append(otherId.getBranch().getNumber())
							.append(" C/C ").append(otherId.getNumber());
					val = sb.toString();
				} else {
					assert false;
				}
				break;
			case 3:
				if (t instanceof Transfer) {
					Transfer transfer = (Transfer) t;
					StringBuffer sb = new StringBuffer();
					CurrentAccountId otherId = transfer.getAccount().getId()
							.equals(id) ? transfer.getDestinationAccount()
							.getId() : transfer.getAccount().getId();
					sb.append("AG ").append(otherId.getBranch().getNumber())
							.append(" C/C ").append(otherId.getNumber());
					val = sb.toString();
				} else {
					assert false;
				}
				break;
			case 4:
				if (t instanceof Transfer) {
					Transfer transfer = (Transfer) t;
					if (transfer.getAccount().getId().equals(id)) {
						val = "- " + t.getAmount();
					} else {
						val = "+ " + t.getAmount();
					}
				} else {
					assert false;
				}
				break;

			default:
				assert false;
				break;
			}
			return val;
		}

	}

	
	private static final long serialVersionUID = 5090183202921964451L;


	private JDialog dialog;

	private JTable transfers;


	public PendingAction(BankGraphicInterface bankInterface,
			TextManager textManager,
			AccountOperationService accountOperationService) {
		super(bankInterface, textManager, accountOperationService);

		super.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		super.putValue(Action.NAME, textManager.getText("action.pending"));
	}

	public void close() {
		dialog.dispose();
		dialog = null;
	}

	
	@Override
	public void execute() throws Exception {
		JPanel accountPanel = new JPanel(new GridLayout(2, 2, 5, 5));
		initAndAddAccountFields(accountPanel);

		// Confirmation Buttons
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton closeButton = new JButton(textManager.getText("button.close"));
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		buttonsPanel.add(closeButton);
		JButton cancelButton = new JButton(textManager.getText("button.cancel"));
		cancelButton.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent arg0) {

					int row = transfers.getSelectedRow();
					List<Transfer> transfers = accountOperationService
							.getPendings();
					Transfer t = transfers.get(row);
					try {
						accountOperationService.cancelTransfer(t);
					} catch (BusinessException be) {
						GUIUtils.INSTANCE.showMessage(bankInterface.getFrame(),
								be.getMessage(), be.getArgs(), JOptionPane.WARNING_MESSAGE);
						log.warn(be);
					}
					showPendings();
	
			}
		});
		buttonsPanel.add(cancelButton);

		JButton allowButton = new JButton(textManager.getText("button.allow"));
		allowButton.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent arg0) {

					int row = transfers.getSelectedRow();
					List<Transfer> transfers = accountOperationService
							.getPendings();
					Transfer t = transfers.get(row);
					try {
						accountOperationService.acceptTransfer(t);
					} catch (BusinessException be) {
						GUIUtils.INSTANCE.showMessage(bankInterface.getFrame(),
								be.getMessage(), be.getArgs(), JOptionPane.WARNING_MESSAGE);
						log.warn(be);
					}
					showPendings();
	
			}
		});
		buttonsPanel.add(allowButton);
		
		// Pendings result
		JPanel transfersPanel = new JPanel();
		transfersPanel
				.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		transfers = new JTable();
		JScrollPane scrollPane = new JScrollPane(transfers,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		transfersPanel.add(scrollPane);

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

		JPanel pane = new JPanel(new BorderLayout());
		pane.add(mainPanel, BorderLayout.NORTH);
		pane.add(transfersPanel, BorderLayout.CENTER);

		showPendings();
		
		this.dialog = GUIUtils.INSTANCE.createDialog(bankInterface.getFrame(),
				"action.pending", pane);
		this.dialog.setVisible(true);
	}

	private void showPendings() {
		try {

			List<Transfer> transfers = accountOperationService
					.getPendings();
			this.transfers.setModel(new TransferTableModel(
					transfers));
		} 
		catch (Exception exc) {
			GUIUtils.INSTANCE.handleUnexceptedError(bankInterface.getFrame(),
					exc);
		}
	}

}