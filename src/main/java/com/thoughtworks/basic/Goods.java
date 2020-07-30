package com.thoughtworks.basic;

import java.math.BigDecimal;

public class Goods {

    private  String name;
    private BigDecimal charge;

    public String getName() {
        return name;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public Goods(String name, BigDecimal charge) {
        this.name = name;
        this.charge = charge;
    }

    public Boolean isInSales(Sales sales) {
        return sales.getSaleList().contains(this);
    }
}
