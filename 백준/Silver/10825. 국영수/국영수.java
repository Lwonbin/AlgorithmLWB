import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();


        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int korea = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            Person person = new Person(korea, english, math, name);
            list.add(person);
        }




        list.sort((o1, o2) ->{
           int cmp = o2.korea - o1.korea;
           if(cmp == 0){
               int cmp2 = o1.english - o2.english;
               if(cmp2 == 0){
                   int cmp3 = o2.math - o1.math;
                   if(cmp3 ==0){
                       return o1.name.compareTo(o2.name);
                   }
                   return cmp3;
               }
               return cmp2;
           }
           return cmp;
        });

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).name);
        }

    }


    static class Person{
        int korea;
        int english;
        int math;

        String name;

        Person(int korea, int english, int math, String name){
            this.korea = korea;
            this.english = english;
            this. math = math;
            this. name = name;
        }
    }
}
