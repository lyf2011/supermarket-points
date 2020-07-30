package com.thoughtworks.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sales {
    private List<Goods> sales = new ArrayList();

    public int addSales(Goods good) {
        this.sales.add(good);
        return sales.size();
    }

    public Goods getSale(int index) {
        return this.sales.get(index);
    }

    public Goods removeSales(int i) {
        return this.sales.remove(i);
    }

    public List<Goods> getSaleList() {
        return sales;
    }
}
