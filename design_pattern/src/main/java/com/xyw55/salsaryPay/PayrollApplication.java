package com.xyw55.salsaryPay;

import com.xyw55.salsaryPay.transaction.Transaction;

/**
 * Created by xiayiwei on 8/26/17.
 */
public class PayrollApplication {

    public static void main(String[] args) {
        TransactionSource transactionSource = new TextParserTransactionSource();
        Transaction transaction = transactionSource.getTransaction();
        transaction.execute();
    }
}
