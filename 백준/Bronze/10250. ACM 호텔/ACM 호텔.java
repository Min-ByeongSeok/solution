import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int T, H, W, N;

    static void input(){
        H = sc.nextInt(); // 층수
        W = sc.nextInt(); // 호수
        N = sc.nextInt(); // 몇번째 손님
    }

    static void process(){
        int floor = ((N-1) % H) + 1;
        int dist = ((N-1) / H) + 1;

        System.out.printf("%d%02d\n", floor,dist);
    }

    public static void main(String[] args) {
        T = sc.nextInt();
        while(T-- > 0){
            input();
            process();
        }
    }
}