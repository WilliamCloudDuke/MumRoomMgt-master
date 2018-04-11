package co.mum.roommgt.model;

public class Transaction {

	private int id;
	private String description;
	private int studentid;
	private int request_TypeId;
	private int buildingFrom;
	private int suggestBuilding;
	private String transactionDate;
	private String email;
	private String phoneNumber;
	private String department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public int getRequest_TypeId() {
		return request_TypeId;
	}

	public void setRequest_TypeId(int request_TypeId) {
		this.request_TypeId = request_TypeId;
	}

	public int getBuildingFrom() {
		return buildingFrom;
	}

	public void setBuildingFrom(int buildingFrom) {
		this.buildingFrom = buildingFrom;
	}

	public int getSuggestBuilding() {
		return suggestBuilding;
	}

	public void setSuggestBuilding(int suggestBuilding) {
		this.suggestBuilding = suggestBuilding;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Transaction() {
	}

}


/*

	{'id': 1, 'description':'sample_desc', 'studentid': 1, 'request_TypeId' : 1, 'buildingFrom' : 1, 
	 'transactionDate': '11-12-2009', 'email':'somewhere', 'phoneNumber':'123123123', 'department': ''}

 * */
