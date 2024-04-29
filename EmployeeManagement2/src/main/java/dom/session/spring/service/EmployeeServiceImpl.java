package dom.session.spring.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import dom.session.spring.dao.EmployeeDAO;
import dom.session.spring.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDAO employeeDao;

	public void setEmployeeDao(EmployeeDAO employeedao) {
		this.employeeDao = employeedao;
	}

	@Override
	@Transactional
	public void addEmployee(Employee e) {
		this.employeeDao.addEmployee(e);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void updateEmployee(Employee e) {
		this.employeeDao.updateEmployee(e);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void removeEmployee(int id) {
		this.employeeDao.removeEmployee(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<Employee> listEmployee() {
		// TODO Auto-generated method stub
		return this.employeeDao.listEmployee();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		return this.employeeDao.getEmployeeById(id);
	}
}
