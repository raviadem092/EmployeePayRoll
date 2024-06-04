package com.rk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rk.models.Employee;

@Repository("empDAO")
public class EmployeeDAO implements IEmployeeDAO {

    private static final String QUERY = "SELECT * FROM EMPLOYEE WHERE JOB IN (?, ?, ?) ORDER BY JOB";

    @Autowired
    private DataSource source;

    @Override
    public List<Employee> getEmployeeByDesignation(String design1, String design2, String design3) throws Exception {
    	System.out.println("EmployeeDAO.getEmployeeByDesignation()");
        List<Employee> list = null;
        try (Connection con = source.getConnection();
             PreparedStatement pstmt = con.prepareStatement(QUERY)) {

            pstmt.setString(1, design1);
            pstmt.setString(2, design2);
            pstmt.setString(3, design3);

            try (ResultSet rs = pstmt.executeQuery()) {
            	list = new ArrayList<>();
                while (rs.next()) {
                    Employee emp = new Employee();
                    emp.setEid(rs.getInt(1));
                    emp.setEname(rs.getString(2));
                    emp.setJob(rs.getString(3));
                    emp.setSalary(rs.getFloat(4));
                    emp.setDeptno(rs.getInt(5));
                    emp.setGrossSal(rs.getFloat(6));
                    emp.setNetSal(rs.getFloat(7));
                    list.add(emp);
                }
            } catch (SQLException se) {
            	se.printStackTrace();
                throw se;
            }
	        } catch (Exception e) {
	        	e.printStackTrace();
	            throw e;
	        }
        return list;
    }

    @Override
    public void updateEmployeeNetAndGrossSal(Integer eid, Float netSal, Float grossSal) {
        String updateQuery = "UPDATE Employee SET netSal = ?, grossSal = ? WHERE eid = ?";
        
        try (Connection con = source.getConnection();
             PreparedStatement pstmt = con.prepareStatement(updateQuery)) {
            
            pstmt.setFloat(1, netSal);
            pstmt.setFloat(2, grossSal);
            pstmt.setInt(3, eid);
            
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
