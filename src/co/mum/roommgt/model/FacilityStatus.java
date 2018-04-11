package co.mum.roommgt.model;

public class FacilityStatus {

	private int id;
	private String status;
	private String frame;
	private String mattress;
	private String desk;
	private String chair;
	private String bookshelf;
	private String dresser;
	private String wastebasket;
	private String recycle_bin;
	private int arrivalid;
	private int departureid;
	private int room_number;
	private int building_number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getWastebasket() {
		return wastebasket;
	}

	public void setWastebasket(String wastebasket) {
		this.wastebasket = wastebasket;
	}

	public String getRecycle_bin() {
		return recycle_bin;
	}

	public void setRecycle_bin(String recycle_bin) {
		this.recycle_bin = recycle_bin;
	}

	public int getArrivalid() {
		return arrivalid;
	}

	public void setArrivalid(int arrivalid) {
		this.arrivalid = arrivalid;
	}

	public int getDepartureid() {
		return departureid;
	}

	public void setDepartureid(int departureid) {
		this.departureid = departureid;
	}

	public int getRoom_number() {
		return room_number;
	}

	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}

	public int getBuilding_number() {
		return building_number;
	}

	public void setBuilding_number(int building_number) {
		this.building_number = building_number;
	}

	public String getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(String last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	private String last_updated_by;
}
