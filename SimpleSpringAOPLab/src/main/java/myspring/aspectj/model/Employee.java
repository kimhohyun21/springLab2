package myspring.aspectj.model;

public class Employee {
	private String empName;

	public String getEmpName() {
		System.out.println("�ٷ����̸� : "+empName);
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}	
}
