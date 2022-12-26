package Places;

import Alive.Characters;

import java.util.Arrays;

public class Forest extends Place {

    public Forest(String name, Characters[] list) {
        super(name, list);
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
