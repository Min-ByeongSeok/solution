import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, Q, ans;
    static int[] arr, acc;

    static void input(){
        N = sc.nextInt();
        Q = sc.nextInt();

        arr = new int[N+1];
        acc = new int[N+1];
        for (int i = 1; i <= N; i++) {
            int x = sc.nextInt();

            arr[i] = x;
        }

        for (int i = 1; i <= N ; i++) {
            acc[i] = acc[i-1] ^ arr[i];
        }
    }

    static void process(int s, int e){
        ans ^= acc[e] ^ acc[s-1];
    }

    public static void main(String[] args) {
        input();

        while(Q-- > 0){
            int s = sc.nextInt();
            int e = sc.nextInt();
            process(s, e);
        }

        System.out.println(ans);
    }
}
