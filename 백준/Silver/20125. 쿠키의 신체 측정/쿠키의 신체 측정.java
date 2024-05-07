import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        for(int i=0; i<N; i++){
            String abs = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = abs.charAt(j);
            }
        }
        int head_a=0;
        int head_b=0;

        loopout:
        for(int q=0; q<N; q++){
            for(int p=0; p<N; p++){
                if(arr[q][p] == '*'){
                    head_a = q;
                    head_b = p;
                    break loopout;
                }
            }
        }

        int heart_a = head_a+1;
        int heart_b = head_b;

        int left_arm = 0;
        for(int x = 0; x<heart_b; x++){
            if(arr[heart_a][x] == '*'){
                left_arm ++;
            }
        }

        int right_arm = 0;
        for(int x = heart_b+1; x<N; x++){
            if(arr[heart_a][x] == '*'){
                right_arm ++;
            }
        }

        int waist = 0;

        for(int x = heart_a+1; x<N; x++){
            if(arr[x][heart_b] == '*'){
                waist++;
            }
        }

        int B = heart_b;
        int A = heart_a+waist;
        int leftleg =0;
        for(int x = A+1; x<N; x++){
            if(arr[x][B-1] == '*'){
                leftleg++;
            }

        }

        int rightleg =0;
        for(int x = A+1; x<N; x++){
            if(arr[x][B+1] == '*'){
                rightleg++;
            }

        }

        bw.write((heart_a+1)+" "+(heart_b+1));
        bw.write("\n");
        bw.write(left_arm + " " + right_arm +" " + waist + " " + leftleg + " " + rightleg);






        br.close();
        bw.flush();
        bw.close();
    }
}
