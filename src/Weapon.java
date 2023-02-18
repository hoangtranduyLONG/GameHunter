public class Weapon extends Tunnel {
    public String name;
    public int energy;
    Weapon(int value, String name) {
        super(value);
        this.name = name;
    }

    @Override
    void showInfo() {
        System.out.printf("This tunnel has %s\n", this.name);
    }
}
