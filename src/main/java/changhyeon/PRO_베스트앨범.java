package changhyeon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PRO_베스트앨범 {

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> sortedGenres = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        for (String genre : map.keySet()) {
            sortedGenres.add(genre);
        }

        sortedGenres.sort((g1, g2) -> map.get(g2) - map.get(g1));

        for (String genre : sortedGenres) {
            List<music> musics = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if (genre.equals(genres[i])) {
                    musics.add(new music(i, plays[i]));
                }
            }

            musics.sort(new Comparator<music>() {
                public int compare(music m1, music m2) {
                    if (m1.play == m2.play) {
                        return m1.index - m2.index;
                    }
                    return m2.play - m1.play;
                }
            });

            answer.add(musics.get(0).index);
            if (musics.size() != 1) {
                answer.add(musics.get(1).index);
            }
        }

        System.out.println(answer.toString());

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static class music {

        int index;
        int play;

        public music(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }
}
