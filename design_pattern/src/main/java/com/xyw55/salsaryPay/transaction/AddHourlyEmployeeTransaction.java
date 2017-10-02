package com.xyw55.salsaryPay.transaction;

import com.xyw55.salsaryPay.employee.Employee;
import com.xyw55.salsaryPay.dao.PayrollDatabase;
import com.xyw55.salsaryPay.dao.PayrollDatabaseImpl;
import com.xyw55.salsaryPay.paymentClass.HourlyClassfication;
import com.xyw55.salsaryPay.paymethod.HoldMethod;
import com.xyw55.salsaryPay.schedule.WeeklySchedule;

/**
 * 增加小时员工
 * Created by xiayiwei on 8/23/17.
 */
public class AddHourlyEmployeeTransaction extends AddEmployeeTransaction{
    PayrollDatabase payrollDatabase = new PayrollDatabaseImpl();
    Double hourlyRate;

    @Override
    public void execute() {
        super.execute();
        Employee employee = new Employee();
        WeeklySchedule weeklySchedule = new WeeklySchedule();
        HourlyClassfication hourlyClassfication = new HourlyClassfication();
        HoldMethod holdMethod = new HoldMethod();

        employee.setSchedule(weeklySchedule);
        employee.setClassfication(hourlyClassfication);
        employee.setMethod(holdMethod);
        payrollDatabase.addEmployee(employee);
    }
}
