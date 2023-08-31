package pl.gdansk.ug.adapt;

public final class TransactionCross extends Transaction {
    public TransactionCross(double quantity, double sSurplus, double tNeed, double targetProduction, double targetBatteryEnergySurplus, int sID, int tID, int sCID, int tCID) {
        super(quantity, sSurplus, tNeed, targetProduction, targetBatteryEnergySurplus, sID, tID, sCID, tCID);
    }
}