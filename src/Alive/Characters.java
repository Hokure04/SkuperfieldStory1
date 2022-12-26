package Alive;

import Items.*;


import java.util.LinkedList;

public abstract class Characters {
    protected String name;
    protected Condition condition = Condition.NORMAL;
    protected LinkedList<Items> items = new LinkedList<Items>();
    public int health;
    protected int quantity;
    protected int speed;

    public Characters(String name) {
        this.name = name;
    }

    public Characters(String name, Condition condition, int health, int quantity){
        this.name= name;
        this.condition = condition;
        this.health = health;
        this.quantity = quantity;
    }

    public Characters(String name, Condition condition, int health){
        this.name= name;
        this.condition = condition;
        this.health = health;
    }

    public Characters(String name, Condition condition) {
        this.name = name;
        this.condition = condition;
    }

    public Object[] getItem(Stick stick) {
        return items.toArray();
    }

    public void setCondition(Condition cos) {
        condition = cos;
    }

    public Condition getCondition() {
        return condition;
    }

    public String getName() {
        return this.name;
    }

    protected int setSpeed() {
        this.speed = (int)(Math.random()*100);
        return this.speed;
    }

    protected int getSpeed(){
        return this.speed;
    }

    public void sleep(){
        System.out.println(this.getName() + " начал располагаться на ночь");
    }
    public void dead(){
        if (this.health <= 0){
            System.out.println(this.getName()+" умер");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Characters entity = (Characters) o;
        if (!this.getCondition().equals(entity.getCondition())) {
            return false;
        }

        return getName().equals(entity.getName());
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = result + items.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
