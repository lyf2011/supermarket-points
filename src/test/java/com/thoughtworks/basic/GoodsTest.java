package com.thoughtworks.basic;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GoodsTest{
    @Test
    public void should_return_true_when_goods_is_in_sales(){
        Sales sales = new Sales();

        Goods good1 = new Goods("apple",  BigDecimal.valueOf(10));
        Goods good2 = new Goods("watermelon", BigDecimal.valueOf(30));

        sales.addSales(good1);

        assertThat(good1.isInSales(sales), is(true));
        assertThat(good2.isInSales(sales), is(false));
    }
}