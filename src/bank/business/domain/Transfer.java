package bank.business.domain;

/**
 * @author Ingrid Nunes
 * 
 */
public class Transfer extends Transaction {

	private CurrentAccount destinationAccount;
	private TransferStatus status;
	private static long count = 0;
	private long id;

	public Transfer(OperationLocation location, CurrentAccount account,
			CurrentAccount destinationAccount, double amount, TransferStatus status) {
		super(location, account, amount);
		this.destinationAccount = destinationAccount;
		this.status = status;
		this.id = count;
		count++;
	}

	/**
	 * @return the destinationAccount
	 */
	public CurrentAccount getDestinationAccount() {
		return destinationAccount;
	}
	
	public TransferStatus getStatus() {
		return this.status;
	}
	
	public void setStatus(TransferStatus status) {
		this.status = status;
	}
	
	public long getId(){
		return this.id;
	}
	
}
