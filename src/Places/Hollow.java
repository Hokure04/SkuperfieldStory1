package Places;

import Alive.Characters;

import java.util.Arrays;

public class Hollow extends Place {
    public Hollow(String name, Characters[] list) {
        super(name, list);
    }

    @Override
    public void addCharacter(Characters entity) {
        heroes.add(entity);
        System.out.println(entity.getName() + " пробирается в большое " + this.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hollow hollow = (Hollow) o;
        if (!Arrays.equals(this.getCharacters(), hollow.getCharacters())) {
            return false;
        }
        return hollow.getName().equals(this.getName());
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
