package bank.ui.text.command;

import bank.business.AccountOperationService;
import bank.business.domain.Transfer;
import bank.ui.text.BankTextInterface;
import bank.ui.text.UIUtils;
import bank.business.domain.CurrentAccount;
import bank.business.domain.CurrentAccountId;
import java.util.List;

public class PendingCommand extends Command {
	
	private final AccountOperationService accountOperationService;
	int id;
	
	public PendingCommand(BankTextInterface bankInterface,
			AccountOperationService accountOperationService) {
		super(bankInterface);
		this.accountOperationService = accountOperationService;
	}
	
	/*
	private void printTransfer(Transfer transfer) {
		System.out.println("")
	};*/

	@Override
	public void execute() throws Exception {
		
		List<Transfer> pendings = accountOperationService.getPendings();
		String op = "";
		Transfer choosen = null;
		UIUtils uiUtils = UIUtils.INSTANCE;
		
		do {
			if(pendings.size() > 0) {
	//		System.out.println(pendings.size());
				pendings = accountOperationService.getPendings();
				System.out.println("id \t source \t destination \t amount ");
				
				int i = 0;
				
				for (Transfer p : pendings) {
					CurrentAccount ac = p.getAccount();
					CurrentAccountId acId = ac.getId();
					CurrentAccount dst = p.getDestinationAccount();
		
					System.out.println(i + "\t" + acId.getNumber() + "\t" + dst.getId().getNumber() + "\t" + p.getAmount());
					i++;
				}
							
				id = uiUtils.INSTANCE.readInteger("pending.id");
				try {
					choosen = pendings.get(id);
				} catch(IndexOutOfBoundsException e) {
					choosen = null;					
				}
				
				if(choosen != null) {					
					op = uiUtils.INSTANCE.readString("message.pendings.choose");
					if(op.equals("A")) {
						accountOperationService.acceptTransfer(choosen);
						System.out.println(getTextManager().getText("message.pendings.cancelled"));
					} else if(op.equals("C")) {
						accountOperationService.cancelTransfer(choosen);
						System.out.println(getTextManager().getText("message.pendings.accepted"));
					} 
				} else {
					System.out.println(getTextManager().getText("message.pendings.invalid"));
				}				
			} else {
				System.out.println(getTextManager().getText("message.pendings.empty"));
			}
		} while (!op.equals("O") && pendings.size() > 0);
	}
	
}
