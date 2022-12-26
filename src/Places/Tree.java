package Places;

import Alive.Characters;

import java.util.Arrays;

public class Tree extends Place {
    public Tree(String name, Characters[] list) {
        super(name, list);
    }

    @Override
    public void addCharacter(Characters entity) {
        heroes.add(entity);
        System.out.println("У " + entity.getName() + "а получилось залезть на " + this.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tree tree = (Tree) o;
        if (!Arrays.equals(this.getCharacters(), tree.getCharacters())) {
            return false;
        }
        return tree.getName().equals(this.getName());
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
