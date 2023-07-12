import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, cnt;
    static char[][] board;

    static void input() {
        N = sc.nextInt();

        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = sc.next().toCharArray();
        }
    }

    static void process() {
        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i + 1 < N && board[i][j] != board[i + 1][j]) {
                    // 사탕바꾸기
                    swap(board, i, j, i + 1, j);
                    // 찾기
                    ans = Math.max(Math.max(findCol(board), findRow(board)), ans);
                    // 원복
                    swap(board, i, j, i + 1, j);
                }
                if (j + 1 < N && board[i][j] != board[i][j + 1]) {
                    // 사탕바꾸기
                    swap(board, i, j, i, j + 1);
                    // 찾기
                    ans = Math.max(Math.max(findCol(board), findRow(board)), ans);
                    // 원복
                    swap(board, i, j, i, j + 1);
                }
            }
        }

        System.out.println(ans);
    }

    private static int findRow(char[][] board) {

        int max = 0;

        for (int i = 0; i < N; i++) {
            int len = 1;
            for (int j = 1; j < N; j++) {
                if(board[i][j] == board[i][j-1]){
                    len++;
                }
                else{
                    max = Math.max(max, len);
                    len = 1;
                }
            }
            max = Math.max(max, len);
        }

        return max;
    }

    private static int findCol(char[][] board) {
        int max = 0;

        for (int i = 0; i < N; i++) {
            int len = 1;
            for (int j = 1; j < N; j++) {
                if(board[j][i] == board[j-1][i]){
                    len++;
                }
                else{
                    max = Math.max(max, len);
                    len = 1;
                }
            }
            max = Math.max(max, len);
        }

        return max;
    }

    private static void swap(char[][] board, int i, int j, int mi, int mj) {
        char tmp = board[i][j];
        board[i][j] = board[mi][mj];
        board[mi][mj] = tmp;
    }

    public static void main(String[] args) {
        input();
        process();
    }
}