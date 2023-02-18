import java.util.ArrayList;
import java.util.Scanner;
public class Player {
    public int positionX;
    public int positionY;
    public int energy;
    ArrayList<Weapon> weapons;
    Player() {
        this.energy = 3;
        this.weapons = new ArrayList<>();
    }
    public void burn() {
        this.energy -= 1;
    }
    public void attack() {
        if (weapons.size() == 0) {
            System.out.println("You don't have any weapons !!!");
            System.out.println("You were killed by boss");
            System.out.println("You lose !!!");
        } else {
            System.out.printf("I will use %s to kill boss\n", weapons.get(0).name);
            System.out.println("You win !!!");
        }
    }
    void move() {
//        System.out.println("Menu");
//        System.out.println("1.Play");
//        System.out.println("2.Luật chơi");
//        System.out.println("3.Quit");
        System.out.println("Các phím:");
        System.out.println("a:  di chuyển sang trái");
        System.out.println("s: di chuyển xuống dưới");
        System.out.println("w: di chuyển lên trên");
        System.out.println("d: di chuyển sang phải");
        System.out.println("0:Exit");
        Scanner scanner = new Scanner(System.in);
        boolean check =true;
        while (check) {
            System.out.println("Enter your choice: ");
            String playerChoice = scanner.next().trim().toLowerCase();
            if(playerChoice.equals("exit")){
                check=false;
            }
            else if(playerChoice.equals("w")) {
                if (this.canMove(this.positionX - 1, this.positionY)) {
                    this.positionX -= 1;
                    this.burn();
                    break;
                }
                else {
                    System.out.println("No way to move !!!");
                }
            }
            else if(playerChoice.equals("a")) {
                if(this.canMove(this.positionX, this.positionY - 1)) {
                    this.positionY -= 1;
                    this.burn();
                    break;
                }
                else {
                    System.out.println("No way to move !!!");
                }
            }
            else if(playerChoice.equals("d")) {
                if(this.canMove(this.positionX, this.positionY + 1)) {
                    this.positionY += 1;
                    this.burn();
                    break;
                }
                else {
                    System.out.println("No way to move !!!");
                }
            }
            else if(playerChoice.equals("s")) {
                if(this.canMove(this.positionX + 1, this.positionY)) {
                    this.positionX += 1;
                    this.burn();
                    break;
                }
                else {
                    System.out.println("No way to move !!!");
                }
            }
            else {
                System.out.println("Wrong choice");
            }
        }
    }
    private boolean canMove(int x, int y) {
        return (x >= 0) && (x <= Config.GAME_WIDTH - 1) && (y >= 0) && (y <= Config.GAME_HEIGHT - 1);
    }

    void playerInTunnel(Tunnel item) {
        if(item == null) {
            System.out.println("Empty because you came here !");
        }
        if(item instanceof Weapon) {
            item.showInfo();
            this.weapons.add((Weapon) item);
        }
        if(item instanceof Food) {
            item.showInfo();
            this.energy += ((Food) item).energy;
        }
        if(item instanceof Abyss) {
            item.showInfo();
            System.out.println("You fell into the abyss !!!");
        }
        if(item instanceof Boss) {
            item.showInfo();
            this.attack();
        }
    }
}

