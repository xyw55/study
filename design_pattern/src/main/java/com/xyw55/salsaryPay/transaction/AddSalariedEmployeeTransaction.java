package com.xyw55.salsaryPay.transaction;

import com.xyw55.salsaryPay.paymentClass.SalariedClassfication;
import com.xyw55.salsaryPay.schedule.MonthlySchedule;

/**
 * 增加月新员工
 * Created by xiayiwei on 8/23/17.
 */
public class AddSalariedEmployeeTransaction extends AddEmployeeTransaction {
    Double salary;
    Double commissionRate;

    @Override
    public void execute() {
        super.execute();
        MonthlySchedule monthlySchedule = new MonthlySchedule();
        SalariedClassfication salariedClassfication = new SalariedClassfication();
    }
}
