import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static char[][] map;
    static boolean[] rowExist;
    static boolean[] colExist;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = sc.next().toCharArray();
        }

        rowExist = new boolean[N];
        colExist = new boolean[M];
    }

    static void process(){
        int rowCount = N;
        int colCount = M;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'X'){
                    rowExist[i] = true;
                    colExist[j] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if(rowExist[i]) rowCount--;
        }
        for (int i = 0; i < M; i++) {
            if(colExist[i]) colCount--;
        }

        System.out.println(Math.max(rowCount, colCount));
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
