package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
	private Integer product_Id;
	private String product_Name;
	private Double product_Price;
	
	public Product() {
		super();
	}
	public Product(Integer productId, String productName, Double productPrice) {
		super();
		product_Id = productId;
		product_Name = productName;
		product_Price = productPrice;
	}
	public Integer getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(Integer product_Id) {
		this.product_Id = product_Id;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public Double getProduct_Price() {
		return product_Price;
	}
	public void setProduct_Price(Double product_Price) {
		this.product_Price = product_Price;
	}
	@Override
	public String toString() {
		return "Product [product_Id=" + product_Id + ", product_Name=" + product_Name + ", product_Price="
				+ product_Price + "]";
	}

	
	
	

}
