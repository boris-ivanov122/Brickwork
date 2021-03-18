import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();// M input
        int n = scanner.nextInt();//N input
        if (m > 100 || n > 100) { //Validate if they are under or equal to 100
            System.out.println(-1);
            return;
        }
        int numberOfBricks = m * n / 2; //The number of bricks that I will use in order to build the second layer
        ArrayDeque<Integer> brickHolder = new ArrayDeque<>();//brickHolder
        for (int i = 1; i <= numberOfBricks; i++) {//Placing the bricks into the brickHolder
            brickHolder.offer(i);
            brickHolder.offer(i);
        }

        int[][] Layer1 = new int[m][n]; //First layer
        int[][] Layer2 = new int[m][n]; // Second layer
        for (int row = 0; row < m; row++) { //The Console's first layer
            for (int col = 0; col < n; col++) {
                Layer1[row][col] = scanner.nextInt();
            }
        }
        int validation1 = 1; //Validation if there are no bricks with 3 halfs on a single column
        for (int row = 0; row < m-1 ; row++) {
            int current=0;
            for (int col = 0; col < n-1 ; col++) {
                if (current==Layer1[row][col]){
                    validation1++;
                    if(validation1>=3) {
                        System.out.println(-1);
                        return;
                    }
                }
                current=Layer1[row][col];
            }
        }
        int validation2 = 1; //Validation if there are no bricks with 3 halfs on a single row
        for (int col = 0; col < n ; col++) {
            int current=0;
            for (int row = 0; row < m ; row++) {
                if (current==Layer1[row][col]){
                    validation2++;
                    if(validation2>=3) {
                        System.out.println(-1);
                        return;
                    }
                }
                current=Layer1[row][col];
            }
        }
        if (n == 2) {//Building the second layer and checking all the possibilities by taking 4 bricks at a time if possible, or we take 2 bricks at a time.
            for (int row = 0; row < m; row += 2) {
                for (int col = 0; col < n; col += 2) {
                    if (Layer1[row][col] == Layer1[row][col + 1]
                            || Layer1[row + 1][col] == Layer1[row + 1][col + 1]) {
                        Layer2[row][col] = brickHolder.poll();
                        Layer2[row + 1][col] = brickHolder.poll();
                        Layer2[row][col + 1] = brickHolder.poll();
                        Layer2[row + 1][col + 1] = brickHolder.poll();
                    } else if (Layer1[row][col] == Layer1[row + 1][col]
                            || Layer1[row][col + 1] == Layer1[row + 1][col + 1]) {
                        Layer2[row][col] = brickHolder.poll();
                        Layer2[row][col + 1] = brickHolder.poll();
                        Layer2[row + 1][col] = brickHolder.poll();
                        Layer2[row + 1][col + 1] = brickHolder.poll();
                    }
                }
            }
        } else {
            for (int row = 0; row < m - 1; row += 2) {
                for (int col = 0; col < n - 3; col += 4) {
                    if (Layer1[row][col] != Layer1[row + 1][col]
                            && Layer1[row][col + 1] != Layer1[row][col + 2]
                            && Layer1[row + 1][col + 1] != Layer1[row + 1][col + 2]
                            && Layer1[row][col + 3] != Layer1[row + 1][col + 3]) {
                        Layer2[row][col] = brickHolder.poll();
                        Layer2[row + 1][col] = brickHolder.poll();
                        Layer2[row][col + 1] = brickHolder.poll();
                        Layer2[row][col + 2] = brickHolder.poll();
                        Layer2[row + 1][col + 1] = brickHolder.poll();
                        Layer2[row + 1][col + 2] = brickHolder.poll();
                        Layer2[row][col + 3] = brickHolder.poll();
                        Layer2[row + 1][col + 3] = brickHolder.poll();
                    } else if (Layer1[row][col] != Layer1[row][col + 1]
                            && Layer1[row + 1][col] != Layer1[row + 1][col + 1]
                            && Layer1[row][col + 2] != Layer1[row][col + 3]
                            && Layer1[row + 1][col + 2] != Layer1[row + 1][col + 3]) {
                        Layer2[row][col] = brickHolder.poll();
                        Layer2[row][col + 1] = brickHolder.poll();
                        Layer2[row + 1][col] = brickHolder.poll();
                        Layer2[row + 1][col + 1] = brickHolder.poll();
                        Layer2[row][col + 2] = brickHolder.poll();
                        Layer2[row][col + 3] = brickHolder.poll();
                        Layer2[row + 1][col + 2] = brickHolder.poll();
                        Layer2[row + 1][col + 3] = brickHolder.poll();
                    } else if (Layer1[row][col] != Layer1[row][col + 1]
                            && Layer1[row + 1][col] != Layer1[row + 1][col + 1]
                            && Layer1[row][col + 2] != Layer1[row + 1][col + 2]
                            && Layer1[row][col + 3] != Layer1[row + 1][col + 3]) {
                        Layer2[row][col] = brickHolder.poll();
                        Layer2[row][col + 1] = brickHolder.poll();
                        Layer2[row + 1][col] = brickHolder.poll();
                        Layer2[row + 1][col + 1] = brickHolder.poll();
                        Layer2[row][col + 2] = brickHolder.poll();
                        Layer2[row + 1][col + 2] = brickHolder.poll();
                        Layer2[row][col + 3] = brickHolder.poll();
                        Layer2[row + 1][col + 3] = brickHolder.poll();
                    } else if (Layer1[row][col] != Layer1[row + 1][col]
                            && Layer1[row][col + 1] != Layer1[row + 1][col + 1]
                            && Layer1[row][col + 2] != Layer1[row][col + 3]
                            && Layer1[row + 1][col + 2] != Layer1[row + 1][col + 3]) {
                        Layer2[row][col] = brickHolder.poll();
                        Layer2[row + 1][col] = brickHolder.poll();
                        Layer2[row][col + 1] = brickHolder.poll();
                        Layer2[row + 1][col + 1] = brickHolder.poll();
                        Layer2[row][col + 2] = brickHolder.poll();
                        Layer2[row][col + 3] = brickHolder.poll();
                        Layer2[row + 1][col + 2] = brickHolder.poll();
                        Layer2[row + 1][col + 3] = brickHolder.poll();
                    } else {
                        System.out.println(-1);
                        return;
                    }
                    if (col + 8 > n - 3 && col + 6 <= n) {
                        if (Layer1[row][col + 4] == Layer1[row][col + 5]
                                || Layer1[row + 1][col + 4] == Layer1[row + 1][col + 5]) {
                            Layer2[row][col + 4] = brickHolder.poll();
                            Layer2[row + 1][col + 4] = brickHolder.poll();
                            Layer2[row][col + 5] = brickHolder.poll();
                            Layer2[row + 1][col + 5] = brickHolder.poll();
                        } else if (Layer1[row][col + 4] == Layer1[row + 1][col + 4]
                                || Layer1[row][col + 5] == Layer1[row + 1][col + 5]) {
                            Layer2[row][col + 4] = brickHolder.poll();
                            Layer2[row][col + 5] = brickHolder.poll();
                            Layer2[row + 1][col + 4] = brickHolder.poll();
                            Layer2[row + 1][col + 5] = brickHolder.poll();
                        }
                        n += 10;
                    }
                }
            }
        }
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(Layer2[row][col] + " ");
            }
            System.out.println();
        }
    }
}
