import java.io.*;
import java.util.*;

public class Main {
    static char[][] TicTacToe = new char[3][3];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while(true) {


            String str = br.readLine();

            if (str.equals("end")) {
                break;
            }



            int count = 0;

            int Xcount = 0;
            int Ocount = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    TicTacToe[i][j] = str.charAt(count);
                    if(TicTacToe[i][j] == 'X'){
                        Xcount++;
                    }else if(TicTacToe[i][j] == 'O'){
                        Ocount++;
                    }
                    count++;
                }
            }

//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    System.out.print(TicTacToe[i][j]);
//                }
//                System.out.println();
//            }

            boolean Xresult = check('X');
            boolean Oresult = check('O');




            if(Xresult && !Oresult){
               if(Xcount == Ocount +1){
                   System.out.println("valid");
                   continue;
               }
            }else if(!Xresult && Oresult){
                if(Xcount==Ocount){
                    System.out.println("valid");
                    continue;
                }
            }


            if(!Xresult && !Oresult){
                if(Xcount ==5 && Ocount == 4 ){
                    System.out.println("valid");
                    continue;
                }
            }



            System.out.println("invalid");









        }

        br.close();
        bw.flush();
        bw.close();


    }

    static boolean check(char player){

        //가로
        if(TicTacToe[0][0] == player && TicTacToe[0][1] == player && TicTacToe[0][2] == player) {
            return true;
        }else if(TicTacToe[1][0] == player && TicTacToe[1][1]== player && TicTacToe[1][2] == player){
            return true;
        }else if(TicTacToe[2][0] == player && TicTacToe[2][1] == player && TicTacToe[2][2] == player) {
            return true;
        }

        //세로
        if(TicTacToe[0][0] == player && TicTacToe[1][0]  == player && TicTacToe[2][0] == player) {
            return true;
        }else if(TicTacToe[0][1] == player && TicTacToe[1][1] == player && TicTacToe[2][1] == player) {
            return true;
        }else if(TicTacToe[0][2] == player && TicTacToe[1][2] == player && TicTacToe[2][2] == player) {
            return true;
        }


        if(TicTacToe[0][0] == player && TicTacToe[1][1] == player && TicTacToe[2][2] == player) {
            return true;
        }else if(TicTacToe[0][2] == player && TicTacToe[1][1] == player && TicTacToe[2][0] == player) {
            return true;
        }

        return false;

    }
}
