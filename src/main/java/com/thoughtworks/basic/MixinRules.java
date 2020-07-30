package com.thoughtworks.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MixinRules extends BasicRules{
    private final List<Goods> salesGoods = new ArrayList<Goods>();
    private final List<Goods> normalGoods = new ArrayList<Goods>();
    @Override
    BigDecimal calculate(BigDecimal money_amount) {
        BigDecimal salesGoodsAmount = aggregateSalesAmount();
        BigDecimal normalGoodsAmount = aggregateNormalAmount();
        if (isMoreThan1000(money_amount)){
            if (isMoreThan1000(salesGoodsAmount)){
                BigDecimal doubleSalePoints = LIMITRANGE.multiply(Multiple.DOUUBLE_MULTIPLE);
                BigDecimal singleSalePoints = salesGoodsAmount.subtract(LIMITRANGE).multiply(Multiple.SINGLE_MULTIPLE);
                BigDecimal percentNormalPoints = normalGoodsAmount.multiply(Multiple.PERCENT_MULTIPLE).setScale( 0, BigDecimal.ROUND_DOWN);
                return doubleSalePoints.add(singleSalePoints).add(percentNormalPoints);
            } else {
                BigDecimal salesGoodsPoints = salesGoodsAmount.multiply(Multiple.DOUUBLE_MULTIPLE);
                BigDecimal singleNormalPoints = LIMITRANGE.subtract(salesGoodsAmount).multiply(Multiple.SINGLE_MULTIPLE);
                BigDecimal percentNormalPoints = money_amount.subtract(LIMITRANGE).multiply(Multiple.PERCENT_MULTIPLE).setScale( 0, BigDecimal.ROUND_DOWN);
                return salesGoodsPoints.add(singleNormalPoints).add(percentNormalPoints);
            }
        } else {
            return salesGoodsAmount.multiply(Multiple.DOUUBLE_MULTIPLE).add(normalGoodsAmount.multiply(Multiple.SINGLE_MULTIPLE));
        }
    }

    @Override
    boolean isInScope(List<Goods> goodsList, Sales sales) {
        goodsList.stream().forEach(goods -> {
            if (goods.isInSales(sales)) {
                salesGoods.add(goods);
            } else {
                normalGoods.add(goods);
            }
        });
        return salesGoods.size() > 0 && normalGoods.size() > 0;
    }

    private BigDecimal aggregateSalesAmount(){
        return aggregate(salesGoods);
    }

    private BigDecimal aggregateNormalAmount(){
        return aggregate(normalGoods);
    }
}
