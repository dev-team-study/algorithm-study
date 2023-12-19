package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_2309 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final List<String> person = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int personCount = 9;
        List<Integer> result = new ArrayList<>();


        for(int i = 0; i < personCount; i++){
            person.add(bufferedReader.readLine());
        }

        for(int i = 0; i < personCount - 1; i++){
            for(int j = 1; j < personCount; j++){
                String a = person.get(i);
                String b = person.get(j);

                List<String> sevenPerson = getSevenPerson(a, b);

                int sum = sevenPerson.stream()
                        .mapToInt(Integer::parseInt)
                        .sum();

                if(sum == 100){
                    result = sevenPerson.stream()
                            .map(Integer::parseInt)
                            .sorted()
                            .collect(Collectors.toList());
                }
            }
        }

        for(int person: result){
            System.out.println(person);
        }
    }

    private static List<String> getSevenPerson(final String a, final String b) {
        ArrayList<String> sevenPerson = new ArrayList<>(person);
        sevenPerson.remove(a);
        sevenPerson.remove(b);

        return sevenPerson;
    }
}
