package com.xyw55.salsaryPay.transaction;

import com.xyw55.salsaryPay.dao.PayrollDatabase;
import com.xyw55.salsaryPay.dao.PayrollDatabaseImpl;
import lombok.Setter;

/**
 * Created by xiayiwei on 8/24/17.
 */
public class DeleteEmployeeTransaction implements Transaction {
    PayrollDatabase payrollDatabase = new PayrollDatabaseImpl();
    @Setter
    int empId;

    @Override
    public void execute() {
        payrollDatabase.delEmployee(empId);

    }
}
