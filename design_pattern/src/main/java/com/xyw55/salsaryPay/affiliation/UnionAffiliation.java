package com.xyw55.salsaryPay.affiliation;

import lombok.Data;

import java.util.List;

/**
 * 协会会员
 * Created by xiayiwei on 8/23/17.
 */
@Data
public class UnionAffiliation implements Affiliation {
    Double dues;
    List<ServiceCharge> serviceChargeList;

    @Override
    public Double calculateDeDuctions() {
        dues = 0.0;
        for (ServiceCharge serviceCharge :
                serviceChargeList) {
            dues += serviceCharge.getAmount();
        }
        return this.dues;
    }
}
