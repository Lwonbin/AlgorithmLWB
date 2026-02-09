import java.io.*;
import java.util.*;

public class Main {

    static class chess{
        int row;
        int col;
        int dir;
        chess(int row, int col, int dir){
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
    }

    static ArrayList<Integer>[][] board;

    static int[][] map;
    static chess[] chessArr;

    static int[] dr = {0, 0,0,-1, 1};
    static int[] dc = {0, 1,-1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        chessArr = new chess[K];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        board = new ArrayList[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                board[i][j] = new ArrayList<>();
            }
        }


        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int curRow = Integer.parseInt(st.nextToken()) -1;
            int curCol = Integer.parseInt(st.nextToken()) -1;
            int curDir = Integer.parseInt(st.nextToken());

            chess CurChess = new chess(curRow, curCol, curDir);
            chessArr[i] = CurChess;
            board[curRow][curCol].add(i);
        }


        for(int turn = 1; turn<=1000; turn++){
            for(int i=0; i<K; i++){
                if(movePiece(i,N)){
                    System.out.println(turn);
                    return;
                }
            }
        }

        System.out.println(-1);





    }

    static int reverseDir(int d){
        if(d == 1) return 2;
        else if(d==2) return 1;
        else if(d==3) return 4;
        else return 3;
    }

    static boolean movePiece(int i, int N) {
        int r = chessArr[i].row;
        int c = chessArr[i].col;
        int d = chessArr[i].dir;

        ArrayList<Integer> curStack = board[r][c];

        if(curStack.get(0) != i) return false;

        int idx = 0;

        while(curStack.get(idx) != i) idx++;

        ArrayList<Integer> moving = new ArrayList<>();

        for(int t = idx; t<curStack.size(); t++){
            moving.add(curStack.get(t));
        }

        for(int t = curStack.size() -1; t>=idx; t--) curStack.remove(t);

        int nr = r + dr[d];
        int nc = c + dc[d];

        if(isBlueOrOut(nr, nc, N)){
            d = reverseDir(d);
            chessArr[i].dir = d;

            nr = r+ dr[d];
            nc = c+ dc[d];

            if(isBlueOrOut(nr, nc, N)){
                curStack.addAll(moving);
                return false;
            }
        }

        if(map[nr][nc] == 1){
            Collections.reverse(moving);
        }

        board[nr][nc].addAll(moving);

        for(int p : moving){
            chessArr[p].row = nr;
            chessArr[p].col = nc;
        }

        return board[nr][nc].size() >= 4;


    }

    static boolean isBlueOrOut(int nr, int nc, int N){
        return nr <0 || nc <0 || nr>=N || nc >=N || map[nr][nc] ==2;
    }




}
