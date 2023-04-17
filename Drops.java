public class Drops {
    private int EnemyID;
    private int LootID;

    public Drops(int EnemyID, int LootID) {
        super();
        this.EnemyID = EnemyID;
        this.LootID = LootID;
    }

    public int getEnemyID() {
        return EnemyID;
    }

    public int getLootID() {
        return LootID;
    }

    public void setEnemyID(int EnemyID) {
        this.EnemyID = EnemyID;
    }

    public void setLootID(int LootID) {
        this.LootID = LootID;
    }

    public String toString() {
        return "Drops [EnemyID = " + EnemyID + ", LootID = " + LootID + "]";
    }
}
