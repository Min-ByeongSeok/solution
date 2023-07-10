import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int T;
    static int[] students;
    static int ans = 0;

    static void input() {
        T = sc.nextInt();

    }

    static int process(int seq) {
        int ans = 0;
        for (int i = 1; i < seq; i++) {
            if(students[i] > students[seq]){
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        input();
        while (T-- > 0) {
            students = new int[21];
            ans = 0;

            for (int i = 0; i < students.length; i++) {
                students[i] = sc.nextInt();

                if (i > 1)
                    ans += process(i);
            }

            System.out.print(students[0] + " ");
            System.out.println(ans);
        }
    }
}