package com.rk.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.rk.models.Employee;
import com.rk.service.IEmployeeService;

@Controller("payroll")
public class PayrollOperation implements IPayrollOperation {

    private static final Logger logger = LogManager.getLogger(PayrollOperation.class);

    @Autowired
    private IEmployeeService service;

    @Override
    public List<Employee> getAllEmpsDesigs(String design1, String design2, String design3) throws Exception {
        logger.info("Fetching employees with designations: {}, {}, {}", design1, design2, design3);
        List<Employee> employees = service.fetchingAllEmpsDesigns(design1, design2, design3);
        logger.info("Fetched employees: {}", employees);
        return employees;
    }
}
