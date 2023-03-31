package Places;

import Alive.Character;

import java.util.Arrays;

public class Puddle extends Place {
    public Puddle(String name, Character[] list) {
        super(name, list);
    }

    @Override
    public void addCharacter(Character entity) {
        heroes.add(entity);
        System.out.println(entity.getName() + " угодил прямо в лужу");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Forest forest = (Forest) o;
        if (!Arrays.equals(this.getCharacters(), forest.getCharacters())) {
            return false;
        }
        return forest.getName().equals(this.getName());
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = result + heroes.hashCode();
        return result;
    }
}
