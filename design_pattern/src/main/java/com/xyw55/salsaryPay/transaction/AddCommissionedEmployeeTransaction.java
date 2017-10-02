package com.xyw55.salsaryPay.transaction;

import com.xyw55.salsaryPay.paymentClass.CommissionedClassfication;
import com.xyw55.salsaryPay.schedule.BiWeeklySchedule;

/**
 * 增加销售员工
 * Created by xiayiwei on 8/23/17.
 */
public class AddCommissionedEmployeeTransaction extends AddEmployeeTransaction {
    Double salary;

    @Override
    public void execute() {
        super.execute();
        BiWeeklySchedule biWeeklySchedule = new BiWeeklySchedule();
        CommissionedClassfication commissionedClassfication = new CommissionedClassfication();
    }
}
