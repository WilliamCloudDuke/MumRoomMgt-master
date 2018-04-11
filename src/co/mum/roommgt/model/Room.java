package co.mum.roommgt.model;

import java.time.LocalDateTime;

/**
 * Room Description: Room VO 01/19/2018
 * 
 * @version 1.0 18 March 2018
 * @author William Chaparro
 */

public class Room {

	private int id;
	private String status;
	private String frame;
	private String mattress;
	private String desk;
	private String chair;
	private String bookshelf;
	private String dresser;
	private String wasteBasket;
	private String recycleBin;
	private int arrivalId;
	private int departureId;
	private String room_number;
	private String building_number;
	private String Last_Updated_By;
	private String studentName;
	private String studentLastName;
	private String notes;
	private String jqGrid_id;

	public Room()
	{}
	
	public int getId() {
		return id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getLast_updated_date() {
		return last_updated_date;
	}

	public void setLast_updated_date(LocalDateTime last_updated_date) {
		this.last_updated_date = last_updated_date;
	}

	private LocalDateTime last_updated_date;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFrame() {
		return frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public String getMattress() {
		return mattress;
	}

	public void setMattress(String mattress) {
		this.mattress = mattress;
	}

	public String getDesk() {
		return desk;
	}

	public void setDesk(String desk) {
		this.desk = desk;
	}

	public String getChair() {
		return chair;
	}

	public void setChair(String chair) {
		this.chair = chair;
	}

	public String getBookshelf() {
		return bookshelf;
	}

	public void setBookshelf(String bookshelf) {
		this.bookshelf = bookshelf;
	}

	public String getDresser() {
		return dresser;
	}

	public void setDresser(String dresser) {
		this.dresser = dresser;
	}

	public String getWasteBasket() {
		return wasteBasket;
	}

	public void setWasteBasket(String wasteBasket) {
		this.wasteBasket = wasteBasket;
	}

	public String getRecycleBin() {
		return recycleBin;
	}

	public void setRecycleBin(String recycleBin) {
		this.recycleBin = recycleBin;
	}

	public int getArrivalId() {
		return arrivalId;
	}

	public void setArrivalId(int arrivalId) {
		this.arrivalId = arrivalId;
	}

	public int getDepartureId() {
		return departureId;
	}

	public void setDepartureId(int departureId) {
		this.departureId = departureId;
	}

	public String getRoom_number() {
		return room_number;
	}

	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}

	public String getBuilding_number() {
		return building_number;
	}

	public void setBuilding_number(String building_number) {
		this.building_number = building_number;
	}

	public String getLast_Updated_By() {
		return Last_Updated_By;
	}

	public void setLast_Updated_By(String last_Updated_By) {
		Last_Updated_By = last_Updated_By;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getJqGrid_id() {
		return jqGrid_id;
	}

	public void setJqGrid_id(String jqGrid_id) {
		this.jqGrid_id = jqGrid_id;
	}

}
