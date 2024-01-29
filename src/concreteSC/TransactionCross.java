package concreteSC;

public final class TransactionCross extends Transaction {
    private int sourceCommunityID;
    private int targetCommunityID;
    public TransactionCross(double quantity, double sSurplus, double tNeed, double targetProduction, double targetBatteryEnergySurplus, int sID, int tID, int sCID, int tCID) {
        super(quantity, sSurplus, tNeed, targetProduction, targetBatteryEnergySurplus, sID, tID);
        this.sourceCommunityID = sID;
        this.targetCommunityID = tCID;
    }
    public int getSourceCommunityID() {
        return sourceCommunityID;
    }
    public int getTargetCommunityID() {
        return targetCommunityID;
    }
}