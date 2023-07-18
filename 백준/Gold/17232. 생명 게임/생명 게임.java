import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, M, T, K, a, b;
    static char[][] board;

    static void input() {
        N = sc.nextInt(); // 세로
        M = sc.nextInt(); // 가로
        T = sc.nextInt(); // 관찰하고자 하는 시간
        K = sc.nextInt(); // 주위의 기준
        a = sc.nextInt(); // 각 칸의 다음상황
        b = sc.nextInt(); // 각 칸의 다음상황

        board = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String row = sc.next();
            for (int j = 1; j <= M; j++) {
                board[i][j] = row.charAt(j - 1);
            }
        }
    }

    static void process() {
        int[][] acc = getPrefixSum(board);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int nearAlive = getRangeSum(acc, i, j, K);
                if (board[i][j] == '*') {
                    nearAlive--;
                    if (nearAlive < a || b < nearAlive) {
                        board[i][j] = '.';
                    }
                }
                else if (a < nearAlive && nearAlive <= b) {
                    board[i][j] = '*';
                }
            }
        }
    }

    private static int getRangeSum(int[][] acc, int i, int j, int k) {
        int r1 = Math.max(i - k, 1);
        int c1 = Math.max(j - k, 1);
        int r2 = Math.min(i + k, acc.length - 1);
        int c2 = Math.min(j + k, acc[0].length - 1);

        return acc[r2][c2] - acc[r1 - 1][c2] - acc[r2][c1 - 1]  + acc[r1 - 1][c1 - 1];
    }

    private static int[][] getPrefixSum(char[][] map) {
        int N = map.length - 1;
        int M = map[0].length - 1;
        int[][] acc = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int alive = (map[i][j] == '*' ? 1 : 0);

                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + alive;
            }
        }

        return acc;
    }


    public static void main(String[] args) {
        input();
        while (T-- > 0) {
            process();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
