package com.thoughtworks.basic;

import java.math.BigDecimal;
import java.util.List;

public class OnlyBuySales extends BasicRules{
    @Override
    BigDecimal calculate(BigDecimal money_amount) {
        if (isMoreThan1000(money_amount)){
            BigDecimal pointsLessThanLimit = LIMITRANGE.multiply(Multiple.DOUUBLE_MULTIPLE);
            BigDecimal pointsMoreThanLimit = money_amount.subtract(LIMITRANGE).multiply(Multiple.SINGLE_MULTIPLE);
            return pointsLessThanLimit.add(pointsMoreThanLimit);
        } else {
            return money_amount.multiply(Multiple.DOUUBLE_MULTIPLE);
        }
    }

    @Override
    boolean isInScope(List<Goods> goodsList, Sales sales) {
        return !goodsList.stream().anyMatch(goods -> !goods.isInSales(sales));
    }
}
