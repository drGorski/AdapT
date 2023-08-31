package pl.gdansk.ug.adapt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public final class ConcreteContract extends AbstractSmartContract {
    private List<List<Predicate<AbstractTransaction>>> configurations;
    public ConcreteContract(){
        rulesList = Arrays.asList(
                t -> ((Transaction) t).getSourceCommunityID() == ((Transaction) t).getTargetCommunityID(),
                t -> ((Transaction) t).getSourceID() != ((Transaction) t).getTargetID(),
                t -> ((Transaction) t).getQuantity() > 0,
                t -> ((Transaction) t).getSourceSurplus() >= ((Transaction) t).getQuantity(),
                t -> ((Transaction) t).getSourceCommunityID() != ((Transaction) t).getTargetCommunityID(),
                t -> ((Transaction) t).getTargetNeed() >= ((Transaction) t).getQuantity());
        configurations = new ArrayList<>();
        for (int i = 0; i < 3 ; i++) configurations.add(new ArrayList<>());
        configureRulesIn();
        configureRulesCross();
        configureRulesGrid();
    }
    private void configureRulesIn(){
        List<Predicate<AbstractTransaction>> confIn = configurations.get(0);
        confIn.add(rulesList.get(0));
        confIn.add(rulesList.get(1));
        confIn.add(rulesList.get(2));
        confIn.add(rulesList.get(3));
    }
    private void configureRulesCross(){
        List<Predicate<AbstractTransaction>> confCross = configurations.get(1);
        confCross.add(rulesList.get(4));
        confCross.add(rulesList.get(1));
        confCross.add(rulesList.get(2));
        confCross.add(rulesList.get(3));
        confCross.add(rulesList.get(5));
    }
    private void configureRulesGrid(){
        List<Predicate<AbstractTransaction>> confGrid = configurations.get(2);
        confGrid.add(rulesList.get(2));
        confGrid.add(rulesList.get(3));
    }

    public boolean checkSC(AbstractTransaction tr){
        boolean correct = false;
        if (tr instanceof TransactionIn) correct = check(tr, configurations.get(0));
        if (tr instanceof TransactionCross) correct = check(tr, configurations.get(1));
        if (tr instanceof TransactionGrid) correct = check(tr, configurations.get(2));
        return correct;
    }
    private boolean check(AbstractTransaction tr, List<Predicate<AbstractTransaction>> configuration){
        boolean correct = false;
        for (Predicate<AbstractTransaction> vR : configuration) {
            correct = vR.test(tr);
            if (!correct) break;
        }
        return correct;
    }
}