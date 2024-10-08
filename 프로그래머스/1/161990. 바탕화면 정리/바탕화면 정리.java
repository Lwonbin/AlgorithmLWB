class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int leftX = 0;
        int rightX = 0;
        int leftY = 0;
        int rightY = 0;
        int count = 0;
        
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if(count == 0){
                        leftX = i;
                        leftY = j;
                        rightX = i+1;
                        rightY = j+1;
                        count++;
                    }else{
                        leftX = Math.min(i,leftX);
                        leftY = Math.min(j,leftY);
                        rightX = Math.max(i+1, rightX);
                        rightY = Math.max(j+1, rightY);     
                    }
                    System.out.println(leftX +" " +leftY+ " "+ rightX+ " "+rightY);
                }
             
            }
        }
        
        
        answer[0] = leftX;
        answer[1] = leftY;
        answer[2] = rightX;
        answer[3] = rightY;
        
        
        return answer;
    }
}