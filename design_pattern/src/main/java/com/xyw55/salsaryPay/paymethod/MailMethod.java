package com.xyw55.salsaryPay.paymethod;

import lombok.Data;

/**
 * 邮寄支付
 * Created by xiayiwei on 8/23/17.
 */
@Data
public class MailMethod implements PaymentMethod {
    String address;

    @Override
    public Boolean pay(Double amount) {
        return true;
    }
}
