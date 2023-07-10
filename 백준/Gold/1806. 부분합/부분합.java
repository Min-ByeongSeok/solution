import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, S;
    static int[] arr;

    static void input(){
        N = sc.nextInt();
        S = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
    }

    static void process(){
        int ans = Integer.MAX_VALUE;
        int right = 0;
        int sum = arr[0];

        for (int left = 0; left < N; left++) {
            while(right < N-1 && sum < S){
                sum += arr[++right];
            }

            if(sum >= S){
                int tmp = right - left + 1;
                if(ans > tmp){
                    ans = tmp;
                }
            }
            sum -= arr[left];
        }
        if(ans == Integer.MAX_VALUE){
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        input();
        process();
    }
}