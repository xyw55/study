package com.xyw55.salsaryPay.paymethod;


/**
 * Created by xiayiwei on 8/23/17.
 */
public interface PaymentMethod {

    /**
     * 支付薪水
     * @param amount 薪水金额
     * @return
     */
    public Boolean pay(Double amount);
}
