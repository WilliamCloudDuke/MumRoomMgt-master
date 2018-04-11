package co.mum.roommgt.model;
* ROLE_TYPE Description: ROLE_TYPE 01/19/2018
 * 
 * @version 1.0 18 March 2018
 
 * @author Binyam H
 */

public class TransactionWrapper {
	private String transType;
	private String transObject;

	public TransactionWrapper() {
	}

	public Object getTransObject() {
		return transObject;
	}

	public void setTransObject(String transObject) {
		this.transObject = transObject;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}
}
