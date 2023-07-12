import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt(); // 수열의 크기 (배열의 크기)
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt(); // 각 배열에 원소 집어넣기
        }
        int sum = sc.nextInt(); // 합

        boolean[] exist = new boolean[1000001]; // 문제에서 배열의 크기를 정해줬기때문에
        // 최대크기로 선언했으며,
        for (int i = 0; i < size; i++) {
            exist[arr[i]] = true;
        }

        int ans = 0;
        for (int i = 0; i < size; i++) {
            int pairValue = sum - arr[i];

            if(0 <= pairValue && pairValue <= exist.length)
                ans += exist[pairValue]? 1:0;
        }
        System.out.println(ans/2);
    }
}