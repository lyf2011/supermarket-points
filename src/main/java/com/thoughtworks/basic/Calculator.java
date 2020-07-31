package com.thoughtworks.basic;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private List<BasicRules> rules = Arrays.asList(new OnlyBuySales(), new OnlyBuyNormal(), new MixinRules());

    public BigDecimal calculate(List<Goods> goodsList, Sales sales) {
        return rules.stream().map(rule -> rule.calculatePoints(goodsList,sales))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
