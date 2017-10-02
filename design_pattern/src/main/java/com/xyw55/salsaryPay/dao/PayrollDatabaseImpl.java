package com.xyw55.salsaryPay.dao;

import com.xyw55.salsaryPay.employee.Employee;
import com.xyw55.salsaryPay.employee.HourlyEmployee;
import com.xyw55.salsaryPay.paymentClass.HourlyClassfication;
import com.xyw55.salsaryPay.paymethod.MailMethod;
import com.xyw55.salsaryPay.schedule.WeeklySchedule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiayiwei on 8/24/17.
 */
public class PayrollDatabaseImpl implements PayrollDatabase {
    @Override
    public Employee getEmployee(int empId) {
        return new HourlyEmployee();
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new HourlyEmployee();
        employee.setName("55");
        employee.setAddress("555");
        employee.setMethod(new MailMethod());
        employee.setSchedule(new WeeklySchedule());
        employee.setClassfication(new HourlyClassfication());
        employeeList.add(employee);
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public void delEmployee(int empId) {

    }
}
