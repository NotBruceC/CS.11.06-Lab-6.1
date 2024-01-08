package stocksimulator;


import java.io.IOException;
import java.util.Random;

import static stocksimulator.StockMarket.day;


public class Stocks {

    public static double AAPL(String fileName) throws IOException {
        int[] SPC = StockMarket.StockCallMethods.readFile(fileName);
        Random random = new Random();
        int a = random.nextInt(SPC.length);
        double stockPrice = SPC[a];
        return stockPrice;
    }



}
