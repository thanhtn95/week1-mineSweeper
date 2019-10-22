
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Board Size : ");
        int size = sc.nextInt();
        System.out.println("Enter number of mines: ");
        int mine = sc.nextInt();

        int[][] board = getMineField(size, mine);
        boolean flag = false;
        System.out.println("Enter cordinate x/y: ");
        while (!flag) {
            String input = sc.nextLine();
            if (!input.isEmpty()) {
                String[] cordinate = input.split("/");
                int x = Integer.parseInt(cordinate[0]);
                int y = Integer.parseInt(cordinate[1]);
                if (x >= size || y >= size || x<0 || y <0) {
                    System.out.println("Invalid cordinate!!!!");
                } else {
                    if (board[x][y] == 1) {
                        System.out.println("You Died :)");
                        flag = true;
                    }else{
                        System.out.println("Enter cordinate x/y: ");
                    }
                }
            }
        }


    }

    private static int[][] getMineField(int size, int n) {
        int[][] field = new int[size][size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (count < n) {
                    field[i][j] = 1;
                    count++;
                } else field[i][j] = 0;
            }
        }

        Random random = new Random();
        for (int i = field.length - 1; i > 0; i--) {
            for (int j = field.length - 1; j > 0; j--) {
                int x = random.nextInt(i + 1);
                int y = random.nextInt(j + 1);

                int tmp = field[i][j];
                field[i][j] = field[x][y];
                field[x][y] = tmp;
            }
        }
        return field;
    }
}
