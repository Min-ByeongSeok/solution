import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[][] arr, acc;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        // 문제에서 인덱스가 1부터 시작하기때문에 배열의 크기를 1칸 증가시킴
        arr = new int[N+1][N+1];
        acc = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int x = sc.nextInt();

                arr[i][j] = x;
                acc[i][j] = acc[i-1][j] + acc[i][j-1] - acc[i-1][j-1] + arr[i][j];
            }
        }
    }

    static void process(int x1,int y1,int x2,int y2) throws IOException {
        int ans = 0;
        // 1. 누적합 배열을 구한다

        ans = acc[x2][y2] - acc[x1-1][y2] - acc[x2][y1-1] + acc[x1-1][y1-1];
//        System.out.println(ans);
        bw.write(ans + "\n");

    }


    public static void main(String[] args) throws IOException {
        input();
        while(M-- > 0){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            process(x1,y1,x2,y2);
        }
        bw.flush();
    }
}