import pl.gdansk.ug.adapt.*;
import pl.gdansk.ug.adapt.ConcreteContract;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean correct;
        boolean repeat;
        Scanner scanS = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        TransactionCross trC = new TransactionCross(100, 300, 400, 20,10,1001, 1002, 100, 101);
        TransactionIn trIn = new TransactionIn(100, 300, 400, 20, 10, 1001, 1002, 100, 100);
        TransactionGrid trG = new TransactionGrid(100, 300, 400, 20,10,1001, 1002, 100, 101);
        ConcreteContract sC = new ConcreteContract();
        int numberTransactions;
        int repetitions = 25;
        Duration sum;
        LocalTime startTime, endTime;
        Duration timeOfCalculation;
        String selection;

        do {
            sum = Duration.ZERO;
            correct = false;
            System.out.println(" 1 - transaction to-grid - 2 rules");
            System.out.println(" 2 - transaction in-community - 4 rules");
            System.out.println(" 3 - transaction cross-community - 5 rules");

            selection = scanS.nextLine();
            System.out.println("Enter the number of transactions: ");
            numberTransactions = scanInt.nextInt();

            if (selection.equalsIgnoreCase("1")) {
                for (int j = 0; j <= repetitions; j++){
                    startTime = LocalTime.now();
                    for (int i = 0; i < numberTransactions; i++) correct = sC.checkSC(trG);
                    endTime = LocalTime.now();
                    timeOfCalculation = Duration.between(startTime, endTime);
                    if( j > 0 ){
                        System.out.println("Czas ewaluacji grid " + j + ": " + timeOfCalculation);
                        sum = sum.plus(timeOfCalculation);}
                }
                System.out.println("Suma: " + sum);
            } else if (selection.equalsIgnoreCase("2")) {
                for (int j = 0; j <= repetitions; j++){
                    startTime = LocalTime.now();
                    for (int i = 0; i < numberTransactions; i++) correct = sC.checkSC(trIn);
                    endTime = LocalTime.now();
                    timeOfCalculation = Duration.between(startTime, endTime);
                    if( j > 0 ){
                        System.out.println("Czas ewaluacji in " + j + ": " + timeOfCalculation);
                        sum = sum.plus(timeOfCalculation);}
                }
                System.out.println("Suma: " + sum);
            } else if (selection.equalsIgnoreCase("3")) {
                for (int j = 0; j <= repetitions; j++){
                    startTime = LocalTime.now();
                    for (int i = 0; i < numberTransactions; i++) correct = sC.checkSC(trC);
                    endTime = LocalTime.now();
                    timeOfCalculation = Duration.between(startTime, endTime);
                    if( j > 0 ){
                        System.out.println("Czas ewaluacji cross " + j + ": " + timeOfCalculation);
                        sum = sum.plus(timeOfCalculation);}
                }
                System.out.println("Suma: " + sum);
            }

            System.out.println("Smart contract verification: " + (correct ? "PASS" : "FAIL"));
            System.out.println("Check again? (Y/N)");
            repeat = scanS.nextLine().equalsIgnoreCase("Y");
        } while (repeat);
    }
}