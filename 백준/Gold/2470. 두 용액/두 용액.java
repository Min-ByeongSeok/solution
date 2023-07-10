import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    static void input(){
        N = sc.nextInt();
        A = new int[N+1];

        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }
    }

    static int lowerBound(int[] A, int leftIdx, int rightIdx, int target){
        int findIdx = rightIdx + 1;

        while(leftIdx <= rightIdx){
            int midIdx = (leftIdx + rightIdx) / 2;
            // 용액중 가운데 값을 하나 골라서
            if(A[midIdx] >= target){
                // 배열의 가운데값이 내가 찾고있는 값보다 크거나 같다면
                findIdx = midIdx;
                rightIdx = midIdx - 1;
                // 왼쪽으로 한칸 당긴다 (최대범위를 줄인다)
            }
            else{
                // 배열의 가운데 값이 내가 찾고있는 값보다 작다면
                leftIdx = midIdx + 1;
                // 오른쪽으로 한칸 당긴다 (최소범위를 줄인다)
            }
        }
        return findIdx;
    }

    static void process() {
        Arrays.sort(A,1,N+1);

        int bestSum = Integer.MAX_VALUE;
        // 0과 가까운 합을 저장할 변수
        int v1 = 0, v2 = 0;

        for (int leftIdx = 1; leftIdx <= N - 1; leftIdx++) {
            // 1번용액부터 마지막 용액까지
            int result = lowerBound(A, leftIdx + 1, N, -A[leftIdx]);
            // 배열 A에서 고른 용액 오른쪽에서부터 마지막용액까지, 고른용액과의 합이 0과 가까운 요소를 찾는다.
            if(leftIdx < result - 1 && Math.abs(A[result - 1] + A[leftIdx]) < bestSum){
                bestSum = Math.abs(A[leftIdx] + A[result - 1]);
                v1 = A[leftIdx];
                v2 = A[result - 1];
            }

            if(result <= N && Math.abs(A[result] + A[leftIdx]) < bestSum){
                bestSum = Math.abs(A[leftIdx] + A[result]);
                v1 = A[leftIdx];
                v2 = A[result];
            }
        }

        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
