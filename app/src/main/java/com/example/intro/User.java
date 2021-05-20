package com.example.intro;

public class User {


    String name;
    int currentXP;
    String avatarImg;
    int lvl;
    int currentHP;
    int maxHP;
    double maxXP;
    int gold;

    //int xp;

    //endregion
    //region constructor
    public User(String name,String avatarImg,int lvl,int gold,int currentXP,double maxXP,int currentHP,int maxHP )
    {
        this.lvl=lvl;
        this.name=name;
        this.gold=gold;
        this.currentXP=currentXP;
        this.maxXP=maxXP;
        this.currentHP=currentHP;
        this.maxHP=maxHP;
        this.avatarImg=avatarImg;
    }

    public String getAvatarImg() {
        return avatarImg;
    }

    public void setAvatarImg(String avatarImg) {
        this.avatarImg = avatarImg;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getCurrentXP() {
        return currentXP;
    }

    public int getLvl() {
        return lvl;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public void setCurrentXP(int currentXP) {
        this.currentXP = currentXP;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
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
        this.currentXP = xp;
    }

    public int getXp() {
        return currentXP;
    }

    public double getMaxXP() {
        return maxXP;
    }

    public void setMaxXP(double maxXP) {
        this.maxXP = maxXP;
    }

}
