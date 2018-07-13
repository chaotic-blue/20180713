package CollectionTest;

import java.util.Formatter;

public class EmployeeDTO {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	//private항목 정의 후 소스 개터세터, toString 오버라이드 해줌
	private String JobId;
	private String HireDate;

	public String getEmployeeId() {
		return employeeId;
	}




	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getJobId() {
		return JobId;
	}




	public void setJobId(String jobId) {
		this.JobId = jobId;
	}




	public String getHireDate() {
		return HireDate;
	}


	public void setHireDate(String hireDate) {
		this.HireDate = hireDate;
	}




	@Override
	public String toString() {
		Formatter fm = new Formatter();
		String result = fm.format("%9s\t %-10s\t %-10s\t %-15s\t %-10s\t %-10s", employeeId, firstName, lastName, email, JobId, HireDate).toString();
		//return "EmployeeDTO [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				//+ ", email=" + email + "]";
		return result;
	}



	
}
