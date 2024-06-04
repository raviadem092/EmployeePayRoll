package com.rk.controller;

import java.util.List;
import com.rk.models.Employee;

public interface IPayrollOperation {
    public List<Employee> getAllEmpsDesigs(String design1, String design2, String design3) throws Exception;
}
