import java.io.*;
import java.util.*;

public class Main {

    static class Person{
        int age;
        String name;

        Person(int age, String name){
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<Person, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            Person person = new Person(age, name);
            map.put(person, i);


        }


        List<Person> List = new ArrayList<>(map.keySet());

        List.sort((o1, o2) -> {
            if(o1.age == o2.age){
                return map.get(o1) - map.get(o2);
            }

            return o1.age - o2.age;
        });

        for(int i=0; i<N; i++){
            Person person = List.get(i);
            bw.write(person.age +" "+person.name);
            bw.write("\n");
        }





        br.close();
        bw.flush();
        bw.close();

    }
}
