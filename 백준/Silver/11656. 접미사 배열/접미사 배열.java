import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> array = new ArrayList<>();
        String st = scan.next();
        String roll = "";

        for (int i = 0; i < st.length(); i++) {
            for (int j = i; j < st.length(); j++) {
                roll += st.charAt(j);
            }
            array.add(roll);
            roll = "";
        }

        Collections.sort(array);

        for(int x=0; x<st.length(); x++){
            System.out.println(array.get(x));
        }

    }
}
