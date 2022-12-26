package Places;

import Alive.*;

import java.util.Arrays;

public class BattleGround extends Place {

    public BattleGround(String name, Characters[] list) {
        super(name, list);
    }

    @Override
    public void addCharacter(Characters entity, Place place) {
        heroes.add(entity);
        System.out.println(entity.getName() + " находится на " + this.getName());
        if (entity.getCondition() == Condition.RELAX) {
            System.out.println(entity.getName() + " уселся на " + place.getName());
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
        BattleGround battleGround = (BattleGround) o;
        if (!Arrays.equals(this.getCharacters(), battleGround.getCharacters())) {
            return false;
        }
        return battleGround.getName().equals(this.getName());
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
