package Items;

import Alive.Characters;

public class Stick extends Items implements Damagble {
    public double power = 1.0;
    public Stick(String call) {
        super(call);
    }

    @Override
    public void dealDamage(Characters entity) {
        double unFormattedDamage = Math.random()*power*100;
        String format = String.format("%.0f", unFormattedDamage);
        System.out.println(this.getName()+" наносит "+ format +" единиц урона "+ entity.getName());
        entity.health = (entity.health - (int)unFormattedDamage);
        System.out.println("У " + entity.getName()+" осталось "+Math.round(entity.health)+" ед. здоровья");
        entity.dead();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stick stick = (Stick) o;
        return getName().equals(stick.getName());
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
