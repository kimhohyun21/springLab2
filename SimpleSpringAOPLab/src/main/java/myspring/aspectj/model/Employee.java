package myspring.aspectj.model;

public class Employee {
	private String empName;

	public String getEmpName() {
		System.out.println("근로자이름 : "+empName);
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}	
}
