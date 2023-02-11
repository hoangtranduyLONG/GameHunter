import java.util.Scanner;

public class Main {

    static final int BOARD_SIZE =3;
    static final int PLAYER_X =1;


    public static void main(String[] args) {
        int [][] board = new int[BOARD_SIZE][BOARD_SIZE];
        int playerX =1;
        int player0 =-1;
        int currentPlayer=PLAYER_X;
        int numberTurn =0;
        while (true){
            if(isWin(board)){
                int prevPlayer =-currentPlayer;
                System.out.printf("Win player is %s",prevPlayer ==PLAYER_X?"X":"0");
                break;
            }
            if(numberTurn==8){
                System.out.println("There are no player win");
                break;
            }
            System.out.printf("Turn of players %s\n",currentPlayer==PLAYER_X? "X":"0");
            drawBoard(board);
            int position =input();
            int row =(int)(position -1)/BOARD_SIZE;
            int col =(int) (position -1)/BOARD_SIZE;

                System.out.printf("Already input value on position %d\n",position);
                continue;
            }
            numberTurn++;
            currentPlayer=-currentPlayer;
        }

    static void drawBoard(int [][]board){
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                int value = board[row][col];
                if (value == PLAYER_X) {
                    System.out.printf("|  X  ");

                }else{
                    System.out.printf("|    ");
                }
                if(col == BOARD_SIZE -1){
                    System.out.println("|");
                    System.out.println("----------------");
                }
            }
        }
    }
    static int input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter position");
        int position =scanner.nextInt();
        while (position<1 || position>9){
            System.out.println("Invalid position,position must in range [1,9]");
            System.out.print("Enter position:");
        }
        return position;
    }
    static boolean isWin(int[][] board){
        for (int i = 0; i < BOARD_SIZE; i++) {
            int totalRow = calcSumRow(i,board);
            int totalCol= calcSumRow(i,board);
            if(Math.abs(totalRow)==BOARD_SIZE|| Math.abs(totalCol)==BOARD_SIZE){
                return true;
            }
        }
        int totalDiagonal1 =board[0][0]+ board[1][1]+board[2][2];
        int totalDiagonal2=board[0][2]+board[1][1]+board[2][0];
        if (Math.abs(totalDiagonal1)==BOARD_SIZE||Math.abs(totalDiagonal2)==BOARD_SIZE){
            return true;
        }
        return false;
    }
    static int calcSumRow(int row,int[][]board){
        int total =0;
        for(int value :board[row]){
            total+=value;
        }
        return total;
    }
    static int calcSumCol(int col,int[][] board){
        int total =0;
        for (int i = 0; i < board.length; i++) {
            total+=board[i][col];
        }
        return total;
    }
}
