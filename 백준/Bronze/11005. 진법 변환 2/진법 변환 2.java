import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int B;

    static void input(){
        N = sc.nextInt();
        B = sc.nextInt();
    }

    static void process(){
        StringBuilder sb = new StringBuilder();
        while(N > 0){
            int digit = N % B;
            if(digit < 10) sb.append(digit);
            else sb.append((char)(digit - 10 + 'A'));
            N /= B;
        }
        System.out.println(sb.reverse());
    }

    public static void main(String[] args) {
        input();
        process();
    }
}