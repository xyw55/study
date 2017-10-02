package com.xyw55.salsaryPay.employee;

import com.xyw55.salsaryPay.affiliation.Affiliation;
import com.xyw55.salsaryPay.paymentClass.PaymentClassfication;
import com.xyw55.salsaryPay.paymethod.PaymentMethod;
import com.xyw55.salsaryPay.schedule.PaymentSchedule;
import lombok.Data;

import java.util.Date;

/**
 * 员工
 * Created by xiayiwei on 8/23/17.
 */
@Data
public class Employee {
    String name;
    String address;
    PaymentSchedule schedule;
    PaymentClassfication classfication;
    PaymentMethod method;
    Affiliation affiliation;
    Date lastPayDate;

    /**
     * 计算是否支付薪水
     * @param today 当前时间
     */
    public void payDay(Date today) {
        // 是否是支付日
        if (schedule.isPayDay(today)) {
            Double amount = classfication.calculatePay(today);
            method.pay(amount);
            post(today);
        }
    }


    /**
     * 登记支付信息
     * @param date 支付时间
     */
    public void post(Date date) {
        this.lastPayDate = date;
    }
}
