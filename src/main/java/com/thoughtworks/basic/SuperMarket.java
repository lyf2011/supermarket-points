package com.thoughtworks.basic;

import java.util.ArrayList;
import java.util.List;

public class SuperMarket {
    private List<Goods> goodsList = new ArrayList<>();

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public int addGoods(Goods goods) {
        goodsList.add(goods);
        return goodsList.size();
    }

    public String showGoodsList(){
        String goodsListString = "";
        for (int i = 0; i < goodsList.size(); i++) {
            Goods goods = goodsList.get(i);
            goodsListString += (i + " : " +goods.getName() + "    ￥" + goods.getCharge() + "\n");
        }
        return goodsListString;
    }

    public Goods getGoods(int i) {
        return goodsList.get(i);
    }
}
