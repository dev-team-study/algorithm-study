package tommy;

import java.util.*;

public class PRO_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String,Integer> gMap = new HashMap<>();
        Map<String, Map<Integer, Integer>> pMap = new HashMap<>();  // index, play

        for(int i = 0; i < genres.length; i++){
            gMap.put(genres[i], gMap.getOrDefault(genres[i], 0) + plays[i]);
            if(pMap.containsKey(genres[i])){
                pMap.get(genres[i]).put(i, plays[i]);
            } else{
                Map<Integer, Integer> temp = new HashMap<>();
                temp.put(i, plays[i]);
                pMap.put(genres[i], temp);
            }
        }

        List<String> keySet = new ArrayList<>(gMap.keySet());
        Collections.sort(keySet, (a, b) -> gMap.get(b) - gMap.get(a));

        for (String key : keySet){
            Map<Integer, Integer> map = pMap.get(key);
            List<Integer> genre_key = new ArrayList<>(map.keySet());

            Collections.sort(genre_key, (a, b) -> map.get(b) - map.get(a));

            answer.add(genre_key.get(0));
            if (genre_key.size() > 1){
                answer.add(genre_key.get(1));
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
