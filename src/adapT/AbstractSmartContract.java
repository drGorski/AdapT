package adapT;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
public abstract class AbstractSmartContract {
    protected List<Predicate<AbstractTransaction>> rulesList = new ArrayList<>();
    protected List<List<Predicate<AbstractTransaction>>> configurations = new ArrayList<>();
    public AbstractSmartContract(){
        configurations.add(new ArrayList<>());
    }
    public boolean checkSC(AbstractTransaction tr){
        boolean correct = false;
        for (Predicate<AbstractTransaction> vR : configurations.get(0)) {
            correct = vR.test(tr);
            if (!correct) break;
        }
        return correct;
    }
}