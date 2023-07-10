import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static Scanner sc = new Scanner(System.in);
    static int N;
    static Integer[] arr;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
//        N = sc.nextInt();
//        arr = new int[N];
        arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
//            arr[i] = sc.nextInt();
        }
    }

    static void process() throws IOException {
        Arrays.sort(arr);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();

//        for (int i = 0; i < N; i++) {
//            System.out.println(arr[i]);
//        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
