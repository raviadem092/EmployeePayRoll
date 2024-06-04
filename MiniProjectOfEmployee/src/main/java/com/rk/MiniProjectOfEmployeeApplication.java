package com.rk;

import java.util.List;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.rk.controller.PayrollOperation;
import com.rk.models.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class MiniProjectOfEmployeeApplication {

    private static final Logger logger = LogManager.getLogger(MiniProjectOfEmployeeApplication.class);

    public static void main(String[] args) {
        try {
            ApplicationContext ac = SpringApplication.run(MiniProjectOfEmployeeApplication.class, args);
            PayrollOperation pay = ac.getBean("payroll", PayrollOperation.class);

            List<Employee> list = pay.getAllEmpsDesigs("MANAGER", "CLERK", "ANALYST");
            list.forEach(emp -> logger.info(emp.toString()));

        } catch (BeansException e) {
            logger.error("Bean exception occurred", e);
        } catch (Exception e) {
            logger.error("Exception occurred", e);
        }
    }
}
