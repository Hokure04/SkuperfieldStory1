package Days;

public class Day implements SettingWeather {
    public String name;
    public DarkLevel level = DarkLevel.LIGHT;

    public Day(String name, DarkLevel level) {
        this.name = name;
        this.level = level;
    }

    public DarkLevel getDarkLevel() {
        return level;
    }

    public void setDarkLevel(DarkLevel light) {
        level = light;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Day day = (Day) o;
        return day.getDarkLevel().equals(this.getDarkLevel());
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
