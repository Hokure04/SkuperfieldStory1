package Alive;

import Items.Items;
import Places.Place;

public class Person extends Characters {
    public Person(String name, int health) {
        super(name);
        this.health = health;
    }


    public void stamp(Characters entity) {
        if (this.getCondition() == Condition.BITTEN) {
            System.out.println(this.getName() + " начал топтать " + entity.getName());
        }
    }

    public void stepBack(Place place) {
        System.out.println(this.getName() + " оставляет " + place.getName() + " и отступает");
    }

    public void goFaster() {
        System.out.println(this.getName() + " прибавил шаг");
    }

    public void movePersonTo(Place place1, Place place2) {
        place1.delCharacter(this);
        this.setSpeed();
        if(this.speed<55){
            System.out.println(this.getName()+" поплёлся в "+place2.getName());
        } else if (this.speed>70 && this.speed<88) {
            this.goFaster();
        } else if (this.speed>88) {
            System.out.println(this.getName()+" разогнался до скорости "+this.getSpeed());
        }
        place2.addCharacter(this);
    }

    public void thinking(Place place) {
        System.out.println("Мысль о том, что придётся заночевать в " + place.getName() + "у пугала");
        this.setCondition(Condition.SHUDDERING);
    }

    public void thinking() {
        if (this.getCondition() == Condition.MADDNESS) {
            System.out.println(this.getName() + "у начало казаться что он вот вот дойдёт до опушки леса");
            this.setCondition(Condition.WRONG_IMPRESIION);
            if (this.getCondition() == Condition.WRONG_IMPRESIION) {
                System.out.println("впечатление " + this.getName() + "а было обманчивым");
            }
        } else {
            System.out.println("Так как всё было хорошо " + this.getName() + " принялся искать, где заночевать");
        }
    }

    public void search() {
        System.out.println(this.getName() + " начал искать где бы заночевать");
    }

    public void search(Place place) {
        System.out.println(this.getName()+" заметил " + place.getName());
    }

    public void climb(Place place1, Place place2){
        System.out.println(this.getName()+" полез на "+place2.getName());
        place1.delCharacter(this);
        place2.addCharacter(this);
    }
    public void sit(){
        this.setCondition(Condition.RELAX);
    }

    public void addItem(Items thing) {
        items.add(thing);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        if (!this.getCondition().equals(person.getCondition())) {
            return false;
        }

        return getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = result + items.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}

