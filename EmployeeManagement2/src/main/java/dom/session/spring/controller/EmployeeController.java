package dom.session.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dom.session.spring.model.Employee;
import dom.session.spring.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	
	@Autowired
	EmployeeService employeeService;
	
	/*@Qualifier(value="employeeService")
	public void setEmployeeService(EmployeeService es){
		this.employeeService = es;
	}*/
	
	@RequestMapping(value="/",method= RequestMethod.GET)
	public String showEmployee(Model model) {
		model.addAttribute("employeex",new Employee());
		model.addAttribute("listemployees",this.employeeService.listEmployee());
		
		return "employees";
		
	}/**/
	
	/*@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String listEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		List <Employee> employees = employeeService.listEmployee();
		System.out.println("List :"+employees);
		model.addAttribute("listemployee", employees);
		return "employee";
	}*/
	
	//For add and update person both
	@RequestMapping(value= "/employee/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee e){
		
		if(e.getId() == 0){
			//new person, add it
			this.employeeService.addEmployee(e);
		}else{
			//existing person, call update
			this.employeeService.updateEmployee(e);
		}
		
		return "redirect:/employees/";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){
		
        this.employeeService.removeEmployee(id);
        return "redirect:/employees/";
    }
 
	@RequestMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model){
		model.addAttribute("employeex",employeeService.getEmployeeById(id));
		model.addAttribute("listemployees",this.employeeService.listEmployee());
		return "employees";
    }
	
}
