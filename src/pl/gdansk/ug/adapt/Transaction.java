package pl.gdansk.ug.adapt;

public abstract sealed class Transaction extends AbstractTransaction permits TransactionIn, TransactionCross, TransactionGrid {
    private double quantity;
    private double sourceSurplus;
    private double targetNeed;
    private double targetProduction;
    private double targetBatteryEnergySurplus;
    private int sourceID;
    private int targetID;
    private int sourceCommunityID;
    private int targetCommunityID;

    public Transaction(double quantity, double sSurplus, double tNeed, double targetProduction, double targetBatteryEnergySurplus, int sID, int tID, int sCID, int tCID) {
        this.quantity = quantity;
        this.sourceSurplus = sSurplus;
        this.targetNeed = tNeed;
        this.targetProduction = targetProduction;
        this.targetBatteryEnergySurplus = targetBatteryEnergySurplus;
        this.sourceID = sID;
        this.targetID = tID;
        this.sourceCommunityID = sCID;
        this.targetCommunityID = tCID;
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
    public int getSourceCommunityID() {
        return sourceCommunityID;
    }
    public int getTargetCommunityID() {
        return targetCommunityID;
    }

    public double getTargetProduction() { return targetProduction; }

    public double getTargetBatteryEnergySurplus() { return targetBatteryEnergySurplus; }
}