package com.thoughtworks.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("请给超市设置商品，格式如：apple 10");
        System.out.println("其中apple为商品名称，10为商品价格");
        System.out.println("输入finish完成设置");
        SuperMarket market = new SuperMarket();
        while(true){
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            if ("finish".equals(userInput)) break;
            String goodsName = userInput.split(" ")[0];
            BigDecimal price = BigDecimal.valueOf(Long.parseLong(userInput.split(" ")[1]));

            market.addGoods(new Goods(goodsName,price));
        }
        System.out.println("设置商品完成，查看商品列表如下：");
        System.out.println("------------------------------------------------");

        System.out.print(market.showGoodsList());

        System.out.println("------------------------------------------------");
        System.out.println("请选择以上哪些是促销商品，输入商品编号，以回车键结尾，如：1");
        System.out.println("输入finish完成促销商品的设置");
        Sales sales = new Sales();
        while(true){
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            if ("finish".equals(userInput)) break;
            sales.addSales(market.getGoods(Integer.parseInt(userInput)));
        }

        System.out.println("设置促销商品完成");
        System.out.println("------------------------------------------------");
        System.out.println("请开始选择要购买的商品，输入商品编号，以回车键结尾，如：0");
        System.out.println("输入finish完成设置");
        List<Goods> buyList = new ArrayList<>();
        while(true){
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            if ("finish".equals(userInput)) break;
            buyList.add(market.getGoods(Integer.parseInt(userInput)));
        }

        System.out.println("购买商品完成，正在计算积分");
        System.out.println("------------------------------------------------");
        Calculator calculator = new Calculator();
        BigDecimal result = calculator.calculate(buyList,sales);
        System.out.println("您获得了"+ result + "积分");

    }
}
