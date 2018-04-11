package co.mum.roommgt.model;

/**
 * ROLE_TYPE Description: ROLE_TYPE 01/19/2018
 * 
 * @version 1.0 18 March 2018
 
 * @author Binyam H
 */
public enum ROLE_TYPE {

	RESIDENT_ADVISOR(1), RESIDENT_DIRECTOR(2), STUDENT(3);

	private final int roleTypeCode;

	ROLE_TYPE(int code) {
		this.roleTypeCode = code;
	}

	public int getRoleTypeCode() {
		return this.roleTypeCode;
	}
}
