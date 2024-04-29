package dom.session.spring.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;



import dom.session.spring.model.Employee;
@Repository
@EnableTransactionManagement
public class EmployeeDAOImpl implements EmployeeDAO{

	private SessionFactory sessionFactory;
	Session session;
	public EmployeeDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
		this.session = sessionFactory.openSession();
	}
	

	@Override
	public void addEmployee(Employee e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(e);
		System.out.println("Employee added Successfully,Employee Details="+e);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(Employee e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(e);
		System.out.println("Employee updated successfully, employee Details="+e);


		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee e = (Employee) session.load(Employee.class, new Integer(id));
		if(null != e){
			session.delete(e);
		}
		System.out.println("Person deleted successfully, person details="+e);
//		logger.info("Person deleted successfully, person details="+p);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployee() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> employeeList = session.createQuery("from Employee").list();
		for(Employee e : employeeList){
			System.out.println("Person List::"+e);

		}
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		/*	Session session = this.sessionFactory.getCurrentSession();		
		Person p = (Person) session.load(Person.class, new Integer(id));
		System.out.println("Person loaded successfully, Person details="+p);
//		logger.info("Person loaded successfully, Person details="+p);
		return p;*/
		Employee employee = new Employee();
		Transaction tx = session.beginTransaction();
		employee = session.get(Employee.class, id);
		tx.commit();
		return employee;
		 
	}

}
