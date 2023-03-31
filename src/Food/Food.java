package Food;

import Alive.Person;

public class Food {
    protected String name;
    protected Edibility edibility;

    Food(String name, Edibility edibility) {
        this.name = name;
        this.edibility = edibility;
    }

    public void setEdibility(Edibility edible) {
        edibility = edible;
    }

    public Edibility getEdibility() {
        return this.edibility;
    }

    public String getName() {
        return this.name;
    }

    public enum Edibility {
        EDIBLE,
        INEDIBLE
    }

    public static class Grass extends Food {
        public Grass(String name, Edibility edibility) {
            super(name, edibility);
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
        Food food = (Food) o;
        if (!this.getEdibility().equals(food.getEdibility())) {
            return false;
        }

        return getName().equals(food.getName());
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
