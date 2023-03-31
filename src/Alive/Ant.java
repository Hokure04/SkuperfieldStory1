package Alive;

public class Ant extends Character implements Bittble {
    public Ant(String name) {
        super(name);
        this.quantity = 1;
        this.health = 5;
    }

    @Override
    public void bites(Character entity) {
        System.out.println(this.name + " беспощадно кусает " + entity.name);
        entity.setCondition(Condition.BITTEN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ant ant = (Ant) o;

        return getName().equals(ant.getName());
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


