package tests;

import adapT.AbstractSmartContract;
import adapT.AbstractTransaction;
public class TestContract {
    private static int[] numberTransactions = new int[]{100000, 1000000, 10000000};
    private static long conductTest(AbstractSmartContract sC, AbstractTransaction tR, int numberTransactions, int repetitions){
        boolean correct = false;
        long sum = 0;
        long startTime = 0, endTime = 0;
        for (int j = 0; j <= repetitions; j++){
            startTime = System.nanoTime();
            for (int i = 0; i < numberTransactions; i++) correct = sC.checkSC(tR);
            endTime = System.nanoTime();
            if( j > 0 ) sum = sum + (endTime - startTime);
        }
        return sum/repetitions;
    }

    public static void runTests(AbstractSmartContract sC, AbstractTransaction tR, int repetitions){
        long executionTime = 0;
        // smart contract evaluation time
        System.out.println("Evaluation time of transaction: " + tR.getClass());
        for (int numberTransaction : numberTransactions) {
            System.out.println("Number of processed transactions: " + numberTransaction);
            executionTime = conductTest(sC, tR, numberTransaction, repetitions);
            System.out.println("Execution time: " + executionTime);
        }
    }

}
