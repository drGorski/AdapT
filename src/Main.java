import adapT.AbstractSmartContract;
import adapT.AbstractTransaction;
import concreteSC.*;
import tests.TestContract;

import java.util.Scanner;

public class Main {
    private static final Scanner scanS = new Scanner(System.in);
    private static String showMenu(){
        System.out.println(" 1 - transaction in-community - 3 rules");
        System.out.println(" 2 - transaction to-grid - 4 rules");
        System.out.println(" 3 - transaction cross-community - 5 rules");
        System.out.println(" 4 - verification of empty contract on abstract transaction");
        System.out.println(" 5 - run performance tests");
        return scanS.nextLine();
    }

    private static void runTests(ExchangeEnergyContract sC, TransactionIn trIn, TransactionCross trC, TransactionGrid trG){
        int repetitions = 50;
        TestContract.runTests(sC, trIn, repetitions);
        TestContract.runTests(sC, trG, repetitions);
        TestContract.runTests(sC, trC, repetitions);
    }

    private static void checkSC(AbstractSmartContract sC, AbstractTransaction tR){
        boolean correct = false;
        correct = sC.checkSC(tR);
        System.out.println("Smart contract verification: " + (correct ? "PASS" : "FAIL"));
    }

    public static void main(String[] args) {
        boolean correct;
        String selection;
        // transaction objects
        TransactionCross trC = new TransactionCross(100, 300, 400, 20,10,1001, 1002, 100, 101);
        TransactionIn trIn = new TransactionIn(100, 300, 400, 20, 10, 1001, 1002);
        TransactionGrid trG = new TransactionGrid(100, 300, 400, 20,10,1001, 1, 1);
        AbstractTransaction aTr = new EmptyTransaction();
        // smart contract objects
        ExchangeEnergyContract sC = new ExchangeEnergyContract();
        EmptyContract eC = new EmptyContract();

        do {
            correct = false;
            selection = showMenu();
            switch (selection) {
                case "1" -> checkSC(sC, trIn);
                case "2" -> checkSC(sC, trG);
                case "3" -> checkSC(sC, trC);
                case "4" -> checkSC(eC, aTr);
                case "5" -> runTests(sC, trIn, trC, trG);
            }
            System.out.println("Check again? (Y/N)");
        } while (scanS.nextLine().equalsIgnoreCase("Y"));
    }
}