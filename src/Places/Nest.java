package Places;

import Alive.Characters;

import java.util.Arrays;

public class Nest extends Place {
    public Nest(String name, Characters[] list) {
        super(name, list);
    }

    @Override
    public void addCharacter(Characters entity) {
        heroes.add(entity);
        System.out.println(entity.getName() + " охраняли " + this.getName() + " и не кому не мешали");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Nest nest = (Nest) o;
        if (!Arrays.equals(this.getCharacters(), nest.getCharacters())) {
            return false;
        }
        return nest.getName().equals(this.getName());
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
