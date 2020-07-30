package com.thoughtworks.basic;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SalesTest {
    @Test
    public void should_return_same_goods_when_addSales_and_getSale(){
        Sales sales = new Sales();

        Goods good1 = new Goods("apple",  BigDecimal.valueOf(10));
        Goods good2 = new Goods("watermelon", BigDecimal.valueOf(30));
        Goods good3 = new Goods("milk", BigDecimal.valueOf(20));

        int length = 0;
        sales.addSales(good1);
        sales.addSales(good2);
        length = sales.addSales(good3);

        Goods sale = sales.getSale(0);

        assertThat(sale.getName(), is("apple"));
        assertThat(length, is(3));
    }

    @Test
    public void should_has_correct_goods_when_removeSales(){
        Sales sales = new Sales();

        Goods good1 = new Goods("apple",  BigDecimal.valueOf(10));
        Goods good2 = new Goods("watermelon", BigDecimal.valueOf(30));
        Goods good3 = new Goods("milk", BigDecimal.valueOf(20));

        sales.addSales(good1);
        sales.addSales(good2);
        sales.addSales(good3);

        Goods removeGoods = sales.removeSales(1);

        Goods sale = sales.getSale(1);

        assertThat(sale.getName(), is("milk"));
        assertThat(removeGoods.getName(), is("watermelon"));
    }
}