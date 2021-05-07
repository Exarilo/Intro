package com.example.intro;



public class Army {
    String name;
    String img;
    int range;
    int hp;
    int moveSpeed;
    int damages;
    double cooldown;
    int cost;
    double attackSpeed;
    int deathGold;


    public Army(String name, String img, int range, int hp, int moveSpeed, int damages, int cost,double cooldown,double attackSpeed,int deathGold)
    {
        this.name=name;
        this.img=img;
        this.hp=hp;
        this.range=range;
        this.moveSpeed=moveSpeed;
        this.damages=damages;
        this.cost=cost;
        this.cooldown=cooldown;
        this.deathGold=deathGold;
        this.attackSpeed=attackSpeed;

    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public void setCooldown(double cooldown) {
        this.cooldown = cooldown;
    }

    public double getCooldown() {
        return cooldown;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getDamages() {
        return damages;
    }

    public void setDamages(int damages) {
        this.damages = damages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public int getRange() {
        return range;
    }

    public String getImg() {
        return img;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public void setRange(int range) {
        this.range = range;
    }

}
