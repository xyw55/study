package com.xyw55.salsaryPay.paymethod;

/**
 * 在财务那
 * Created by xiayiwei on 8/23/17.
 */
public class HoldMethod implements PaymentMethod {
    @Override
    public Boolean pay(Double amount) {
        return true;
    }
}
