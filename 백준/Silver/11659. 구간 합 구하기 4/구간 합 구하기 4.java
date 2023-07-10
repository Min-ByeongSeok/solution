import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static int[] acc, arr;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N+1];
        acc = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= N ; i++) {
            acc[i] = acc[i-1] + arr[i];
        }
    }

    static void process(){
        while(M-- > 0){
            int left = sc.nextInt();
            int right = sc.nextInt();

            System.out.println(acc[right] - acc[left-1]);
        }
    }

    public static void main(String[] args) {
        input();
        process();
    }
}