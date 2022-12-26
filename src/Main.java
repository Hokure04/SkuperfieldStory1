import Alive.*;
import Days.*;
import Items.Stick;
import Places.*;

public class Main {
    public static void main(String[] args) {
        Person skuperfield = new Person("Скуперфильд", 100);
        Ants ants = new Ants("Муравьи", 100);

        Nest nest = new Nest("Муравиьное гнздо", new Characters[]{ants});
        BattleGround battleGround = new BattleGround("Поле боя", new Characters[]{skuperfield});
        Hollow hollow = new Hollow("Дупло", new Characters[]{});
        Tree tree = new Tree("Дерево", new Characters[]{});
        Forest forest = new Forest("Лес", new Characters[]{});

        Stick stick = new Stick("Палка");
        Day day = new Day("День", DarkLevel.LIGHT);

        battleGround.setComponents(nest);
        forest.setComponents(tree);
        tree.setComponents(hollow);
        nest.addCharacter(ants);
        skuperfield.sit();
        battleGround.addCharacter(skuperfield);
        if (skuperfield.getCondition() == Condition.RELAX) {
            ants.bites(skuperfield);
            skuperfield.setCondition(Condition.BITTEN);
        }
        skuperfield.stamp(ants);
        stick.addToPerson(skuperfield);
        stick.useOn(ants);
        stick.dealDamage(ants);
        ants.recovery();
        skuperfield.stepBack(battleGround);
        skuperfield.movePersonTo(battleGround, forest);
        day.setDarkLevel(DarkLevel.DARK.getDescription());
        skuperfield.goFaster();
        skuperfield.thinking(forest);
        if (skuperfield.getCondition() == Condition.SHUDDERING) {
            System.out.println("Скуперфильд содрогнулся");
        }
        skuperfield.setCondition(Condition.MADDNESS);
        skuperfield.thinking();
        day.setDarkLevel(DarkLevel.BLAKNESS.getDescription());
        skuperfield.search();
        skuperfield.search(tree);
        skuperfield.climb(forest, tree);
        skuperfield.movePersonTo(tree, hollow);
        day.setDarkLevel(DarkLevel.FULL_NIGHT.getDescription());
        skuperfield.sleep();
    }
}