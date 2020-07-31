package com.thoughtworks.basic;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SuperMarketTest{
    @Test
    public void should_return_3_goods_when_add_3_goods(){
        SuperMarket market = new SuperMarket();
        Goods apple = new Goods("apple",  BigDecimal.valueOf(10));
        Goods watermelon = new Goods("watermelon", BigDecimal.valueOf(30));
        Goods milk = new Goods("milk", BigDecimal.valueOf(20));

        market.addGoods(apple);
        market.addGoods(watermelon);
        market.addGoods(milk);

        assertThat(market.getGoodsList().size(), is(3));
    }

    @Test
    public void should_return_apple_when_get_first_goods(){
        SuperMarket market = new SuperMarket();
        Goods apple = new Goods("apple",  BigDecimal.valueOf(10));
        Goods watermelon = new Goods("watermelon", BigDecimal.valueOf(30));
        Goods milk = new Goods("milk", BigDecimal.valueOf(20));

        market.addGoods(apple);
        Goods result = market.getGoods(0);

        assertThat(result, is(apple));
    }
}