package com.thoughtworks.basic;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MixinRulesTest{
    @Test
    public void should_return_0_when_only_buy_40_yuan_goods_in_sale(){
        Sales sales = new Sales();

        Goods apple = new Goods("apple",  BigDecimal.valueOf(40));

        sales.addSales(apple);

        MixinRules mixinRules = new MixinRules();
        BigDecimal result = mixinRules.calculatePoints(Arrays.asList(apple),sales);

        assertThat(result, is(BigDecimal.valueOf(0)));
    }

    @Test
    public void should_return_0_when_only_buy_2350_yuan_normal_goods(){
        Sales sales = new Sales();

        Goods good1 = new Goods("TV",  BigDecimal.valueOf(2350));

        MixinRules mixinRules = new MixinRules();
        BigDecimal result = mixinRules.calculatePoints(Arrays.asList(good1),sales);

        assertThat(result, is(BigDecimal.valueOf(0)));
    }

    @Test
    public void should_return_100_when_buy_60_yuan_goods_in_sales_and_not_in_sales(){
        Sales sales = new Sales();

        Goods apple = new Goods("apple",  BigDecimal.valueOf(10));
        Goods watermelon = new Goods("watermelon", BigDecimal.valueOf(30));
        Goods milk = new Goods("milk", BigDecimal.valueOf(20));

        sales.addSales(apple);
        sales.addSales(watermelon);

        MixinRules mixinRules = new MixinRules();
        BigDecimal result = mixinRules.calculatePoints(Arrays.asList(apple,watermelon,milk),sales);

        assertThat(result, is(BigDecimal.valueOf(100)));
    }

    @Test
    public void should_return_1890_when_buy_2800_yuan_goods_in_sales_and_not_in_sales(){
        Sales sales = new Sales();

        Goods TV = new Goods("TV",  BigDecimal.valueOf(800));
        Goods washer = new Goods("washer", BigDecimal.valueOf(2000));

        sales.addSales(TV);

        MixinRules mixinRules = new MixinRules();
        BigDecimal result = mixinRules.calculatePoints(Arrays.asList(TV,washer),sales);

        assertThat(result, is(BigDecimal.valueOf(1890)));
    }

    @Test
    public void should_return_2900_when_buy_3800_yuan_goods_in_sales_and_not_in_sales(){
        Sales sales = new Sales();

        Goods TV = new Goods("TV",  BigDecimal.valueOf(1800));
        Goods washer = new Goods("washer", BigDecimal.valueOf(2000));

        sales.addSales(TV);

        MixinRules mixinRules = new MixinRules();
        BigDecimal result = mixinRules.calculatePoints(Arrays.asList(TV,washer),sales);

        assertThat(result, is(BigDecimal.valueOf(2900)));
    }
}