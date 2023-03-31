package Places;

import Alive.Character;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class Place {
    protected LinkedList<Character> heroes = new LinkedList<Character>();
    protected String name;
    protected Place components;
    protected int spaciousness;

    Place(String call, Character[] list, int spacious) {
        name = call;
        heroes.addAll(List.of(list));
        this.spaciousness = spacious;
    }

    Place(String call, Character[] list) {
        name = call;
        heroes.addAll(List.of(list));
    }

    public void setComponents(Place comps) {
        components = comps;
    }

    public String getName() {
        return name;
    }

    public void addCharacter(Character characters) {
        heroes.add(characters);
        System.out.println(characters.getName() + " находится в " + this.getName());
    }

    protected void addCharacter(Character сharacters, Place place) {
        heroes.add(сharacters);
        System.out.println(сharacters.getName() + " находится в " + this.getName());
    }

    public Object[] getCharacters() {
        return heroes.toArray();
    }

    public int getSpaciousness() {
        return this.spaciousness;
    }

    public void delCharacter(Character entity) {
        heroes.remove(entity);
    }

    public static class UnnamedPlace extends Place {
        public UnnamedPlace(String name, Character[] list) {
            super(name, list);
        }
    }

    public void earthquake() {
        class Earth {
            final String name = "земля";

            public String getName() {
                return this.name;
            }

        }
        Earth earth = new Earth();
        System.out.println(earth.getName() + " заходила у него под ногами ходуном");
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Place place = (Place) o;
        if (!Arrays.equals(this.getCharacters(), place.getCharacters())) {
            return false;
        }
        return place.getName().equals(this.getName());
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
