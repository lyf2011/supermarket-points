package com.thoughtworks.basic;

import java.math.BigDecimal;
import java.util.List;

abstract class BasicRules {
    protected BigDecimal LIMITRANGE = BigDecimal.valueOf(1000);

    abstract BigDecimal calculate(BigDecimal money_amount);
    abstract boolean isInScope(List<Goods> goodsList, Sales sales);

    public boolean isMoreThan1000(BigDecimal money_amount){
        return LIMITRANGE.compareTo(money_amount) <= -1;
    }

    BigDecimal calculatePoints(List<Goods> goodsList, Sales saleList) {
        if (isInScope(goodsList, saleList)) {
            return calculate(aggregate(goodsList));
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal aggregate(List<Goods> goodsList){
        return goodsList.stream().map(Goods::getCharge).reduce(BigDecimal.ZERO,BigDecimal::add);
    }
}
