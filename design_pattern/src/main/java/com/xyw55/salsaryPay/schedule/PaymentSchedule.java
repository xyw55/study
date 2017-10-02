package com.xyw55.salsaryPay.schedule;

import java.util.Date;

/**
 * Created by xiayiwei on 8/24/17.
 */
public interface PaymentSchedule {

    /**
     * 今天是否是支付日
     * @param date 当前日期
     * @return
     */
    public Boolean isPayDay(Date date);
}
