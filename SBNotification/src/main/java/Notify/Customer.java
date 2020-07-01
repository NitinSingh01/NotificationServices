package Notify;

public class Customer {
	long CustId;
	String First_Name;
	String Last_Name;
	String Aadhar_Id;
	String Email;
	String Password;
	String Address;
	String City;
	String State;
	int UID;
	String Fields;
	
	public String getFields() {
		return Fields;
	}
	public void setFields(String fields) {
		Fields = fields;
	}
	public long getCust_ID() {
		return CustId;
	}
	public void setCust_ID(long custId) {
		CustId = custId;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getAadhar_Id() {
		return Aadhar_Id;
	}
	public void setAadhar_Id(String aadhar_Id) {
		Aadhar_Id = aadhar_Id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		
		UID = uID;
	}
	public Customer(String fields,long custId, String first_Name, String last_Name, String aadhar_Id, String email, String password,
			String address, String city, String state, int uID) {
		Fields = fields;
		CustId = custId;
		First_Name = first_Name;
		Last_Name = last_Name;
		Aadhar_Id = aadhar_Id;
		Email = email;
		Password = password;
		Address = address;
		City = city;
		State = state;
		UID = uID;
	}
	public Customer() {}
	

}
