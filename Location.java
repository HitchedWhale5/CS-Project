import javax.sound.sampled.LineUnavailableException;

public class Location {
    
    private int LocationID;
    private String LocationName;
    private int LocationBonfires;
    private int LocationRecLevel;
    private String LocationHasBoss;

    public Location(int LocationID, String LocationName, int LocationBonfires, int LocationRecLevel, String LocationHasBoss){
        super();
        this.LocationID = LocationID;
        this.LocationName = LocationName;
        this.LocationBonfires = LocationBonfires;
        this.LocationRecLevel = LocationRecLevel;
        this.LocationHasBoss = LocationHasBoss;
    }

    public int getLocationID(){
        return LocationID;
    }

    public String getLocationName(){
        return LocationName;
    }

    public void setLocationName(String LocationName){
        this.LocationName = LocationName;
    }

    public int getLocationBonfires(){
        return LocationBonfires;
    }

    public void setLocationBonfires(int LocationBonfires){
        this.LocationBonfires = LocationBonfires;
    }

    public int getLocationRecLevel(){
        return LocationRecLevel;
    }

    public void setLocationRecLevel(int LocationRecLevel){
        this.LocationRecLevel = LocationRecLevel;
    }

    public String getLocationHasBoss(){
        return LocationHasBoss;
    }

    public void setLocationHasBoss(String LocationHasBoss){
        this.LocationHasBoss = LocationHasBoss;
    }

    public String toString(){
        return "Location [LocationID = " + LocationID + ", LocationName = " + LocationName + ", LocationBonfires = "
            + LocationBonfires + ", LocationRecLevel = " + LocationRecLevel + ", LocationHasBoss = " + LocationHasBoss + "]";
    }

}
