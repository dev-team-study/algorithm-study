package tommy;

import java.util.List;
import java.util.ArrayList;

public class PRO_모음사전 {
    static String[] words = new String[]{"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();

    public int solution(String word) {
        recursion(0, "");

        for(int i = 0; i < list.size(); i++){
            if (list.get(i).equals(word)){
                return i;
            }
        }

        return 0;
    }

    void recursion(int depth, String word){
        list.add(word);
        if(depth == 5){
            return;
        }

        for(int i = 0; i < 5; i++){
            recursion(depth + 1, word + words[i]);
        }
    }
}
