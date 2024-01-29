package concreteSC;

import adapT.AbstractSmartContract;
import adapT.AbstractTransaction;

import java.util.ArrayList;
import java.util.function.Predicate;

public final class ExchangeEnergyContract extends AbstractSmartContract {
    public ExchangeEnergyContract(){
        // verification rules
        rulesList.add(t -> ((Transaction) t).getSourceID() != ((Transaction) t).getTargetID());
        rulesList.add(t -> ((Transaction) t).getQuantity() > 0);
        rulesList.add(t -> ((Transaction) t).getSourceSurplus() >= ((Transaction) t).getQuantity());
        rulesList.add(t -> ((TransactionCross) t).getSourceCommunityID() != ((TransactionCross) t).getTargetCommunityID());
        rulesList.add(t -> ((Transaction) t).getTargetNeed() >= ((Transaction) t).getQuantity());
        rulesList.add(t -> ((TransactionGrid) t).getTargetID() == ((TransactionGrid) t).getEnergySubnetID());
        // configurations
        for (int i = 1; i <= 2 ; i++) configurations.add(new ArrayList<>());
        // configure rules for TransactionIn
        configurations.get(0).add(rulesList.get(0));
        configurations.get(0).add(rulesList.get(1));
        configurations.get(0).add(rulesList.get(2));
        // configure rules for TransactionGrid
        configurations.get(1).add(rulesList.get(0));
        configurations.get(1).add(rulesList.get(1));
        configurations.get(1).add(rulesList.get(2));
        configurations.get(1).add(rulesList.get(5));
        // configure rules for TransactionCross
        configurations.get(2).add(rulesList.get(3));
        configurations.get(2).add(rulesList.get(0));
        configurations.get(2).add(rulesList.get(1));
        configurations.get(2).add(rulesList.get(2));
        configurations.get(2).add(rulesList.get(4));
    }
    public boolean checkSC(TransactionGrid tr){
        boolean correct = false;
        for (Predicate<AbstractTransaction> vR : configurations.get(1)) {
            correct = vR.test(tr);
            if (!correct) break;
        }
        return correct;
    }
    public boolean checkSC(TransactionCross tr){
        boolean correct = false;
        for (Predicate<AbstractTransaction> vR : configurations.get(2)) {
            correct = vR.test(tr);
            if (!correct) break;
        }
        return correct;
    }
}