package stocksimulator;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class StockMarket {
    static int day = 1;
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the Stock Market!");
        slowPrint("Please enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String Name = scanner.nextLine();
        System.out.println("Dear " + Name + ", Here are the rules to this game");
        slowPrint("" +
                "Objectives\n" +
                "A) Earn as much as possible using your money ($10000)\n" +
                "B) Buy the best stocks possible in the market\n" +
                "C) Have fun \n" +
                "\n" +
                "Stock Choices\n" +
                "Apple (APPL)\n" +
                "Microsoft (MSFT)\n" +
                "Google (GOOG)\n" +
                "Amazon (AMZN)\n" +
                "NVIDIA (NVDA)\n" +
                "Meta (META)\n" +
                "Berkshire Hathaway (BRK-B)\n" +
                "Tesla (TSLA)\n" +
                "Eli Lilly (LLY)\n" +
                "\n" +
                "Here are the instructions to this game: \n" +
                "This Game has five in-game days.\n" +
                "Make sure to maximize your profit\n" +
                "Make sure to check the data given every day\n" +
                "You can buy and sell stocks in the stock market.\n" +
                "You will have a buying power of USD 10000\n" +
                "Each stock has different prices and can rise/fall\n");

        while (day <= 5) {
            slowPrint("Would you like to skip day " + day + " or buy/sell stock in the stock market?\n" +
                    "Enter 1 to skip the day, 2 to buy or sell");
            Scanner scanner2 = new Scanner(System.in);
            String Option = scanner2.nextLine();

            if (Option.equals("1")) {
                day++;
            } else if (Option.equals("2") && day == 1) {
                slowPrint("Which stocks would you like to buy?");
                slowPrint("Enter 1 for Eli Lilly (LLY), 2 for Apple (AAPL), or 3 for Google (GOOG)");
                Scanner scanner4 = new Scanner(System.in);
                String stkchoice = scanner4.nextLine();

                if (stkchoice.equals("1")) {
                    StockCallMethods.callEliLilly();
                } else if (stkchoice.equals("2")) {
                    StockCallMethods.callApple();
                } else if (stkchoice.equals("3")) {
                    StockCallMethods.callGoogle();
                } else {
                    slowPrint("Invalid choice. Please try again.");
                    continue; // Restart the loop
                }
                slowPrint("You have successfully bought the stocks.");

            } else if (Option.equals("2") && day > 1) {

                    slowPrint("Which stocks would you like to buy?");
                    Scanner scanner3 = new Scanner(System.in);
                    String choice = scanner3.nextLine();
                    slowPrint("Enter 1 for Eli Lilly (LLY), 2 for Apple (AAPL), or 3 for Google (GOOG)");
                    Scanner scanner4 = new Scanner(System.in);
                    String stkchoice2 = scanner4.nextLine();

                    if (stkchoice2.equals("1")) {
                        StockCallMethods.callEliLilly();
                    } else if (stkchoice2.equals("2")) {
                        StockCallMethods.callApple();
                    } else if (stkchoice2.equals("3")) {
                        StockCallMethods.callGoogle();
                    } else {
                        slowPrint("Invalid choice. Please try again.");
                        continue; // Restart the loop
                    }
                    slowPrint("Well.");
                }
            }
        }
    public static void slowPrint(String output) {
        for (int i = 0; i<output.length(); i++) {
            char c = output.charAt(i);
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(12);
            }
            catch (Exception e) {
            }
        }
    }
    public static int Portfolio() {
        int balance = 10000;
        System.out.println("Portfolio Balance: $" + balance);
        String[] stocks = { "Stock A", "Stock B", "Stock C" };
        System.out.println("Stocks in Portfolio: " + Arrays.toString(stocks));
        return balance;
    }
    public static void Portfolio(int finalBalance, String[] stocks) {
        System.out.println("Final balance: $" + finalBalance);
        System.out.println("Stocks in Portfolio: " + Arrays.toString(stocks));
    }



    public class StockCallMethods  {
        public static void callEliLilly() {
            int CurrentBalance = Portfolio();
            int sharesOwnedLLY = 0;

            double stockPrice = 0.0;

            System.out.println("Calling EliLilly (LLY) stock method with price: " + stockPrice);

            if (CurrentBalance >= stockPrice) {
                // Buy shares
                int sharesToBuy = (int) (CurrentBalance / stockPrice);
                slowPrint("you can buy " + sharesToBuy + " shares");

                slowPrint("Enter a valid number to buy that amount of shares");
                Scanner scanner4 = new Scanner(System.in);
                int number = Integer.parseInt(scanner4.nextLine());

                sharesOwnedLLY += number;
                CurrentBalance -= number * stockPrice;
                System.out.println("Bought " + number + " shares of LLY at price " + stockPrice);
            } else if (sharesOwnedLLY > 0) {
                // Sell shares
                int sellAmount = sharesOwnedLLY;

                slowPrint("Enter a valid number to sell that amount of shares");
                Scanner scanner4 = new Scanner(System.in);
                int number = Integer.parseInt(scanner4.nextLine());

                CurrentBalance += number * stockPrice;
                sharesOwnedLLY-=number;
                System.out.println("Sold all shares of LLY at price " + stockPrice);
            }

            // Calculate final balance
            int finalBalance = CurrentBalance;
            System.out.println("Final balance: " + finalBalance);
            int profit = finalBalance - CurrentBalance;
            System.out.println("Profit: " + profit);

            // Update portfolio
            String[] stocks = new String[]{"LLY"};
            Portfolio(finalBalance, stocks);
        }

        public static void callApple() {
            int CurrentBalance = Portfolio();
            int sharesOwnedAAPL = 0;

            double stockPrice = 0.0;

            System.out.println("Calling Apple (AAPL) stock method with price: " + stockPrice);

            if (CurrentBalance >= stockPrice) {
                // Buy shares
                int sharesToBuy = (int) (CurrentBalance / stockPrice);
                slowPrint("you can buy " + sharesToBuy + " shares");

                slowPrint("Enter a valid number to buy that amount of shares");
                Scanner scanner4 = new Scanner(System.in);
                int number = Integer.parseInt(scanner4.nextLine());

                sharesOwnedAAPL += number;
                CurrentBalance -= number * stockPrice;
                System.out.println("Bought " + number + " shares of GOOG at price " + stockPrice);
            } else if (sharesOwnedAAPL > 0) {
                // Sell shares
                int sellAmount = sharesOwnedAAPL;

                slowPrint("Enter a valid number to sell that amount of shares");
                Scanner scanner4 = new Scanner(System.in);
                int number = Integer.parseInt(scanner4.nextLine());

                CurrentBalance += number * stockPrice;
                sharesOwnedAAPL-=number;
                System.out.println("Sold all shares of GOOG at price " + stockPrice);
            }

            // Calculate final balance
            int finalBalance = CurrentBalance;
            System.out.println("Final balance: " + finalBalance);
            int profit = finalBalance - CurrentBalance;
            System.out.println("Profit: " + profit);

            // Update portfolio
            String[] stocks = new String[]{"GOOG"};
            Portfolio(finalBalance, stocks);
        }

        public static void callGoogle() {
            int CurrentBalance = Portfolio();
            int sharesOwnedGooG = 0;

            double stockPrice = 0.0;

            System.out.println("Calling Google (GOOG) stock method with price: " + stockPrice);

            if (CurrentBalance >= stockPrice) {
                // Buy shares
                int sharesToBuy = (int) (CurrentBalance / stockPrice);
                slowPrint("you can buy " + sharesToBuy + " shares");

                slowPrint("Enter a valid number to buy that amount of shares");
                Scanner scanner4 = new Scanner(System.in);
                int number = Integer.parseInt(scanner4.nextLine());

                sharesOwnedGooG += number;
                CurrentBalance -= number * stockPrice;
                System.out.println("Bought " + number + " shares of GOOG at price " + stockPrice);
            } else if (sharesOwnedGooG > 0) {
                // Sell shares
                int sellAmount = sharesOwnedGooG;

                slowPrint("Enter a valid number to sell that amount of shares");
                Scanner scanner4 = new Scanner(System.in);
                int number = Integer.parseInt(scanner4.nextLine());

                CurrentBalance += number * stockPrice;
                sharesOwnedGooG-=number;
                System.out.println("Sold all shares of GOOG at price " + stockPrice);
            }

            // Calculate final balance
            int finalBalance = CurrentBalance;
            System.out.println("Final balance: " + finalBalance);
            int profit = finalBalance - CurrentBalance;
            System.out.println("Profit: " + profit);

            // Update portfolio
            String[] stocks = new String[]{"GOOG"};
            Portfolio(finalBalance, stocks);
        }





        private static void writeFileAllAnswers(String outPutFilename) throws IOException {
            File file = new File(outPutFilename);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.close();
        }

        private static int[] readFile(String inputFilename) throws FileNotFoundException {
            File file = new File(inputFilename);
            Scanner scanner = new Scanner(file);
            int numberOfLinesInFile = countLinesInFile(inputFilename);
            int[] data = new int[numberOfLinesInFile];
            int index = 0;
            while (scanner.hasNextLine()) {
                data[index++] = scanner.nextInt();
            }
            scanner.close();
            return data;
        }

        private static String[] readStrFile(String inputFilename) throws FileNotFoundException {
            File file = new File(inputFilename);
            Scanner scanner = new Scanner(file);
            int numberOfLinesInFile = countLinesInFile(inputFilename);
            String[] data = new String[numberOfLinesInFile];
            int index = 0;
            while (scanner.hasNextLine()) {
                data[index++] = scanner.nextLine();
            }
            scanner.close();
            return data;
        }


        /**
         * This method will count the number of lines in a text file, which it will return.
         * Do not edit this method.
         */
        private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
            File file = new File(inputFilename);
            Scanner scanner = new Scanner(file);
            int lineCount = 0;
            while (scanner.hasNextLine()) {
                lineCount++;
                scanner.nextLine();
            }
            scanner.close();
            return lineCount;
        }

    }
}