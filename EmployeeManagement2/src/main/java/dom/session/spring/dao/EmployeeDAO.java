package dom.session.spring.dao;

import java.util.List;

import dom.session.spring.model.Employee;

public interface EmployeeDAO {
	public void addEmployee(Employee e);
	public void updateEmployee(Employee e);
	public void removeEmployee(int id);
	public List<Employee> listEmployee();
	public Employee getEmployeeById(int id);

}