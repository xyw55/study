package com.xyw55.salsaryPay;

import com.xyw55.salsaryPay.transaction.Transaction;

/**
 * Created by xiayiwei on 8/26/17.
 */
public interface TransactionSource {
    public Transaction getTransaction();
}
