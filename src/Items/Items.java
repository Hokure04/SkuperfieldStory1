package Items;

import Alive.*;

public abstract class Items {
    protected String name;

    public Items(String call) {
        name = call;
    }

    protected String getName() {
        return name;
    }

    public void useOn(Characters entity) {
        System.out.println(this.getName() + " избивает " + entity);
        System.out.println(entity + " разозлились ещё больше");
    }

    public void addToPerson(Person person) {
        person.addItem(this);
        System.out.println(person.getName() + " берёт в руки " + this.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Items item = (Items) o;
        return getName().equals(item.getName());
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
