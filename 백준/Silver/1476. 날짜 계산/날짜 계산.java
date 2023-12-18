import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int E = scan.nextInt();
        int S = scan.nextInt();
        int M = scan.nextInt();

        int e = 0;
        int s = 0;
        int m = 0;
        int year =0;
        while(true){
            year++;
            e++;
            s++;
            m++;
            if(e==16) e=1;
            if(s==29) s=1;
            if(m==20) m=1;
            if(e==E && s==S && m==M) break;
        }
        System.out.println(year);


    }
}
