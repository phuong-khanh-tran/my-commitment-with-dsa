public class BestTimeToBuyAndSellStockSolution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int best = 0;

        for (int price : prices) {
            best = Math.max(best, price - min);
            min = Math.min(min, price);
        }
        return best;
    }
}
