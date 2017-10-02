package com.xyw55.salsaryPay.transaction;

import com.xyw55.salsaryPay.dao.PayrollDatabase;
import com.xyw55.salsaryPay.dao.PayrollDatabaseImpl;
import com.xyw55.salsaryPay.employee.Employee;

import java.util.Date;
import java.util.List;

/**
 * Created by xiayiwei on 8/26/17.
 */
public class PayDayTransaction implements Transaction{
    private Date today = new Date();
    private PayrollDatabase payrollDatabase = new PayrollDatabaseImpl();
    private List<Employee> employeeList = payrollDatabase.getEmployees();

    @Override
    public void execute() {
        for (Employee employee :
                employeeList) {
            employee.payDay(today);
        }
    }



}
