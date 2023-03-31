package Alive;


import java.util.LinkedList;

public class FlockOfAnts extends Character{
    //protected LinkedList<Ant> ants = new LinkedList<>();

    public FlockOfAnts(String name) {
        super(name);
    }

    public void addAnt(Ant ant) {
        //ants.add(ant);
        this.quantity = ant.quantity;
        this.health = quantity * 5;
    }

    public void attack(Character entity) {
        System.out.println(this.name + " нападают на "+ entity.getName());
        //ants.getLast().bites(entity);
    }

    @Override
    public void dead() {
        int get = this.quantity - this.health / 5;
        this.quantity = this.health / 5;
        System.out.println("Осталось " + this.quantity + " муравьёв");
        System.out.println("Умерло " + get + " муравьёв");
    }

    public void recovery() {
        if (this.quantity < 100) {
            while (this.quantity < 100) {
                this.quantity = this.quantity + 10;
                System.out.println("Добавилось 10 муравьёв");
                System.out.println(this.quantity);
            }
            System.out.println("Муравьёв не становится меньше");
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
        FlockOfAnts ants = (FlockOfAnts) o;

        return getName().equals(ants.getName());
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}

