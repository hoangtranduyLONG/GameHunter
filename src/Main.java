import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       GameManager gameManager=new GameManager();
//      gameManager.run();
       Scanner scanner=new Scanner(System.in);
       Player player=new Player();
        System.out.println("Menu");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("Lựa chọn");
        int a =scanner.nextInt();
        switch (a){
            case 1:gameManager.run();
            break;
        }
//        switch (a){
//            case 3:gameManager.run();
//                break;
        }
    }



