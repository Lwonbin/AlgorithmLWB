import java.io.*;
import java.util.*;

public class Main {

    static class Person {
        int age;
        String name;
        int index;

        Person(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());

        List<Person> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            Person person = new Person(age, name, i);
            list.add(person);
        }


        list.sort((o1, o2) ->{
           if(o1.age == o2.age){
               return o1.index - o2.index;
           }

           return o1.age - o2.age;
        });

        for(int i=0; i<N; i++){
            bw.write(list.get(i).age+" "+list.get(i).name);
            bw.write("\n");
        }


        bw.flush();
        bw.close();
        br.close();


    }
}
