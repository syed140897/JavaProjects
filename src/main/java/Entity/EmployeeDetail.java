package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class EmployeeDetail {

	@Id
	private Integer id;
	private String name;
	private String role;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "EmployeeDetail [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	public EmployeeDetail(Integer id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}
	public EmployeeDetail() {
		super();
	}
	
	
}
