import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static String[] S, Q;
    static Set<String> set;
    static int ans = 0;

    static void setInput(){
        N = sc.nextInt();
        M = sc.nextInt();
        set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }
    }

    static void setProcess(String s){
        if(set.contains(s)){
            ans++;
        }
    }

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        S = new String[N];
        Q = new String[M];

        for (int i = 0; i < N; i++) {
            S[i] = sc.next();
        }

        for (int i = 0; i < M; i++) {
            Q[i] = sc.next();
        }
    }

    static void process(){
        Arrays.sort(S);

        int count = 0;
        for (int i = 0; i < M; i++) {
            if(isExist(S, Q[i])){
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isExist(String[] s, String s1) {
        int left = 0;
        int right = s.length - 1;

        while(left <= right){
            int mid = (left + right)/2;
            // 정렬의 특성
            // 자신과 어떤 값를 비교했을 때 자신보다 작으면 음수
            // 자신보다 큰 값을 가지면 양수, 같다면 0
            int compareResult = S[mid].compareTo(s1);
            // 정렬의 특성을 가져와서
            // 음수 즉 자신보다 작은 값이면 left를 당겨서 최소값을 크게 만든다.
            if(compareResult < 0) {
                left = mid + 1;
            }
            // 양수 즉 자신보다 큰 값이면 right를 당겨서 최대값을 작게 만든다
            else if(compareResult > 0){
                right = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
