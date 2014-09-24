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
		String op = null;
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
				
				System.out.println("Digite o id de alguma transferência (digite O para sair): ");
												
				
				
				op = uiUtils.readString(null);
				
				if(op != "O") {				
					id = Integer.parseInt(op);
					choosen = pendings.get(id);
					
					if(choosen != null) {
						System.out.println("Digite A para autorizar e C para cancelar transferência (O para sair): ");
						op = uiUtils.readString(null);
						if(op == "A") {
							accountOperationService.acceptTransfer(choosen);
						} else if(op == "C") {
							accountOperationService.cancelTransfer(choosen);
						} 
					} else {
						System.out.println("Número inválido!");
					}
				}
			} else {
				System.out.println("Nenhuma transferência pendente");
			}
		} while (op != "O" && pendings.size() > 0);
	}
}
