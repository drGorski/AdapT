package concreteSC;

import adapT.AbstractTransaction;

public abstract sealed class Transaction extends AbstractTransaction permits TransactionIn, TransactionCross, TransactionGrid {
    private double quantity;
    private double sourceSurplus;
    private double targetNeed;
    private double targetProduction;
    private double targetBatteryEnergySurplus;
    private int sourceID;
    private int targetID;

    public Transaction(double quantity, double sSurplus, double tNeed, double targetProduction, double targetBatteryEnergySurplus, int sID, int tID) {
        this.quantity = quantity;
        this.sourceSurplus = sSurplus;
        this.targetNeed = tNeed;
        this.targetProduction = targetProduction;
        this.targetBatteryEnergySurplus = targetBatteryEnergySurplus;
        this.sourceID = sID;
        this.targetID = tID;
    }

    public double getQuantity() {
        return quantity;
    }
    public double getSourceSurplus() {
        return sourceSurplus;
    }
    public double getTargetNeed() {
        return targetNeed;
    }
    public int getSourceID() {
        return sourceID;
    }
    public int getTargetID() {
        return targetID;
    }

    public double getTargetProduction() { return targetProduction; }

    public double getTargetBatteryEnergySurplus() { return targetBatteryEnergySurplus; }
}