public class GameManager {
    private Player player;
    private Map map;
    GameManager() {
        player = new Player();
        // Set start position
        player.positionX = 0;
        player.positionY = -1;
        map = new Map(player);
    }
    void run() {
        while (!this.isGameOver()) {
            map.draw();
            player.move();
            Tunnel currentTunnel = this.map.getTunnels()[this.player.positionX][this.player.positionY];
            player.playerInTunnel(currentTunnel);
            this.map.setItemInTunnels(this.player.positionX, this.player.positionY);
        }
        System.out.println("Game over !!!");
    }
    private boolean isGameOver() {
        if (this.player.positionX == 0 && this.player.positionY == -1) {
            return false;
        }
        if (this.player.energy < 0) {
            System.out.println("You have consumed all your energy");
            return true;
        }
        if (this.map.getTunnels()[this.player.positionX][this.player.positionY] instanceof Boss) {
            return true;
        }
        if (this.map.getTunnels()[this.player.positionX][this.player.positionY] instanceof Abyss) {
            return true;
        }
        return false;
    }
}
