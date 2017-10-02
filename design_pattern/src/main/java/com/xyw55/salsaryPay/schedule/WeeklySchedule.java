package com.xyw55.salsaryPay.schedule;

import java.util.Date;

/**
 * Created by xiayiwei on 8/24/17.
 */
public class WeeklySchedule implements PaymentSchedule {

    @Override
    public Boolean isPayDay(Date date) {
        return true;
    }
}
