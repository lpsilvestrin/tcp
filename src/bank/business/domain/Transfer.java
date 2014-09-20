package bank.business.domain;

/**
 * @author Ingrid Nunes
 * 
 */
public class Transfer extends Transaction {

	private CurrentAccount destinationAccount;
	private String status;

	public Transfer(OperationLocation location, CurrentAccount account,
			CurrentAccount destinationAccount, double amount, String status) {
		super(location, account, amount);
		this.destinationAccount = destinationAccount;
		this.status = status;
	}

	/**
	 * @return the destinationAccount
	 */
	public CurrentAccount getDestinationAccount() {
		return destinationAccount;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

}
