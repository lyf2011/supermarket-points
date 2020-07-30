package com.thoughtworks.basic;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OnlyBuySalesTest{
    @Test
    public void should_return_100_when_only_buy_50_yuan_goods_in_sales(){
        Sales sales = new Sales();

        Goods good1 = new Goods("apple",  BigDecimal.valueOf(10));
        Goods good2 = new Goods("watermelon", BigDecimal.valueOf(30));
        Goods good3 = new Goods("milk", BigDecimal.valueOf(20));

        sales.addSales(good1);
        sales.addSales(good2);
        sales.addSales(good3);

        OnlyBuySales onlyBuySales = new OnlyBuySales();
        BigDecimal result = onlyBuySales.calculatePoints(Arrays.asList(good2,good3),sales);

        assertThat(result, is(BigDecimal.valueOf(100)));
    }

    @Test
    public void should_return_0_when_buy_goods_in_sales_and_not_in_sales(){
        Sales sales = new Sales();

        Goods good1 = new Goods("apple",  BigDecimal.valueOf(10));
        Goods good2 = new Goods("watermelon", BigDecimal.valueOf(30));
        Goods good3 = new Goods("milk", BigDecimal.valueOf(20));

        sales.addSales(good1);
        sales.addSales(good2);

        OnlyBuySales onlyBuySales = new OnlyBuySales();
        BigDecimal result = onlyBuySales.calculatePoints(Arrays.asList(good2,good3),sales);

        assertThat(result, is(BigDecimal.valueOf(0)));
    }

    @Test
    public void should_return_3000_when_only_buy_2000_yuan_goods_in_sales(){
        Sales sales = new Sales();

        Goods good1 = new Goods("TV",  BigDecimal.valueOf(2000));

        sales.addSales(good1);

        OnlyBuySales onlyBuySales = new OnlyBuySales();
        BigDecimal result = onlyBuySales.calculatePoints(Arrays.asList(good1),sales);

        assertThat(result, is(BigDecimal.valueOf(3000)));
    }

}