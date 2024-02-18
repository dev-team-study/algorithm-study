package changhyeon;

import java.util.ArrayDeque;
import java.util.Deque;

public class PRO_주식가격 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Stock> stocks = new ArrayDeque<>();

        for (int price : prices) {
            stocks.add(new Stock(price));
        }

        for (int i = 0; i < prices.length; i++) {
            Stock stock = stocks.poll();

            for (int j = i + 1; j < prices.length; j++) {
                stock.increaseSecond();
                if (stock.getPrice() > prices[j]) {
                    break;
                }
            }

            answer[i] = stock.getSecond();
        }

        return answer;
    }

    static class Stock {

        private int second;
        private int price;

        public Stock(int price) {
            this.second = 0;
            this.price = price;
        }

        public int getSecond() {
            return second;
        }

        public int getPrice() {
            return price;
        }

        public void increaseSecond() {
            second++;
        }
    }
}
