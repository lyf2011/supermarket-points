package com.thoughtworks.basic;

import java.math.BigDecimal;
import java.util.List;

public class Calculator {

    public BigDecimal calculate(List<Goods> goodsList, Sales sales, List<BasicRules> rules) {
        return rules.stream().map(rule -> rule.calculatePoints(goodsList,sales))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
