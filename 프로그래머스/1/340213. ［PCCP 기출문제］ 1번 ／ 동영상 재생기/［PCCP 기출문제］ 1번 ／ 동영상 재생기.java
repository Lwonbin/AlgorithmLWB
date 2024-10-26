class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int curmin = 0;
        int cursec = 0;
        
        curmin = Integer.parseInt(pos.substring(0,2));
        cursec = Integer.parseInt(pos.substring(3,5));
        
        int videomin = Integer.parseInt(video_len.substring(0,2));
        int videosec = Integer.parseInt(video_len.substring(3,5));
        int videotime = videomin*60 + videosec;
        
        int curtime = curmin*60 + cursec;
        
        int opmin = Integer.parseInt(op_end.substring(0,2));
        int opsec = Integer.parseInt(op_end.substring(3,5));
        
        int opendmin = Integer.parseInt(op_end.substring(0,2));
        int opendsec = Integer.parseInt(op_end.substring(3,5));
        int opendtime = opendmin*60 + opendsec;
        
        int opstartmin= Integer.parseInt(op_start.substring(0,2));
        int opstartsec = Integer.parseInt(op_start.substring(3,5));
        int opstarttime = opstartmin*60 + opstartsec;
        
        if(opstarttime<= curtime && curtime <= opendtime){
            curtime = opendtime;
        }
        
        
        
        for(int i=0; i<commands.length; i++){
            if(commands[i].equals("next")){
                curtime += 10;
                
                if(opstarttime<= curtime && curtime <= opendtime){
                    curtime = opendtime;
                }
                
                if(curtime > videotime){
                    curtime = videotime;
                }
                
                
            }else if(commands[i].equals("prev")){
                if(curtime < 10){
                    curtime = 0;
                }else{
                    curtime -= 10;
                }
                if(opstarttime<= curtime && curtime <= opendtime){
                    curtime = opendtime;
                }
                
            }
        }
        
        curmin = curtime/60;
        cursec = curtime%60;
            
        
        System.out.print(curmin + " " + cursec);
        
        StringBuilder sb = new StringBuilder();
        
        if(curmin <10){
            sb.append("0");
            sb.append(curmin);
        }else{
            sb.append(curmin);
        }
        sb.append(":");
        
        if(cursec<10){
            sb.append(0);
            sb.append(cursec);
        }else{
            sb.append(cursec);
        }
        
        
        
        return sb.toString();
    }
}