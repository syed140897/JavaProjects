package Entity;

public class EmployeeDetails {

	private int id;
	private String name;
	private String role;
	private double salary;
	private boolean freshers;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isFreshers() {
		return freshers;
	}
	public void setFreshers(boolean freshers) {
		this.freshers = freshers;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", name=" + name + ", role=" + role + ", salary=" + salary + ", freshers="
				+ freshers + "]";
	}
	
	
}
