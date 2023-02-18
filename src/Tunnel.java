public abstract class Tunnel {
    public int value;
    public int positionX;
    public int positionY;
    Tunnel(int value) {
        this.value = value;
    }
    void setPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }
    abstract void showInfo();
}
