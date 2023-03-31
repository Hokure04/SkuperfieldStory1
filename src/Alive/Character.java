package Alive;

import Food.Food;
import Items.*;
import java.util.LinkedList;

public abstract class Character {
    protected String name;
    protected Condition condition = Condition.NORMAL;
    protected LinkedList<Items> items = new LinkedList<Items>();
    public int health;
    protected int quantity;
    protected int speed;
    protected int hungryLevel;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Condition condition, int health, int quantity) {
        this.name = name;
        this.condition = condition;
        this.health = health;
        this.quantity = quantity;
    }

    public Character(String name, Condition condition, int health) {
        this.name = name;
        this.condition = condition;
        this.health = health;
    }

    public Character(String name, Condition condition) {
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

    protected void setSpeed() {
        this.speed = (int) (Math.random() * 100);
    }

    protected int getSpeed() {
        return this.speed;
    }

    public void layDown() {
        System.out.println(this.getName() + " начал располагаться на ночь");
    }

    public void dead() {
        if (this.health <= 0) {
            System.out.println(this.getName() + " умер");
        }
    }

    public void feelingHungry() {
        if (this.getCondition() == Condition.HUNGRY) {
            this.hungryLevel += 1;
            if (this.hungryLevel == 1) {
                System.out.println("Чувство голода начало подкрадываться к " + this.getName());
            } else if (this.hungryLevel == 2) {
                this.wakeUp();
                System.out.println("В животе у " + this.getName() + "а мучительно засососало");
            }
        }
    }

    public void sleep() {
        if (this.hungryLevel > 1) {
            System.out.println("Чувство голода мешало уснуть " + this.getName() + "у");
        } else {
            System.out.println(this.getName() + " сладко уснул");
        }
    }

    public void wakeUp() {
        System.out.println(this.getName() + " очнулся");
    }

    public void eat(Food food) {
        if (food.getEdibility() == Food.Edibility.INEDIBLE) {
            System.out.println(this.getName() + " попробовал жевать " + food.getName() + " и тут же выплюнул с отвращением");
        } else if (food.getEdibility() == Food.Edibility.EDIBLE) {
            System.out.println(this.getName() + " с удовольствием съел " + food.getName());
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
        Character entity = (Character) o;
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
