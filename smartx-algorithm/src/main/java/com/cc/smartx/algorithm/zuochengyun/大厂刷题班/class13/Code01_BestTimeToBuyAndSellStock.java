package com.cc.smartx.algorithm.zuochengyun.大厂刷题班.class13;

// leetcode 121
public class Code01_BestTimeToBuyAndSellStock {

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int min = prices[0];
		int ans = 0;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			ans = Math.max(ans, prices[i] - min);
		}
		return ans;
	}

}
