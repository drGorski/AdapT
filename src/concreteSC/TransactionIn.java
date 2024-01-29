package concreteSC;

public final class TransactionIn extends Transaction {
    public TransactionIn(double quantity, double sSurplus, double tNeed, double targetProduction, double targetBatteryEnergySurplus, int sID, int tID) {
        super(quantity, sSurplus, tNeed, targetProduction, targetBatteryEnergySurplus, sID, tID);
    }
}
