import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static int[] myCard, check;
    static Map<Integer, Integer> map = new TreeMap<>();

    static void input(){
        N = sc.nextInt();
//        myCard = new int[N];
//        for (int i = 0; i < N; i++) {
//            myCard[i] = sc.nextInt();
//        }
        for (int i = 0; i < N; i++) {
            int card = sc.nextInt();
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        M = sc.nextInt();
        check = new int[M];
        for (int i = 0; i < M; i++) {
            check[i] = sc.nextInt();
        }
    }

    static void process(){
        int[] ans = new int[M];
        for (int i = 0; i < M; i++) {
            if(map.containsKey(check[i])){
                ans[i] = map.get(check[i]);
            } else {
                ans[i] = 0;
            }
        }

        System.out.println(
        Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
