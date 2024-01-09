package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class OrderPlacedList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer order_Id;
	private String product_Name;
	private String account_Number;
	private String order_Place;
	
	public Integer getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(Integer order_Id) {
		this.order_Id = order_Id;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public String getAccount_Number() {
		return account_Number;
	}
	public void setAccount_Number(String account_Number) {
		this.account_Number = account_Number;
	}
	public String getOrder_Place() {
		return order_Place;
	}
	public void setOrder_Place(String order_Place) {
		this.order_Place = order_Place;
	}
	
	public OrderPlacedList(Integer order_Id, String product_Name, String account_Number, String order_Place) {
		super();
		this.order_Id = order_Id;
		this.product_Name = product_Name;
		this.account_Number = account_Number;
		this.order_Place = order_Place;
	}
	
	public OrderPlacedList() {
		super();
		
	}
	@Override
	public String toString() {
		return "OrderPlacedList [order_Id=" + order_Id + ", product_Name=" + product_Name + ", account_Number="
				+ account_Number + ", order_Place=" + order_Place + "]";
	}
	
	
	
	
	
}
