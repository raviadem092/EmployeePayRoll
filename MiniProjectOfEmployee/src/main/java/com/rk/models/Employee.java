package com.rk.models;

import lombok.Data;

@Data
public class Employee {
    private Integer eid;
    private String ename;
    private String job;
    private Float salary;
    private Integer deptno;
    private Float grossSal;
    private Float netSal;
}
