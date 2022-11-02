package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.IEmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	private final IEmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl( IEmployeeRepository theemployeeRepository) { 
																							  
		employeeRepository = theemployeeRepository;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {


		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(Integer theId) {
		
		// seti se Optional tipa koji je uveden u javu8 (OptionalDouble, OptionalInt etc....)
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if(result.isPresent()) { // isPresent() => proverava da li postoji rezultat, vraca boolean
			theEmployee = result.get(); // ukoliko postoji rezultat, popuni instancu theEmployee
		}else {
			// we didn't found the employee, throw exception
			throw new RuntimeException("Did not find employee id - " +theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		
		employeeRepository.save(employee);

	}

	@Override
	public void deleteById(Integer theId) {
		
		employeeRepository.deleteById(theId);

	}

}
