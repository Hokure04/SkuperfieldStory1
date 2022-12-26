package Days;

public enum DarkLevel {
    LIGHT("Было светло"),
    DARK("Стало темней"),
    BLAKNESS("Мрак сгущался"),
    FULL_NIGHT("Полная темнота всё-таки наступила");
    protected String description;
    DarkLevel(String description){
        this.description = description;
    }
    public DarkLevel getDescription(){
        System.out.println(this.description);
        return null;
    }

}
