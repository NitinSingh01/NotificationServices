package Notify;

import java.sql.Timestamp;

public class Account {
	int Cust_ID;
	public int getCust_ID() {
		return Cust_ID;
	}
	public void setCust_ID(int cust_ID) {
		Cust_ID = cust_ID;
	}
	private int Acc_ID;
	private String Password;
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	/**
	 * @return the acc_ID
	 */
	public int getAcc_ID() {
		return Acc_ID;
	}

	/**
	 * @param acc_ID the acc_ID to set
	 */
	public void setAcc_ID(int acc_ID) {
		Acc_ID = acc_ID;
	}
	private String Acc_Holder_Name;
	private String Email;
	private String Aadhar_Id;
	private float Balance;
	private Timestamp Time_Of_Last_Update;
	
	
	public Timestamp getTime_Of_Last_Update() {
		return Time_Of_Last_Update;
	}

	public void setTime_Of_Last_Update(Timestamp time_Of_Last_Update) {
		Time_Of_Last_Update = time_Of_Last_Update;
	}

	public Account() {}
	
	public Account(int cust_ID,int acc_Id,String acc_Holder_Name,String password, String email, String aadhar_Id, float balance,Timestamp time_Of_Last_Update) {
		super();
		Cust_ID = cust_ID;
		Acc_ID = acc_Id;
		Acc_Holder_Name = acc_Holder_Name;
		Email = email;
		Password = password;
		Aadhar_Id = aadhar_Id;
		Balance = balance;
		Time_Of_Last_Update=time_Of_Last_Update;
	}

	/**
	 * @return the acc_Holder_Name
	 */
	public String getAcc_Holder_Name() {
		return Acc_Holder_Name;
	}
	/**
	 * @param acc_Holder_Name the acc_Holder_Name to set
	 */
	public void setAcc_Holder_Name(String acc_Holder_Name) {
		Acc_Holder_Name = acc_Holder_Name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}
	/**
	 * @return the pANCARD
	 */
	public String getAadhar_Id() {
		return Aadhar_Id;
	}
	/**
	 * @param aadhar_Id the pANCARD to set
	 */
	public void setAadhar_Id(String aadhar_Id) {
		Aadhar_Id = aadhar_Id;
	}
	
	/**
	 * @return the balance
	 */
	public float getBalance() {
		return Balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(float balance) {
		Balance = balance;
	}
	
}
