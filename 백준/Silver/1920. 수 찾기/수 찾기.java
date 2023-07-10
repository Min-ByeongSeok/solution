import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static int[] arr, target;

    static void input() {
        N = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        M = sc.nextInt();

        target = new int[M];
        for (int i = 0; i < M; i++) {
            target[i] = sc.nextInt();
        }
    }

    static int process(int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] < target){
                left = mid + 1;
            }
            else if(arr[mid] > target){
                right = mid - 1;
            }
            else{
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(arr);

        for (int i = 0; i < target.length; i++) {
            int process = process(target[i]);

            System.out.println(process);
        }
    }
}
