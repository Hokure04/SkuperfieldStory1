package Alive;

import Exceptions.*;
import Items.Items;
import Places.Place;

public class Person extends Character {
    protected int despairLevel;
    Legs legs = new Legs("ноги");
    Back back = new Back("спина");
    Body body = new Body("тело");

    public Person(String name, int health) {
        super(name);
        this.health = health;
    }
    public Person(String name) {
        super(name);
    }

    public void stamp(Character entity) {
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
        int MIN_SPEED = 55;
        int MIDDLE_SPEED = 70;
        int MAX_SPEED = 88;
        if (this.speed < MIN_SPEED) {
            System.out.println(this.getName() + " поплёлся в " + place2.getName());
        } else if (this.speed > MIDDLE_SPEED && this.speed < MAX_SPEED) {
            this.goFaster();
        } else if (this.speed > MAX_SPEED) {
            System.out.println(this.getName() + " разогнался до скорости " + this.getSpeed());
        }
        place2.addCharacter(this);
    }

    public void thinking(Place place) {
        System.out.println("Мысль о том, что придётся заночевать в " + place.getName() + "у пугала");
        this.setCondition(Condition.SHUDDERING);
    }

    public void thinking() {
        if (this.getCondition() == Condition.MADNESS) {
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
        System.out.println(this.getName() + " заметил " + place.getName());
    }

    public void fumbling() {
        System.out.println(this.getName() + " принялся шарить вокруг в поисках еды");
    }

    public void climb(Place place1, Place place2) {
        System.out.println(this.getName() + " полез на " + place2.getName());
        place1.delCharacter(this);
        place2.addCharacter(this);
    }

    public void sit() {
        System.out.println(this.getName() + " уселся, чтобы хоть немного передохнуть");
        this.setCondition(Condition.RELAX);
    }

    public void sit(Items items) {
        System.out.println(this.getName() + " уселся задрав " + legs.getName());
        legs.pain();
    }

    private class Legs {
        private String name;

        private Legs(String name) {
            this.name = name;
        }

        private String getName() {
            return this.name;
        }

        private void pain() {
            System.out.println(this.getName() + " начали болеть");
        }

        private void continuePain() {
            System.out.println(this.getName() + " продолжили болеть");
        }
    }

    private class Back {
        private String name;

        private Back(String name) {
            this.name = name;
        }

        private String getName() {
            return this.name;
        }

        private void pain() {
            System.out.println("Начала болеть " + this.getName());
        }
    }

    private class Body {
        private String name;

        private Body(String name) {
            this.name = name;
        }

        private String getName() {
            return this.name;
        }

        private void pain() {
            System.out.println("Начало болеть всё " + this.getName());
        }
    }

    public void notIntentionalMovement(Place place1, Place place2) {
        place1.delCharacter(this);
        place2.addCharacter(this);
    }

    public void longLook() {
        System.out.println(this.getName() + " загляделся по сторонам");
    }

    public void addItem(Items thing) {
        items.add(thing);
    }

    public void removeItem(Items thing) {
        items.remove(thing);
    }

    public void bypass(Place place) {
        place.earthquake();
        System.out.println(this.getName() + " решил обойти " + place.getName());
    }

    public void runBack(Place place1, Place place2) throws PersonNotScaredException {
        if (this.getCondition() == Condition.SCARED) {
            System.out.println(this.getName() + " побежал обратно");
            final int min1 = 1;
            final int max1 = 5;
            final int step = rnd(min1, max1);
            System.out.println("Но успел пробежать только " + step + " шагов");
            this.movePersonTo(place1, place2);
        } else {
            throw new PersonNotScaredException(this.getName() + " спокойно прошёл мимо лужи");
        }
    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public void jump() {
        System.out.println("Он начал прыгать с кочи на кочку");
    }

    public void gotOut(Place place1, Place place2) {
        System.out.println("С большим трудом ему удалось вывбраться");
        this.movePersonTo(place1, place2);
    }

    public void gatherStrength() throws NegativeNumberException {
        final int min2 = -1;
        final int max2 = 10;
        final int fortitude = rnd(min2, max2);
        if (fortitude > 5) {
            System.out.println(this.getName() + " собрался с силами");
            this.jump();
        } else if (fortitude < 5 && fortitude > 0) {
            System.out.println(this.getName() + " попытался ещё раз собраться с силами");
            this.gatherStrength();
        } else if (fortitude < 0) {
            this.despairLevel = 1;
            throw new NegativeNumberException(this.getName() + " совсем отчаялся");
        }
    }

    public int getDespairLevel() {
        return this.despairLevel;
    }

    public void fellingBad() {
        legs.continuePain();
        back.pain();
        body.pain();
    }

    public void tryToStretch(Place place) {
        if (place.getSpaciousness() < 6) {
            System.out.println("У " + this.getName() + "а не получилось вытянуться во весь рост, слишком мало места");
        } else {
            System.out.println(this.getName() + " вытянулся и расслабился");
            this.setCondition(Condition.RELAX);
            this.sleep();
        }
    }

    public void sitInCrouchedPosition() {
        System.out.println(this.getName() + "у пришлось сидеть в скрюченном положении");
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

