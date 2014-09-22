package bank.ui.text.command;

import bank.business.AccountOperationService;
import bank.business.BusinessException;
import bank.business.domain.Transfer;
import bank.ui.text.BankTextInterface;
import bank.ui.text.UIUtils;
import bank.business.domain.CurrentAccount;
import bank.business.domain.CurrentAccountId;
import java.util.List;

public class PendingCommand extends Command {
	
	private final AccountOperationService accountOperationService;

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
		
//		System.out.println(pendings.size());
		System.out.println("Selecione uma opção: ");
		
		for (int i = 0; i < pendings.size(); i++) {
			/*Transfer pending = pendings.get(i);
			CurrentAccount ac = pending.getAccount();
			CurrentAccountId acId = ac.getId();
			*/

			System.out.println(//getTextManager().getText("transfer") + 
					i);
								
		}
		
		String commandKey = null;
		UIUtils uiUtils = UIUtils.INSTANCE;
		
//		public static final String EXIT_CODE = "E";
//		do {
			System.out.println();
			int i;
//			commandKey = uiUtils.readString(null);
//			Command command = (Command) actions.get(commandKey);
			
			i = uiUtils.readInteger(null);
			Transfer pending = pendings.get(i);
			System.out.println(pending.getAmount());
		//	CurrentAccount ac = pending.getAccount();
		//	CurrentAccountId acId = ac.getId();
			
			
//		} while (!EXIT_CODE.equals(commandKey));
		


	//	Double amount = UIUtils.INSTANCE.readDouble("amount");
/*
		Transfer transfer = accountOperationService.transfer(bankInterface
				.getOperationLocation().getNumber(), srcBranch,
				srcAccountNumber, dstBranch, dstAccountNumber, amount);
				

		System.out.println(getTextManager().getText(
				"message.operation.succesfull"));
		System.out.println(getTextManager().getText("transfer") + ": "
				+ transfer.getAmount());
				*/
	}

}
