import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int C = Integer.parseInt(br.readLine());

        List<Integer> listX = new ArrayList<>();
        List<Integer> listY = new ArrayList<>();

        for(int i=0; i<C; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            if(X ==0){
                listX.add(Y);
            }
            else{
                listY.add(Y);
            }
        }


        listX.sort((o1,o2) -> o1-o2); //2,3,8
        listY.sort((o1,o2) -> o1-o2); //4,10
        listX.add(M);
        listY.add(N);
        int max = 0;
        int curX = 0;
        int curY = 0;


        for(int i=0; i<listX.size(); i++){
            for(int j=0; j<listY.size(); j++){
                int cur = (listX.get(i) - curX) * (listY.get(j) - curY);
                max = Math.max(max, cur);
                curY = listY.get(j);
            }
            curX = listX.get(i);
            curY = 0;
        }

        System.out.println(max);


        br.close();



    }
}
