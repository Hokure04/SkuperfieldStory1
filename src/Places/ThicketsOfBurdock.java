package Places;

import Alive.Character;

import java.util.Arrays;

public class ThicketsOfBurdock extends Place implements Stabbing {
    int damage;

    public ThicketsOfBurdock(String name, Character[] list) {
        super(name, list);
    }

    @Override
    public void prick(Character entity) {
        final int min3 = 1;
        final int max3 = 10;
        this.damage = rnd(min3, max3);
        entity.health -= this.damage;
        System.out.println(entity.getName() + " исцарапал лицо и руки");
        System.out.println("Здоровье " + entity.getName() + "а " + entity.health);
    }

    @Override
    public void addCharacter(Character entity) {
        System.out.println(entity.getName() + " попал в " + this.getName());
        this.prick(entity);
    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
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
