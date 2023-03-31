package Places;

import Alive.Character;

import java.util.Arrays;

public class Hollow extends Place {
    public Hollow(String name, Character[] list, int spacious) {
        super(name, list, spacious);
    }

    @Override
    public void addCharacter(Character entity) {
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
