package GreedyAlgorithm;

public class Greedy {
}

//leetcode.121 买卖股票的最佳时机
class Solution1{
//    public int maxProfit(int[] prices) {
//        int pos = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                if(prices[j] - prices[i] > pos) pos = prices[j] - prices[i];
//            }
//        }
//        return pos;
//    }暴力，超时了
public int maxProfit(int prices[]) {
    int minprice = Integer.MAX_VALUE;
    int maxprofit = 0;
    for (int i = 0; i < prices.length; i++) {
        if (prices[i] < minprice) {
            minprice = prices[i];
        } else if (prices[i] - minprice > maxprofit) {
            maxprofit = prices[i] - minprice;
        }
    }
    return maxprofit;
}
//方法二，一次遍历
}
