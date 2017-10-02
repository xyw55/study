package com.xyw55.salsaryPay;

import com.xyw55.salsaryPay.transaction.PayDayTransaction;
import com.xyw55.salsaryPay.transaction.Transaction;

/**
 * Created by xiayiwei on 8/26/17.
 */
public class TextParserTransactionSource implements TransactionSource {
    @Override
    public Transaction getTransaction() {
        return new PayDayTransaction();
    }
}
