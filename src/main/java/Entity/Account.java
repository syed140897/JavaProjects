package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {
	
	@Id
	private String account_Number;
	private String account_Name;
	private Double account_Balance;
	
	public String getAccount_Number() {
		return account_Number;
	}
	public void setAccount_Number(String account_Number) {
		this.account_Number = account_Number;
	}
	public String getAccount_Name() {
		return account_Name;
	}
	public void setAccount_Name(String account_Name) {
		this.account_Name = account_Name;
	}
	public Double getAccount_Balance() {
		return account_Balance;
	}
	public void setAccount_Balance(Double account_Balance) {
		this.account_Balance = account_Balance;
	}
	public Account(String account_Number, String account_Name, Double account_Balance) {
		super();
		this.account_Number = account_Number;
		this.account_Name = account_Name;
		this.account_Balance = account_Balance;
	}
	public Account() {
		super();
		
	}
	@Override
	public String toString() {
		return "Account [account_Number=" + account_Number + ", account_Name=" + account_Name + ", account_Balance="
				+ account_Balance + "]";
	}
	
	
	

}
