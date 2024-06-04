package com.rk.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rk.dao.IEmployeeDAO;
import com.rk.models.Employee;

@Service("empService")
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeDAO empDao;

    @Override
    public List<Employee> fetchingAllEmpsDesigns(String design1, String design2, String design3) throws Exception {
        // Converting to uppercase
        design1 = design1.toUpperCase();
        design2 = design2.toUpperCase();
        design3 = design3.toUpperCase();

        // Fetch employees by designation
        List<Employee> list = empDao.getEmployeeByDesignation(design1, design2, design3);
        
        // Update each employee with net and gross salary and insert into the database
        for (Employee emp : list) {
            float salary = emp.getSalary();
            emp.setNetSal(salary + salary * 0.4f); // Net salary calculation
            emp.setGrossSal(salary - salary * 0.2f); // Gross salary calculation
            
            // Update the database with new net and gross salary values
            empDao.updateEmployeeNetAndGrossSal(emp.getEid(), emp.getNetSal(), emp.getGrossSal());
        }

        return list;
    }

}
