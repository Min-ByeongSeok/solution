import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] cnt;

    static void input() throws IOException {

        N = Integer.parseInt(br.readLine());
        cnt = new int[10001];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            cnt[num]++;
        }
    }

    static void process() throws IOException {
        for (int i = 1; i <= 10000 ; i++) {
            while(cnt[i]-- > 0){
                bw.write(i + "\n");
            }
        }

        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
