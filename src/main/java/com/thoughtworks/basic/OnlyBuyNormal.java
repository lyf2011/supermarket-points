package com.thoughtworks.basic;

import java.math.BigDecimal;
import java.util.List;

public class OnlyBuyNormal extends BasicRules {
    @Override
    BigDecimal calculate(BigDecimal money_amount) {
        if (isMoreThan1000(money_amount)){
            BigDecimal pointsLessThanLimit = LIMITRANGE.multiply(Multiple.SINGLE_MULTIPLE);
            BigDecimal pointsMoreThanLimit = money_amount.subtract(LIMITRANGE).multiply(Multiple.PERCENT_MULTIPLE).setScale( 0, BigDecimal.ROUND_DOWN);
            return pointsLessThanLimit.add(pointsMoreThanLimit);
        } else {
            return money_amount.multiply(Multiple.SINGLE_MULTIPLE);
        }
    }

    @Override
    boolean isInScope(List<Goods> goodsList, Sales sales) {
        return goodsList.stream().allMatch(goods -> !goods.isInSales(sales));
    }
}
