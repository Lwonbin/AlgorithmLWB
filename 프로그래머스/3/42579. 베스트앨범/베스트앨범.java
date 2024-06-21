import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // Map to store total plays of each genre
        HashMap<String, Integer> genrePlayCount = new HashMap<>();
        
        // Map to store list of songs (as Movie objects) for each genre
        HashMap<String, List<Movie>> genreSongs = new HashMap<>();

        // Populate maps
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            genreSongs.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Movie(i, plays[i]));
        }
        
        // Sort genres by total plays in descending order
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((o1, o2) -> genrePlayCount.get(o2) - genrePlayCount.get(o1));
        
        // Prepare answer list
        List<Integer> answerList = new ArrayList<>();
        
        // Iterate through sorted genres and add top 2 songs from each genre to answer
        for (String genre : sortedGenres) {
            List<Movie> movies = genreSongs.get(genre);
            movies.sort((o1, o2) -> {
                if (o1.plays == o2.plays) {
                    return o1.index - o2.index;
                }
                return o2.plays - o1.plays;
            });
            
            // Add top song
            answerList.add(movies.get(0).index);
            // Add second top song if it exists
            if (movies.size() > 1) {
                answerList.add(movies.get(1).index);
            }
        }
        
        // Convert answer list to array
        return answerList.stream().mapToInt(i -> i).toArray();
    }
    
    // Movie class to store index and plays of a song
    static class Movie {
        int index;
        int plays;
        
        Movie(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }
    }
}
