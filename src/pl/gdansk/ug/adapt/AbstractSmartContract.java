package pl.gdansk.ug.adapt;

import java.util.List;
import java.util.function.Predicate;
public abstract class AbstractSmartContract {
    // list of verification rules
    protected List<Predicate<AbstractTransaction>> rulesList;
    // verification of the smart contract
    public abstract boolean checkSC(AbstractTransaction tr);
}



