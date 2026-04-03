class Solution {
    public int solution(String[] board) {
        int answer = -1;
        
        int Ocount = 0;
        int Xcount = 0;
        
        char[][] map = new char[3][3];        
        
        for(int i=0; i<board.length; i++){
            String str = board[i];
            for(int j=0; j<3; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'O'){
                    Ocount++;
                }else if(map[i][j]=='X'){
                    Xcount++;
                }
            
            }
        }
        
        int Ocheck = 0;
        int Xcheck = 0;
        
        for(int i=0; i<3; i++){
            if(map[i][0] == 'O' && map[i][1] == 'O' && map[i][2] == 'O'){
                Ocheck++;
            }else if(map[i][0] == 'X' && map[i][1] == 'X' && map[i][2] == 'X'){
                Xcheck++;
            }
            
            if(map[0][i] == 'O' && map[1][i] == 'O' && map[2][i] == 'O'){
                Ocheck++;
            }else if(map[0][i] == 'X' && map[1][i] == 'X' && map[2][i] == 'X'){
                Xcheck++;
            }
        }
        
        if(map[0][0] == 'O' && map[1][1] == 'O' && map[2][2] == 'O'){
              Ocheck++;
        }else if(map[0][0] == 'X' && map[1][1] == 'X' && map[2][2] == 'X'){
            Xcheck++;
        }
        
        if(map[0][2] == 'O' && map[1][1] == 'O' && map[2][0] == 'O'){
              Ocheck++;
        }else if(map[0][2] == 'X' && map[1][1] == 'X' && map[2][0] == 'X'){
            Xcheck++;
        }
        
        
        if(Ocount + Xcount == 0){
            return 1;
        }
        
        if(Ocount < Xcount || Ocount > Xcount +1){
            return 0;
        }
        
        if(Ocheck >= 1 && Ocount != Xcount+1){
            return 0;
        }
        
        if(Xcheck >=1 && Ocount != Xcount){
            return 0;
        }
        
        return 1;
        
    }
}