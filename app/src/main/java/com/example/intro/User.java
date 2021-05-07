package com.example.intro;

public class User {


    String name;
    int xp;
    double maxXP;
    int gold;

    //int xp;

    //endregion
    //region constructor
    public User(String name,int gold,int xp,double maxXP)
    {
        this.name=name;
        this.gold=gold;
        this.xp=xp;
        this.maxXP=maxXP;
    }




    public String getName(){
        return  name;
    }



    public int getGold() {
        return gold;
    }




    public void setName(String name) {
        this.name = name;
    }



    public void setGold(int gold) {
        this.gold = gold;
    }


    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getXp() {
        return xp;
    }

    public double getMaxXP() {
        return maxXP;
    }

    public void setMaxXP(double maxXP) {
        this.maxXP = maxXP;
    }

}
