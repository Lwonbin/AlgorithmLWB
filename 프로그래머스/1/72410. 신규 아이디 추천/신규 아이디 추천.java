class Solution {
    public String solution(String new_id) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        
        //1단계
        new_id = new_id.toLowerCase();
        
        //2단계
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (Character.isLetterOrDigit(ch) || ch == '-' || ch == '_' || ch == '.') {
                sb.append(ch);
            }
        }
        new_id = sb.toString();
        
        
        //3단계
        new_id = new_id.replaceAll("\\.{2,}", ".");
        
        
        
        //4단계
        if(!new_id.isEmpty() && new_id.charAt(0) == '.'){
            new_id = new_id.substring(1);
        }
        
        if(!new_id.isEmpty() && new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0,new_id.length()-1);
        }
        
        
        //5단계
        if(new_id.isEmpty()){
            new_id = "a";
        }
        
        //6단계
        
        if(new_id.length() > 15){
            new_id = new_id.substring(0,15);
        }
               if(!new_id.isEmpty() && new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0,new_id.length()-1);
        }
        
        
        //7단계
        StringBuilder sb2 = new StringBuilder();
        if(new_id.length()<=2){
            sb2.append(new_id);
            char ch2 = new_id.charAt(new_id.length()-1);
            while(sb2.length()<3){
                sb2.append(ch2);
            }
            new_id = sb2.toString();
        }
        
        
        
        return new_id;
    }
}