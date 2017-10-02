package com.xyw55.salsaryPay.dao;

import com.xyw55.salsaryPay.employee.Employee;

import java.util.List;

/**
 * Created by xiayiwei on 8/24/17.
 */
public interface PayrollDatabase {
    Employee getEmployee(int empId);

    List<Employee> getEmployees();

    void addEmployee(Employee employee);

    void delEmployee(int empId);



}
