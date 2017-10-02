package com.xyw55.salsaryPay.paymentClass;

import lombok.Data;

import java.util.Date;

/**
 * Created by xiayiwei on 8/23/17.
 */
@Data
public class CommissionedClassfication implements PaymentClassfication {
    Double commissionRate;

    Double salary;

    @Override
    public Double calculatePay(Date date) {
        return 1.0;
    }

    @Override
    public Double post(Date date) {
        return null;
    }
}
