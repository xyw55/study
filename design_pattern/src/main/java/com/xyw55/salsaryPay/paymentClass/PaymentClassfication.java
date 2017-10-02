package com.xyw55.salsaryPay.paymentClass;

import java.util.Date;

/**
 * 支付薪水计算方式
 * Created by xiayiwei on 8/23/17.
 */
public interface PaymentClassfication {
    /**
     * 计算员工薪水
     * @param date 当前时间
     * @return
     */
    Double calculatePay(Date date);

    Double post(Date date);
}
