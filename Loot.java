public class Loot {
    
    private int LootID;
    private String LootName;
    private String LootType;

    public Loot(int LootID, String LootName, String LootType){
        super();
        this.LootID = LootID;
        this.LootName = LootName;
        this.LootType =  LootType;
    }

    public int getLootID(){
        return LootID;
    }

    public String getLootName(){
        return LootName;
    }

    public void setLootName(String LootName){
        this.LootName = LootName;
    }

    public String getLootType(){
        return LootType;
    }

    public void setLootType(String LootType){
        this.LootType = LootType;
    }

    public String toString(){
        return "Loot [LootID = " + LootID + ", LootName = " + LootName + ", LootType = " + LootType + "]";
    }

}
