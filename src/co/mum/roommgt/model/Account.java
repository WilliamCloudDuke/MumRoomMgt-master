package co.mum.roommgt.model;

/**
 * Account Description: Account VO 01/19/2018
 * 
 * @version 1.0 18 March 2018
 * @author William Chaparro
 */

public class Account {

	private String userName;
	private String password;
	private ROLE_TYPE roleType;
	private int buildingNumber;

	public Account(String userName, String password, ROLE_TYPE roleType) {
		super();
		this.userName = userName;
		this.password = password;
		this.roleType = roleType;
	}

	public Account(String userName, String password, ROLE_TYPE roleType, int buildingNumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.roleType = roleType;
		this.buildingNumber = buildingNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ROLE_TYPE getRoleType() {
		return roleType;
	}

	public void setRoleType(ROLE_TYPE roleType) {
		this.roleType = roleType;
	}

	public int getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}
}
