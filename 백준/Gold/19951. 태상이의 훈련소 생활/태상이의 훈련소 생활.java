import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N; // 연병장 크기
    static int M; // 조교 수
    static int[] H; // 연병장 각 칸의 높이
    static int[] acc;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        H = new int[N+1];
        for (int i = 1; i <= N; i++) {
            H[i] = sc.nextInt();
        }

        acc = new int[N+2];
        while(M-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();

            acc[a] += k;
            acc[b+1] -= k;
        }
    }

    static void process(){
        int[] newAcc = new int[N+1];

        for (int i = 1; i <= N ; i++) {
            newAcc[i] = newAcc[i-1] + acc[i];
            System.out.print(newAcc[i] + H[i] + " ");
        }
    }

    public static void main(String[] args) {
        input();
        process();
    }
}