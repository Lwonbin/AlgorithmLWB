import java.io.*;
import java.util.*;

public class Main {

    static int[][] gear = new int[5][8]; // 1~4 사용, 0은 미사용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= 4; i++) {
            String s = br.readLine().trim();
            for (int j = 0; j < 8; j++) gear[i][j] = s.charAt(j) - '0';
        }

        int count = Integer.parseInt(br.readLine());

        for (int c = 0; c < count; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken()); // 1~4
            int dir = Integer.parseInt(st.nextToken());    // 1 or -1
            rotate(target, dir);
        }

        int result = 0;
        if (gear[1][0] == 1) result += 1;
        if (gear[2][0] == 1) result += 2;
        if (gear[3][0] == 1) result += 4;
        if (gear[4][0] == 1) result += 8;

        System.out.println(result);

        br.close();
        bw.flush();
        bw.close();
    }

    static void rotate(int target, int dir) {
        int[] dirs = new int[5];
        dirs[target] = dir;

        // 왼쪽 전파(1까지)
        for (int i = target - 1; i >= 1; i--) {
            // 끊기면 더 왼쪽도 전부 중단
            if (gear[i][2] != gear[i + 1][6]) {
                dirs[i] = -dirs[i + 1];
            } else {
                break;
            }
        }

        // 오른쪽 전파(4까지)
        for (int i = target + 1; i <= 4; i++) {
            if (gear[i - 1][2] != gear[i][6]) {
                dirs[i] = -dirs[i - 1];
            } else {
                break;
            }
        }

        // 결정된 방향대로 '동시에' 회전 적용
        for (int i = 1; i <= 4; i++) {
            if (dirs[i] == 0) continue;
            if (dirs[i] == 1) timeArr(i);
            else RetimeArr(i);
        }
    }

    // 시계 방향(오른쪽으로 한 칸)
    static void timeArr(int idx) {
        int last = gear[idx][7];
        for (int j = 7; j >= 1; j--) {
            gear[idx][j] = gear[idx][j - 1];
        }
        gear[idx][0] = last;
    }

    // 반시계 방향(왼쪽으로 한 칸)
    static void RetimeArr(int idx) {
        int first = gear[idx][0];
        for (int j = 0; j < 7; j++) {
            gear[idx][j] = gear[idx][j + 1];
        }
        gear[idx][7] = first;
    }
}
