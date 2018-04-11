package co.mum.roommgt.model;

public class RoomStatus {
	private int roomNumber;
	private int bldgNumber;
	private String roomStatus;
	private String occupiedBy;
	private String occupiedSince;
	private String roleType;
	private String notes;
	
	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getBldgNumber() {
		return bldgNumber;
	}

	public void setBldgNumber(int bldgNumber) {
		this.bldgNumber = bldgNumber;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getOccupiedBy() {
		return occupiedBy;
	}

	public void setOccupiedBy(String occupiedBy) {
		this.occupiedBy = occupiedBy;
	}

	public String getOccupiedSince() {
		return occupiedSince;
	}

	public void setOccupiedSince(String occupiedSince) {
		this.occupiedSince = occupiedSince;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
