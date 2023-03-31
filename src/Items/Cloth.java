package Items;

import Alive.Person;

public class Cloth extends Items {
    public Cloth(String name) {
        super(name);
    }
    @Override
    public void removeFromPerson(Person person) {
        System.out.println(person.getName() + " снял " + this.getName() + " и положил на пол");
    }
}
