public class Patrols {
    private int EnemyID;
    private int LocationID;

    public Patrols(int EnemyID, int LocationID) {
        super();
        this.EnemyID = EnemyID;
        this.LocationID = LocationID;
    }

    public int getEnemyID() {
        return EnemyID;
    }

    public int getLocationID() {
        return LocationID;
    }

    public void setEnemyID(int EnemyID) {
        this.EnemyID = EnemyID;
    }

    public void setLocationID(int LocationID) {
        this.LocationID = LocationID;
    }

    public String toString() {
        return "Patrols [EnemyID = " + EnemyID + ", LocationID = " + LocationID + "]";
    }
}
