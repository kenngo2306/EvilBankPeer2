package main;

public class Account_type {
	private int ID;
	private String type_name;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(boolean type) {	
		type_name = (type) ? "Checking":"Saving";
	}
}
