public class Enemy {

    private int EnemyID;
    private String EnemyName;
    private int EnemyHP;
    private int EnemySouls;
    private String EnemyWeakness;
    private String EnemyResistance; 
    private String EnemyImmunity;
    private String EnemyBoss; 

    public Enemy(int EnemyID, String EnemyName, int EnemyHP, int EnemySouls, String EnemyWeakness, String EnemyResistance, String EnemyImmunity, String EnemyBoss){
        super();
        this.EnemyID = EnemyID;
        this.EnemyName = EnemyName;
        this.EnemyHP = EnemyHP;
        this.EnemySouls = EnemySouls;
        this.EnemyWeakness = EnemyWeakness;
        this.EnemyResistance = EnemyResistance;
        this.EnemyImmunity = EnemyImmunity;
        this.EnemyBoss = EnemyBoss;
    }

    public String getEnemyName(){
        return EnemyName;
    }

    public void setEnemyName(String EnemyName){
        this.EnemyName = EnemyName;
    }

    public int getEnemyHP(){
        return EnemyHP;
    }

    public void setEnemyHP(int EnemyHP){
        this.EnemyHP = EnemyHP;
    }

    public int getEnemySouls(){
        return EnemySouls;
    }

    public void setEnemySouls(int EnemySouls){
        this.EnemySouls = EnemySouls;
    }

    public String getEnemyWeakness(){
        return EnemyWeakness;
    }

    public void setEnemyWeakness(String EnemyWeakness){
        this.EnemyWeakness = EnemyWeakness;
    }

    public String getEnemyResistance(){
        return EnemyResistance;
    }

    public void setEnemyResistance(String EnemyResistance){
        this.EnemyResistance = EnemyResistance;
    }

    public String getEnemyImmunity(){
        return EnemyImmunity;
    }

    public void setEnemyImmunity(String EnemyImmunity){
        this.EnemyImmunity = EnemyImmunity;
    }

    public String getEnemyBoss(){
        return EnemyBoss;
    }

    public void setEnemyBoss(String EnemyBoss){
        this.EnemyBoss = EnemyBoss;
    }

    public int getEnemyID(){
        return EnemyID;
    }

    public String toString(){
        return "Enemy [EnemyID = " + EnemyID + ", EnemyName = " + EnemyName + ", EnemyHP = " + EnemyHP + ", EnemySouls = " 
            + EnemySouls + ", EnemyWeakness = " + EnemyWeakness + ", EnemyResistance = " + EnemyResistance + ", EnemyImmunity = "
            + EnemyImmunity + ", EnemyBoss = " + EnemyBoss + "]";
    }
    
    
}
