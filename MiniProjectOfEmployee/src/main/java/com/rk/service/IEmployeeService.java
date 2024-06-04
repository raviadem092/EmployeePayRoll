package com.rk.service;

import java.util.List;
import com.rk.models.Employee;

public interface IEmployeeService {
    public List<Employee> fetchingAllEmpsDesigns(String design1, String design2, String design3) throws Exception;
}
