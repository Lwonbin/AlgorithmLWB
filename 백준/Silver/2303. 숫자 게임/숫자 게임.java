import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] result = new int[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[st.countTokens()];
            int max = 0;
            for(int j=0; j<5; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int p=0; p<5; p++){
                for(int q=p+1; q<5; q++){
                    for(int k=q+1; k<5; k++){
                        int cur = arr[p]+arr[q]+arr[k];
                        int cur1 = cur%10;
                        max = Math.max(max, cur1);

                    }
                }
            }
            result[i] = max;
        }



        int maxIndex = 0;
        int resultMax = 0;
        for(int i=0; i<result.length; i++){
            if(resultMax < result[i]){
                resultMax = result[i];
                maxIndex = i;
            }else if(resultMax == result[i]){
                maxIndex = Math.max(maxIndex, i);
            }
        }

        System.out.println(maxIndex+1);

    }
}
