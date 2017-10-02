package com.xyw55.salsaryPay.affiliation;

/**
 * 非协会会员
 * Created by xiayiwei on 8/23/17.
 */
public class NoAffiliation implements Affiliation{
    @Override
    public Double calculateDeDuctions() {
        return 0.0;
    }
}
