import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static String str;
    static StringBuilder sb = new StringBuilder();

    static void input(){
        N = sc.nextInt();
        str = sc.hasNext() ? sc.next() : "";
    }

    static void process(){
        int curR = 0;
        int curC = 0;
        boolean[][] passVertical = new boolean[N][N];
        boolean[][] passHorizon = new boolean[N][N];

        for (int i = 0; i < str.length(); i++) {
            char word = str.charAt(i);

            switch(word){
                case 'L':
                    if(curC == 0) continue;
                    passHorizon[curR][curC] = passHorizon[curR][--curC] = true;
                    break;
                case 'U':
                    if(curR == 0) continue;
                    passVertical[curR][curC] = passVertical[--curR][curC] = true;
                    break;
                case 'R':
                    if(curC == N-1) continue;
                    passHorizon[curR][curC] = passHorizon[curR][++curC] = true;
                    break;
                case 'D':
                    if(curR == N-1) continue;
                    passVertical[curR][curC] = passVertical[++curR][curC] = true;
                    break;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(passVertical[i][j] && passHorizon[i][j]){
                    sb.append('+');
                }
                else if(passVertical[i][j]) {
                    sb.append('|');
                }
                else if(passHorizon[i][j]) {
                    sb.append('-');
                }
                else {
                    sb.append('.');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}