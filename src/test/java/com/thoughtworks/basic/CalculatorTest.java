package com.thoughtworks.basic;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void should_return_3000_when_only_buy_2000_yuan_goods_in_sales(){
        Sales sales = new Sales();
        Calculator calculator = new Calculator();

        Goods good1 = new Goods("TV",  BigDecimal.valueOf(2000));

        sales.addSales(good1);

        BigDecimal result = calculator.calculate(Arrays.asList(good1),sales);

        MatcherAssert.assertThat(result, is(BigDecimal.valueOf(3000)));
    }

    @Test
    public void should_return_100_when_only_buy_100_yuan_normal_goods(){
        Sales sales = new Sales();
        Calculator calculator = new Calculator();

        Goods good1 = new Goods("apple",  BigDecimal.valueOf(40));
        Goods good2 = new Goods("watermelon", BigDecimal.valueOf(50));
        Goods good3 = new Goods("milk", BigDecimal.valueOf(10));

        BigDecimal result = calculator.calculate(Arrays.asList(good1,good2,good3),sales);

        MatcherAssert.assertThat(result, is(BigDecimal.valueOf(100)));
    }

    @Test
    public void should_return_2900_when_buy_3800_yuan_goods_in_sales_and_not_in_sales(){
        Sales sales = new Sales();
        Calculator calculator = new Calculator();

        Goods TV = new Goods("TV",  BigDecimal.valueOf(1800));
        Goods washer = new Goods("washer", BigDecimal.valueOf(2000));

        sales.addSales(TV);

        BigDecimal result = calculator.calculate(Arrays.asList(TV,washer),sales);

        MatcherAssert.assertThat(result, is(BigDecimal.valueOf(2900)));
    }

}
