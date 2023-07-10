import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int testCase;
    static int[] N, T;

    static void input(){
        testCase = sc.nextInt();
        N = new int[testCase];
        T = new int[51];

        for (int i = 0; i < N.length; i++) {
            N[i] = sc.nextInt();
        }
        for (int i = 1; i < T.length; i++) {
            T[i] = T[i-1] + i;
        }
    }

    static boolean isEurekaNum(int num){
        for (int i = 1; i < T.length; i++) {
            if(T[i] >= num) break;
            for (int j = 1; j < T.length; j++) {
                if(T[j] >= num) break;
                if(T[i]+T[j] >= num) break;
                for (int k = 1; k < T.length; k++) {
                    if(T[k] >= num) break;
                    if(T[i]+T[j]+T[k] > num) break;

                    if(T[i] + T[j] + T[k] == num){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static void process(){
        for (int i = 0; i < N.length; i++) {
            if(isEurekaNum(N[i])) {
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
