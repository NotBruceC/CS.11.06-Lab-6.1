import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int count1 = challengeOne("testInputOneTwo.txt");
        System.out.println(count1);
        int count4 = challengeTwo("testInputOneTwo.txt");
        System.out.println(count4);
        int count5 = challengeThree("testInputThreeFour.txt");
        System.out.println(count5);
        int count6 = challengeFour("testInputThreeFour.txt");
        System.out.println(count6);
    }


    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int[] stuuupid = readFile(fileName);
        int count = 0;
        for(int i=1; i<stuuupid.length; i++){
            if(stuuupid[i]>stuuupid[i-1]) count++;
        }

    return count;
    }




    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] ailred = readFile(fileName);
        int count2 = 0;
        for(int i=1; i<ailred.length-2; i++){
            int sum3 = ailred[i-1] + ailred[i] + ailred[i+1];
            int sum4 = ailred[i] + ailred[i+1] + ailred[i+2];
            if(sum4>sum3) count2++;
        }

        return count2;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] zone = readStrFile(fileName);
        int fowardtotal = 0;
        int up = 0;
        for(int i=0; i<zone.length; i++){
            String ok = String.valueOf(zone[i]);
            String yes = ok.substring(ok.length()-1,ok.length());
            String counter = ok.substring(0,ok.length()-1);
            int num = Integer.parseInt(yes);
            if(counter.equals("forward ")){
                fowardtotal += num;
            }else if (counter.equals("up ")){
                up -= num;
            }else if(counter.equals("down ")){
                up += num;
            }
        }
        return fowardtotal * up;
    }


    /** TODO 4
     *
     * Challenge 4
     *
     * @param fileName
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String fileName) throws FileNotFoundException {
        String[] zone = readStrFile(fileName);
        int fowardtotal = 0;
        int aim = 0;
        int depth = 0;
        for(int i=0; i<zone.length; i++){
            String ok = String.valueOf(zone[i]);
            String yes = ok.substring(ok.length()-1,ok.length());
            String counter = ok.substring(0,ok.length()-1);
            int num = Integer.parseInt(yes);
            if(counter.equals("forward ")){
                fowardtotal += num;
                depth += num*aim;
            }else if (counter.equals("up ")){
                aim -= num;
            }else if(counter.equals("down ")){
                aim += num;
            }
        }
        return fowardtotal * depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
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


    /** This method will count the number of lines in a text file, which it will return.
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