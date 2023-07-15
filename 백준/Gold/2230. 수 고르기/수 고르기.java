import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static int[] arr;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
    }

    static void process(){
        Arrays.sort(arr);
        int right = 0;
        int ans = Integer.MAX_VALUE;

        for (int left = 0; left < arr.length; left++) {

            while(arr[right] - arr[left] < M && right+1 < arr.length){
                right++;
            }

            int newSub = arr[right] - arr[left];
            if(newSub >= M)
                ans = Math.min(ans, newSub);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}