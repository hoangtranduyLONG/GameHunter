public class Food extends Tunnel {
    public String name;
    public int energy;
    Food(int value,String name,int energy){
        super(value);
        this.energy=energy;
        this.name=name;
    }
    @Override
    void showInfo() {
        System.out.println("This tunnel contain ");
    }

    {
}
}
