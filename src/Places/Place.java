package Places;

import Alive.Characters;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class Place {
    protected LinkedList<Characters> heroes = new LinkedList<Characters>();
    protected String name;
    protected Place components;

    Place(String call) {
        name = call;
    }

    Place(String call, Characters[] list) {
        name = call;
        heroes.addAll(List.of(list));
    }

    public void setComponents(Place comps){
        components = comps;
    }

    public String getName() {
        return name;
    }

    public void addCharacter(Characters characters) {
        heroes.add(characters);
        System.out.println(characters.getName() + " находится в " + this.getName());
    }

    protected void addCharacter(Characters сharacters, Place place) {
        heroes.add(сharacters);
        System.out.println(сharacters.getName() + " находится в " + this.getName());
    }

    protected void addListOfCharacters(Characters[] list) {
        heroes.addAll(List.of(list));
    }

    public Object[] getCharacters() {
        return heroes.toArray();
    }


    public void delCharacter(Characters entity) {
        heroes.remove(entity);
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
