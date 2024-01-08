package stocksimulator;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

import static stocksimulator.StockMarket.StockCallMethods.*;
import static stocksimulator.Stocks.AAPL;


public class StockMarket {
    static int day = 1;


    public static void main(String[] args) throws IOException {
        double count1 = AAPL("AAPL.txt");
        System.out.println(count1);

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
            while (day <= 5) {
                slowPrint("Would you like to skip day " + day + " or buy/sell stocks in the stock market?\n" +
                        "Enter 1 to skip the day, 2 to buy or sell: ");
                Scanner scanner2 = new Scanner(System.in);
                String option = scanner2.nextLine();

                if (option.equals("1")) {
                    day++;
                } else if (option.equals("2")) {
                    buyOrSellStock();
                } else {
                    slowPrint("Invalid choice. Please try again.\n");
                }
            }
            }
        Portfolio();

        if(day == 6){
            slowPrint("You have reached day 6, the end of this simulator... Here is your final portfolio.\n");
            Portfolio();
        }
        }


    public static void buyOrSellStock() {
        slowPrint("Which stock would you like to buy or sell?\n\n" +
                "Enter 1 for Eli Lilly (LLY), 2 for Apple (AAPL), or 3 for Google (GOOG): ");
        Scanner scanner = new Scanner(System.in);
        String stockChoice = scanner.nextLine();

        switch (stockChoice) {
            case "1":
                callEliLilly();
                break;
            case "2":
                callApple();
                break;
            case "3":
                callGoogle();
                break;
            default:
                slowPrint("Invalid choice. Please try again.\n");
        }
    }

    public static void slowPrint(String output) {
        for (int i = 0; i<output.length(); i++) {
            char c = output.charAt(i);
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(8);
            }
            catch (Exception e) {
            }
        }
    }
    public static int Portfolio() {
        int balance = 10000;
        System.out.println("Portfolio Balance: $" + balance);
        return balance;
    }
    public static String[] Portfolio2() {
        String[] stocks = {""};
        final int[] sharesOwnedLLY = {0};
        int sharesOwnedAAPL = 0;
        int sharesOwnedGooG = 0;
        if (sharesOwnedGooG >= 1) {
            stocks = new String[]{stocks + "GooG"};
        }
        if (sharesOwnedLLY[0] >= 1) {
            stocks = new String[]{stocks + "LLY"};
        }
        if (sharesOwnedAAPL >= 1) {
            stocks = new String[]{stocks + "AAPL"};
        }
        System.out.println("Stocks in Portfolio: " + Arrays.toString(stocks));
        return stocks;
    }

        static class StockCallMethods {
            static int balance = 10000;

            public static void callEliLilly() {
                int CurrentBalance = Portfolio();

                double stockPrice = 170.77;

                int sharesOwnedLLY = 0;
                System.out.println("Calling Apple (AAPL) stock method with price: " + stockPrice);

                if (CurrentBalance >= stockPrice) {
                    // Buy shares
                    int sharesToBuy = (int) (CurrentBalance / stockPrice);
                    slowPrint("you can buy " + sharesToBuy + " shares\n");

                    slowPrint("Enter a valid number to buy that amount of shares\n");
                    Scanner scanner4 = new Scanner(System.in);
                    int number = Integer.parseInt(scanner4.nextLine());

                    sharesOwnedLLY += number;
                    CurrentBalance -= number * stockPrice;
                    balance = (int) (balance - (number * stockPrice));
                    System.out.println("Bought " + number + " shares of GOOG at price " + stockPrice);
                } else if (sharesOwnedLLY> 0) {
                    int sellAmount = sharesOwnedLLY;

                    slowPrint("Enter a valid number to sell that amount of shares");
                    Scanner scanner4 = new Scanner(System.in);
                    int number = Integer.parseInt(scanner4.nextLine());

                    CurrentBalance += number * stockPrice;
                    sharesOwnedLLY -= number;
                    System.out.println("Sold all shares of LLY at price " + stockPrice);
                }

                int finalBalance = CurrentBalance;
                System.out.println("Final balance: " + finalBalance);
                int profit = finalBalance - CurrentBalance;
                System.out.println("Profit: " + profit);


                String[] stocks = new String[]{"LLY"};
            }

            public static void callApple() {
                int CurrentBalance = Portfolio();

                double stockPrice = 170.77;

                int sharesOwnedAAPL = 0;
                System.out.println("Calling Apple (AAPL) stock method with price: " + stockPrice);

                if (CurrentBalance >= stockPrice) {
                    // Buy shares
                    int sharesToBuy = (int) (CurrentBalance / stockPrice);
                    slowPrint("you can buy " + sharesToBuy + " shares\n");

                    slowPrint("Enter a valid number to buy that amount of shares\n");
                    Scanner scanner4 = new Scanner(System.in);
                    int number = Integer.parseInt(scanner4.nextLine());

                    sharesOwnedAAPL += number;
                    CurrentBalance -= number * stockPrice;
                    balance = (int) (balance - (number * stockPrice));
                    System.out.println("Bought " + number + " shares of GOOG at price " + stockPrice);
                } else if (sharesOwnedAAPL > 0) {
                    // Sell shares
                    int sellAmount = sharesOwnedAAPL;

                    slowPrint("Enter a valid number to sell that amount of shares");
                    Scanner scanner4 = new Scanner(System.in);
                    int number = Integer.parseInt(scanner4.nextLine());

                    CurrentBalance += number * stockPrice;
                    sharesOwnedAAPL -= number;
                    System.out.println("Sold all shares of GOOG at price " + stockPrice);
                }

                int finalBalance = CurrentBalance;
                System.out.println("Final balance: " + finalBalance);
                int profit = finalBalance - CurrentBalance;
                System.out.println("Profit: " + profit);


                String[] stocks = new String[]{"AAPL"};
            }

            public static void callGoogle() {
                int CurrentBalance = Portfolio();


                int sharesOwnedGooG = 0;
                double stockPrice = 125.30;

                System.out.println("Calling Google (GOOG) stock method with price: " + stockPrice);

                if (CurrentBalance >= stockPrice) {
                    // Buy shares
                    int sharesToBuy = (int) (CurrentBalance / stockPrice);
                    slowPrint("you can buy " + sharesToBuy + " shares\n");

                    slowPrint("Enter a valid number to buy that amount of shares");
                    Scanner scanner4 = new Scanner(System.in);
                    int number = Integer.parseInt(scanner4.nextLine());

                    sharesOwnedGooG += number;
                    CurrentBalance -= number * stockPrice;
                    balance = (int) (balance - (number * stockPrice));
                    System.out.println("Bought " + number + " shares of GOOG at price " + stockPrice);
                } else if (sharesOwnedGooG > 0) {
                    // Sell shares
                    int sellAmount = sharesOwnedGooG;

                    slowPrint("Enter a valid number to sell that amount of shares");
                    Scanner scanner4 = new Scanner(System.in);
                    int number = Integer.parseInt(scanner4.nextLine());

                    CurrentBalance += number * stockPrice;
                    sharesOwnedGooG -= number;
                    System.out.println("Sold all shares of GOOG at price " + stockPrice);
                }

                int finalBalance = CurrentBalance;
                System.out.println("Final balance: " + finalBalance);


                String[] stocks = new String[]{"GOOG"};
            }


            private static void writeFileAllAnswers(String outPutFilename) throws IOException {
                File file = new File(outPutFilename);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.close();
            }

            static int[] readFile(String inputFilename) throws FileNotFoundException {
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
