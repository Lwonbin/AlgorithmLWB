    import java.io.*;
    import java.util.*;

    public class Main {

        //처음부터 북, 동, 남, 서
        static int[] dx = {0,1,0,-1};
        static int[] dy = {1,0,-1,0};

        public static void main(String[] args) throws IOException {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            int N = Integer.parseInt(br.readLine());


            for(int i=0; i<N; i++){
                int dir = 0;

                int maxX = 0;
                int maxY = 0;
                int minX = 0;
                int minY = 0;

                int curX = 0;
                int curY = 0;
                String testCase = br.readLine();
                for(int j=0; j<testCase.length(); j++){
                    if(testCase.charAt(j) == 'R'){
                        dir = (dir+1) %4;
                    }else if(testCase.charAt(j) == 'L'){
                        dir = (dir+3) %4;
                    }else if(testCase.charAt(j) == 'F'){
                        curX += dx[dir];
                        curY += dy[dir];
                    }else{
                        curX -= dx[dir];
                        curY -= dy[dir];
                    }

//                    0,0    0,1

                    if(curX > maxX){
                        maxX = curX;
                    }if(curY > maxY){
                        maxY = curY;
                    }
                    if(curX < minX){
                        minX = curX;
                    }
                    if(curY < minY){
                        minY = curY;
                    }
                }
                int answer = (maxX - minX) * (maxY - minY);
                sb.append(answer).append("\n");

            }


            System.out.println(sb.toString());

        }
    }