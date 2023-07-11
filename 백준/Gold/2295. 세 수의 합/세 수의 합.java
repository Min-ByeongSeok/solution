import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[] arr;

    static void input() {
        N = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
    }

    static void process() {
        Set<Integer> set = new HashSet<>();
        int ans = -1;
        // A + B + C = X => A + B = X - C
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = arr[i] - arr[j];
                if (set.contains(sum)) {
                    ans = Math.max(ans, arr[i]);
                }
            }
        }

        System.out.println(ans);
    }

    static void process2() {
        int[] sum = new int[N*N];
        int sumIdx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sum[sumIdx++] = arr[i] + arr[j];
            }
        }

        int ans = -1;
        Arrays.sort(sum);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int target = arr[i] - arr[j];
                if (isExist(sum, target)) {
                    ans = Math.max(ans, arr[i]);
                }
            }
        }

        System.out.println(ans);
    }

    private static boolean isExist(int[] sum, int target) {
        int left = 0;
        int right = sum.length-1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (sum[mid] > target) right = mid - 1;
            else if (sum[mid] < target) left = mid + 1;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
