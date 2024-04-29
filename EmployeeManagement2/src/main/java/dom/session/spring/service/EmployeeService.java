package dom.session.spring.service;

import java.util.List;

import dom.session.spring.model.Employee;

public interface EmployeeService {
	public void addEmployee(Employee e);
	public void updateEmployee(Employee e);
	public void removeEmployee(int id);
	public List<Employee> listEmployee();
	public Employee getEmployeeById(int id);


}
