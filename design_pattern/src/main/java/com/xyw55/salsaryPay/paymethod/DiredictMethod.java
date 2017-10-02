package com.xyw55.salsaryPay.paymethod;

import lombok.Data;

/**
 * 直接支付
 * Created by xiayiwei on 8/23/17.
 */
@Data
public class DiredictMethod implements PaymentMethod {
    String bank;
    String accout;

    @Override
    public Boolean pay(Double amount) {
        return true;
    }
}
