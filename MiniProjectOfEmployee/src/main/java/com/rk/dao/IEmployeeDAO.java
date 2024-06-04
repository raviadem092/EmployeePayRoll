package com.rk.dao;

import java.util.List;
import com.rk.models.Employee;

public interface IEmployeeDAO {
    public List<Employee> getEmployeeByDesignation(String design1, String design2, String design3) throws Exception;

	public void updateEmployeeNetAndGrossSal(Integer eid, Float netSal, Float grossSal);
}
