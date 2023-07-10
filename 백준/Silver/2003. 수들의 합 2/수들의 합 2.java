import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static int[] A;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
    }

    static void process(){
        int ans = 0;
        int rightIdx = 0;
        int currentSum = A[0];

        for (int leftIdx = 0; leftIdx < N; leftIdx++) {
            while(currentSum < M && rightIdx < N - 1){
                currentSum += A[++rightIdx];
            }
            if(currentSum == M) ans++;

            currentSum -= A[leftIdx];
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}