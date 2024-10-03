class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[] left = {1,0};
        int[] right = {3,0};
        
        // 만약 1,4,7이라면 L을 출력후 left를 1이라면 1,3 / 4라면 1,2 / 7이라면 1,1
 
        
        for(int i=0; i<numbers.length; i++){
            //왼손 1,4,7
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                answer += "L";
                if(numbers[i] == 1){
                    left[0] = 1;
                    left[1] = 3;
                }
                else if(numbers[i] == 4){
                    left[0] = 1;
                    left[1] = 2;
                }
                else if(numbers[i] == 7){
                    left[0] = 1;
                    left[1] = 1;
                }
                
            }
        // 만약 3,6,9이라면 R을 출력 후 right를 3이라면 3,3 / 6이라면 3,2 / 9라면 3,1

            
            //오른손 3,6,9
            if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9){
                answer += "R";
                if(numbers[i] == 3){
                    right[0] = 3;
                    right[1] = 3;
                }
                else if(numbers[i] == 6){
                    right[0] = 3;
                    right[1] = 2;
                }
                else if(numbers[i] == 9){
                    right[0] = 3;
                    right[1] = 1;
                }
            }
            
      
            //만약 2580이라면 2라면 2,3  sqrt((2-1)^2 + (3-3)^2) 
            // 0이면 2,0  / 8라면 2,1 / 5라면 2,2 / 2이라면 2,3
            if(numbers[i]==0 || numbers[i]==2 || numbers[i]==5 || numbers[i]==8){
                if(numbers[i] == 0){
                  double currentLeft = Math.abs(2-left[0]) + Math.abs(0-left[1]);
                  double currentRight = Math.abs(2-right[0]) + Math.abs(0-right[1]);
                    
                    if(currentLeft < currentRight){
                        left[0] = 2;
                        left[1] = 0;
                        answer += "L";
                    }else if(currentLeft > currentRight){
                        right[0] = 2;
                        right[1] = 0;
                        
                        answer += "R";
                    }else{
                        if(hand.equals("left")){
                            left[0] = 2;
                            left[1] = 0;
                            answer += "L";
                        }else{
                            right[0] = 2;
                            right[1] = 0;
                        
                            answer += "R";
                        }
                    }
                    
                }
                else if(numbers[i] == 2){
                    double currentLeft = Math.abs(2-left[0]) + Math.abs(3-left[1]);
                    double currentRight = Math.abs(2-right[0]) + Math.abs(3-right[1]);
                    
                    
                    if(currentLeft < currentRight){
                        left[0] = 2;
                        left[1] = 3;
                        answer +="L";
                    }else if(currentLeft > currentRight){
                        right[0] = 2;
                        right[1] = 3;            
                        answer += "R";
                    }else{
                        if(hand.equals("left")){
                            left[0] = 2;
                            left[1] = 3;
                            answer += "L";
                        }else{
                            right[0] = 2;
                            right[1] = 3;
                        
                            answer += "R";
                        }
                    }                    
                    
                }
                else if(numbers[i] == 5){
                    double currentLeft = Math.abs(2-left[0]) + Math.abs(2-left[1]);
                    double currentRight = Math.abs(2-right[0]) + Math.abs(2-right[1]);
                    
                    if(currentLeft < currentRight){
                        left[0] = 2;
                        left[1] = 2;  
                        answer +="L";
                    }else if(currentLeft > currentRight){
                        right[0] = 2;
                        right[1] = 2;   
                        answer += "R";
                    }else{
                        if(hand.equals("left")){
                            left[0] = 2;
                            left[1] = 2;
                            answer += "L";
                        }else{
                            right[0] = 2;
                            right[1] = 2;
                        
                            answer += "R";
                        }
                    }                             
                }
                
                
                
                else if(numbers[i] == 8){
                  double currentLeft = Math.abs(2-left[0]) + Math.abs(1-left[1]);
                    double currentRight = Math.abs(2-right[0]) + Math.abs(1-right[1]);
                    
                    if(currentLeft < currentRight){
                        left[0] = 2;
                        left[1] = 1;
                        answer +="L";
                    }else if(currentLeft > currentRight){
                        right[0] = 2;
                        right[1] = 1;     
                        answer += "R";
                    }else{
                        if(hand.equals("left")){
                            left[0] = 2;
                            left[1] = 1;
                            answer += "L";
                        }else{
                            right[0] = 2;
                            right[1] = 1;
                        
                            answer += "R";
                        }
                    }                             
                }
                
    
                
            }
            
            
        }
        
        return answer;
    }
}