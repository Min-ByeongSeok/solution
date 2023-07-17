import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static Set<Integer> set = new TreeSet<>();
    static int[] coord;

    static void input(){
        N = sc.nextInt();
        coord = new int[N];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();

            coord[i] = x;
            set.add(x);
        }

    }

    static void process() {
        Map<Integer, Integer> map = new HashMap<>();

        int idx = 0;
        for (Integer integer : set) {
            // 정렬되어있는 set의 원소를 하나씩 꺼내서
            // map에 넣는데 넣을때마다 인덱스가 증가
            map.put(integer, idx++);
        }

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = map.get(coord[i]);
        }

        System.out.println(
                Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "))
        );
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
