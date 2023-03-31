import Alive.*;
import Alive.Character;
import Days.*;
import Exceptions.*;
import Food.Food;
import Items.*;
import Places.*;

public class Main{
    public static void main(String[] args) {
        Person skuperfield = new Person("Скуперфильд", 100);
        Ant ant1 = new Ant("Муравьей Леонардо");
        Ant ant2 = new Ant("Муравьей Донателло");
        Ant ant3 = new Ant("Муравьей Рафаэль");
        Ant ant4 = new Ant("Муравьей Микеланджело");
        FlockOfAnts flockOfAnts = new FlockOfAnts("Колония муравьёв");

        Nest nest = new Nest("Муравиьное гнздо", new Character[]{flockOfAnts});
        BattleGround battleGround = new BattleGround("Поле боя", new Character[]{});
        Hollow hollow = new Hollow("Дупло", new Character[]{}, 5);
        Tree tree = new Tree("Дерево", new Character[]{});
        Forest forest = new Forest("Лес", new Character[]{});
        Swamp swamp = new Swamp("Болото", new Character[]{});
        Place.UnnamedPlace place = new Place.UnnamedPlace("Неназванное место", new Character[]{});
        ShakyGround ground = new ShakyGround("Зыбкая почва", new Character[]{});
        Puddle puddle = new Puddle("Лужа", new Character[]{});
        ThicketsOfBurdock burdock = new ThicketsOfBurdock("Заросли репейника", new Character[]{});

        Cloth boots = new Cloth("Ботинки"){
            public void addToPerson(Person person) {
                System.out.println(this.getName() + " надеты на " + person.getName());
            }
        };
        Cloth hat = new Cloth("Цилиндр"){
            public void addToPerson(Person person) {
                System.out.println(this.getName() + " надета на " + person.getName());
            }
        };
        Stick stick = new Stick("Палка");
        Day day = new Day("День", DarkLevel.LIGHT);
        Food.Grass grass = new Food.Grass("Трава", Food.Edibility.EDIBLE);


        battleGround.setComponents(nest);
        forest.setComponents(tree);
        tree.setComponents(hollow);
        swamp.setComponents(ground);
        place.addCharacter(skuperfield);
        hat.addToPerson(skuperfield);
        boots.addToPerson(skuperfield);
        skuperfield.setCondition(Condition.HUNGRY);
        skuperfield.feelingHungry();
        skuperfield.feelingHungry();
        skuperfield.fumbling();
        skuperfield.eat(grass);
        skuperfield.longLook();
        skuperfield.notIntentionalMovement(place, swamp);
        ground.addCharacter(skuperfield);
        skuperfield.bypass(ground);
        skuperfield.setCondition(Condition.SCARED);
        try {
            skuperfield.runBack(swamp, puddle);
        } catch (PersonNotScaredException e) {
            System.out.println(e.getMessage());
        }
        try {
            skuperfield.gatherStrength();
        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
        }
        if (skuperfield.getDespairLevel() == 0) {
            skuperfield.gotOut(puddle, burdock);
            skuperfield.movePersonTo(burdock, battleGround);
            flockOfAnts.addAnt(ant1);
            flockOfAnts.addAnt(ant2);
            flockOfAnts.addAnt(ant3);
            flockOfAnts.addAnt(ant4);
            nest.addCharacter(flockOfAnts);
            skuperfield.sit();
            if (skuperfield.getCondition() == Condition.RELAX) {
                flockOfAnts.attack(skuperfield);
                skuperfield.setCondition(Condition.BITTEN);
            }
            skuperfield.stamp(flockOfAnts);
            stick.addToPerson(skuperfield);
            stick.useOn(flockOfAnts);
            stick.dealDamage(flockOfAnts);
            flockOfAnts.recovery();
            skuperfield.stepBack(battleGround);
            skuperfield.movePersonTo(battleGround, forest);
            day.setDarkLevel(DarkLevel.DARK.getDescription());
            skuperfield.goFaster();
            skuperfield.thinking(forest);
            if (skuperfield.getCondition() == Condition.SHUDDERING) {
                System.out.println("Скуперфильд содрогнулся");
            }
            skuperfield.setCondition(Condition.MADNESS);
            skuperfield.thinking();
            day.setDarkLevel(DarkLevel.BLAKNESS.getDescription());
            skuperfield.search();
            skuperfield.search(tree);
            skuperfield.climb(forest, tree);
            skuperfield.movePersonTo(tree, hollow);
            day.setDarkLevel(DarkLevel.FULL_NIGHT.getDescription());
            skuperfield.layDown();
            stick.removeFromPerson(skuperfield);
            hat.removeFromPerson(skuperfield);
            skuperfield.sleep();
            skuperfield.sit(boots);
            boots.removeFromPerson(skuperfield);
            skuperfield.fellingBad();
            skuperfield.tryToStretch(hollow);
            skuperfield.sitInCrouchedPosition();
        } else if (skuperfield.getDespairLevel() == 1) {
            System.out.println("Вот и сказочке конец");
        }
    }
}