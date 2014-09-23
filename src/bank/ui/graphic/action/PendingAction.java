package bank.ui.graphic.action;



import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import bank.business.AccountOperationService;
import bank.business.BusinessException;
//import bank.business.domain.Transfer;
import bank.ui.TextManager;
import bank.ui.graphic.BankGraphicInterface;
import bank.ui.graphic.GUIUtils;
import bank.business.domain.Transfer;
import bank.business.domain.CurrentAccount;
import bank.business.domain.CurrentAccountId;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class PendingAction extends AccountAbstractAction {

	private final AccountOperationService accountOperationService;

	private static final long serialVersionUID = 5090183202921964451L;

	private JDialog dialog;

	public PendingAction(BankGraphicInterface bankInterface,
			TextManager textManager,
			AccountOperationService accountOperationService) {
		super(bankInterface, textManager, accountOperationService);
		this.accountOperationService = accountOperationService;
		super.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		super.putValue(Action.NAME, textManager.getText("action.pending"));
	}
		

	public void execute() throws Exception  {
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JPanel subpanel = new JPanel(new GridLayout(5, 2, 5, 5));

		initAndAddAccountFields(subpanel);

		panel.add(subpanel, BorderLayout.CENTER);

		subpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		panel.add(subpanel, BorderLayout.SOUTH);

	    DefaultListModel<Integer> listModel = new DefaultListModel<>();
        List<Transfer> pendings = accountOperationService.getPendings();
        JScrollPane s1;
		

		//for (int i = 0; i < pendings.size(); i++) {
		/*	Transfer pending = pendings.get(i);
			CurrentAccount ac = pending.getAccount();
			CurrentAccountId acId = ac.getId();
			*/
			
			listModel.addElement(2);
			listModel.addElement(342);
		//}
                
        JList list = new JList<>(listModel);
        s1=new JScrollPane(list);
        panel.add(s1, BorderLayout.CENTER);

		this.dialog = GUIUtils.INSTANCE.createDialog(bankInterface.getFrame(),
				"action.transfer", panel);
		this.dialog.setVisible(true);
       
       
//	    JScrollPane pane = new JScrollPane(list);
		
/*
		this.dstBranch = new JFormattedTextField(
				NumberFormat.getIntegerInstance());
		dstBranch.setColumns(10);
		subpanel.add(new JLabel(textManager.getText("destination.branch") + ":"));
		subpanel.add(dstBranch);

		this.dstAccountNumber = new JFormattedTextField(
				NumberFormat.getIntegerInstance());
		dstAccountNumber.setColumns(10);
		subpanel.add(new JLabel(textManager
				.getText("destination.account.number") + ":"));
		subpanel.add(dstAccountNumber);

		this.amount = new JFormattedTextField(NumberFormat.getNumberInstance());
		amount.setColumns(10);
		subpanel.add(new JLabel(textManager.getText("amount") + ":"));
		subpanel.add(amount);
*/

	 //   add(pane, BorderLayout.NORTH);
	  //  add(addButton, BorderLayout.WEST);
	  //  add(removeButton, BorderLayout.EAST);
	}


/*
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub

	}
	*/
}

