import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int studentNumber = Integer.parseInt(br.readLine());
        int[][] studentArr = new int[studentNumber][2];
        for (int j = 0; j < studentNumber; j++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            studentArr[j][0] = Integer.parseInt(st2.nextToken());
            studentArr[j][1] = Integer.parseInt(st2.nextToken());

        }


        for (int p = 0; p < studentNumber; p++) {
            int count = 0;
            int A = studentArr[p][1] - 1;

            if (studentArr[p][0] == 1) {
                for (int q = 0; q < arr.length; q++) {
                    if ((q + 1) % studentArr[p][1] == 0) {
                        if (arr[q] == 0) {
                            arr[q] = 1;
                        } else {
                            arr[q] = 0;
                        }
                    }
                }

            } else if (studentArr[p][0] == 2) {

                if (arr.length / 2 > studentArr[p][1]) {
                    count = studentArr[p][1] - 1;
                } else {
                    count = arr.length - studentArr[p][1];
                }
                if (arr[A] == 0) {
                    arr[A] = 1;
                } else {
                    arr[A] = 0;
                }

                for (int x = 1; x < count + 1; x++) {
                    if (arr[A - x] == arr[A + x]) {
                        if (arr[A - x] == 0) {
                            arr[A - x] = 1;
                            arr[A + x] = 1;
                        } else {
                            arr[A - x] = 0;
                            arr[A + x] = 0;
                        }
                    } else {
                        break;
                    }
                }

            }
        }


        for (int t =0; t < N; t++) {
            bw.write(arr[t] + " ");
            if ((t+1) % 20 == 0) {
                bw.newLine();
            }
        }


        br.close();
        bw.flush();
        bw.close();
    }
}
