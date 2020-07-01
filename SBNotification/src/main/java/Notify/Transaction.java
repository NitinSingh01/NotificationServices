package Notify;

public class Transaction {
	int Acc_ID;
	int Transaction_ID;
	String Transaction_Type;
	float Amount;
	String Password;
	String Acc_Holder_Name;
	String Email;
	int Mobile;
	
	public int getTransaction_ID() {
		return Transaction_ID;
	}
	public void setTransaction_ID(int transaction_ID) {
		Transaction_ID = transaction_ID;
	}
	public int getMobile() {
		return Mobile;
	}
	public void setMobile(int mobile) {
		this.Mobile = mobile;
	}
	public int getAcc_ID() {
		return Acc_ID;
	}
	public void setAcc_ID(int acc_ID) {
		Acc_ID = acc_ID;
	}
	public String getTransaction_Type() {
		return Transaction_Type;
	}
	public void setTransaction_Type(String transaction_Type) {
		Transaction_Type = transaction_Type;
	}
	public float getAmount() {
		return Amount;
	}
	public void setAmount(float amount) {
		Amount = amount;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getAcc_Holder_Name() {
		return Acc_Holder_Name;
	}
	public void setAcc_Holder_Name(String acc_Holder_Name) {
		Acc_Holder_Name = acc_Holder_Name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Transaction(int acc_ID, int mobile,int transaction_ID, String transaction_Type, float amount, String password, String acc_Holder_Name,
			String email) {
		Transaction_ID = transaction_ID;
		Mobile = mobile;
		Acc_ID = acc_ID;
		Transaction_Type = transaction_Type;
		Amount = amount;
		Password = password;
		Acc_Holder_Name = acc_Holder_Name;
		Email = email;
	}
	public Transaction() {}
}
