import java.util.*;

class Card {
    int type;
    int count;
    long buyingPrice;
    long sellingPrice;

    public Card(int type, int count, long buyingPrice, long sellingPrice) {
        this.type = type;
        this.count = count;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
    }

    public long cost() {
        if (this.count == 0) {
            return 2 * buyingPrice;  // need to buy 2 cards
        } else if (this.count == 1) {
            return buyingPrice + sellingPrice;  // need to buy 1 card
        } else {
            return 2 * sellingPrice;  // might sell 2 cards
        }
    }
}

public class CardTrading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int k = sc.nextInt();

        int[] totalCards = new int[t];
        for (int i = 0; i < n; i++) {
            totalCards[sc.nextInt() - 1]++;
        }

        Card[] myCards = new Card[t];

        for (int i = 0; i < t; i++) {
            long buyingPrice = sc.nextLong();
            long sellingPrice = sc.nextLong();
            int count = totalCards[i];
            myCards[i] = new Card(i + 1, count, buyingPrice, sellingPrice);
        }

        Arrays.sort(myCards, Comparator.comparingLong(Card::cost)); // sort by cost

        long profit = 0;
        int combo = 0;

        for (int i = 0; i < k; i++) {
            if (myCards[i].count < 2) { // buy missing combo
                profit -= (2 - myCards[i].count) * myCards[i].buyingPrice;
            }
            combo++;
        }

        for (int i = k; i < t; i++) {
            profit += myCards[i].count * myCards[i].sellingPrice; // sell remaining cards
        }

        System.out.println(profit);
    }
}













