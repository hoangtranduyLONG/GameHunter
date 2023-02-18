import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Map {
    private Tunnel [][] tunnels;
    private Player player;
    Map(Player player) {
        this.player = player;
        this.tunnels = new Tunnel[Config.GAME_WIDTH][Config.GAME_HEIGHT];
        this.initMap();
        for(int row = 0; row < Config.GAME_WIDTH; row++) {
            for(int col = 0; col < Config.GAME_HEIGHT; col++) {
                if(this.tunnels[row][col] == null) {
                    System.out.print("   ");
                }
                else {
                    System.out.printf(" %d ", this.tunnels[row][col].value);
                }
            }
            System.out.println("");
        }
    }
    void draw() {
        for (int row = 0; row < Config.GAME_WIDTH; row++) {
            if(player.positionX == 0 && player.positionY == -1 && row == 0) {
                System.out.print(" p ");
            } else {
                System.out.print("   ");
            }
            for (int col = 0; col < Config.GAME_HEIGHT; col++) {
                String item = " ";
                if(player.positionX == row && player.positionY == col) {
                    item = "p";
                }
                System.out.printf("| %s ", item);
                if(col == Config.GAME_HEIGHT - 1) {
                    System.out.println("|");
                    System.out.println("   -------------");
                }
            }
        }
    }
    void initMap() {
        ArrayList<Integer> items = new ArrayList<>(Arrays.asList(
                Config.CHICKEN_VALUE,
                Config.BOAR_VALUE,
                Config.GUN_VALUE,
                Config.SWORD_VALUE,
                Config.ABYSS_VALUE,
                Config.ABYSS_VALUE,
                Config.EMPTY_VALUE,
                Config.EMPTY_VALUE,
                Config.BOSS_VALUE
        ));
        Random random = new Random();
        for (int row = 0; row < Config.GAME_WIDTH; row++) {
            for (int col = 0; col < Config.GAME_HEIGHT; col++) {
                int randIdx = random.nextInt(items.size());
                int value = items.get(randIdx);
                items.remove(randIdx);
                switch (value) {
                    case Config.CHICKEN_VALUE:
                        this.tunnels[row][col] = new Food(value, "Chicken", 1);
                        this.tunnels[row][col].setPosition(row, col);
                        break;
                    case Config.BOAR_VALUE:
                        this.tunnels[row][col] = new Food(value, "Boar", 2);
                        this.tunnels[row][col].setPosition(row, col);
                        break;
                    case Config.SWORD_VALUE:
                        this.tunnels[row][col] = new Weapon(value, "Sword");
                        this.tunnels[row][col].setPosition(row, col);
                        break;
                    case Config.GUN_VALUE:
                        this.tunnels[row][col] = new Weapon(value, "Gun");
                        this.tunnels[row][col].setPosition(row, col);
                        break;
                    case Config.EMPTY_VALUE:
                        this.tunnels[row][col] = new Food(value, "Empty", 0);
                        this.tunnels[row][col].setPosition(row, col);
                        break;
                    case Config.ABYSS_VALUE:
                        this.tunnels[row][col] = new Abyss(value);
                        this.tunnels[row][col].setPosition(row, col);
                        break;
                    case Config.BOSS_VALUE:
                        this.tunnels[row][col] = new Boss(value);
                        this.tunnels[row][col].setPosition(row, col);
                        break;
                }
            }
        }
        System.out.println();
    }
    public Tunnel[][] getTunnels() {
        return this.tunnels;
    }
    public void setItemInTunnels(int row, int col) {
        if(this.tunnels[row][col] instanceof Food || this.tunnels[row][col] instanceof Weapon) {
            this.tunnels[row][col] = null;
        }
    }
}
