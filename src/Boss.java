public class Boss extends Tunnel{
    Boss(int value) {
        super(value);
    }

    @Override
    void showInfo() {
        System.out.println("I am boss");
        System.out.println("You will be my meal !");
        System.out.println("Hahaha");
    }
}
