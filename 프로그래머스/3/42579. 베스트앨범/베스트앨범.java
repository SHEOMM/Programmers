import java.util.*;

class Solution {
    
    private Map<String, List<Song>> songs = new HashMap<>();
    private Map<String, Integer> counter = new HashMap<>();
    
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answerList = new LinkedList<>();
        
        for(int i = 0; i<genres.length; i++){
            Song song = new Song(i, genres[i], plays[i]);
            if(songs.containsKey(genres[i])){
                songs.get(genres[i]).add(song);
                counter.put(genres[i], counter.get(genres[i]) + plays[i]);
            }else{
                List<Song> list = new LinkedList<>();
                list.add(song);
                songs.put(genres[i], list);
                counter.put(genres[i], plays[i]);
            }
        }
        
        List<SongCounter> counterList = new LinkedList<>();
        
        for(String key: counter.keySet()){
               counterList.add(new SongCounter(key, counter.get(key)));
        }
        
        Collections.sort(counterList);
        
        for(SongCounter sc: counterList){
            String genre = sc.getGenre();
            Collections.sort(songs.get(genre));
            int counter = 0;
            for(Song song: songs.get(genre)){
                if(counter == 2){
                    break;
                }
                answerList.add(song.index);
                counter++;
            }
        }
        

        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}

class SongCounter implements Comparable<SongCounter>{
    String genre;
    int plays;
    
    public String getGenre(){
        return genre;
    }
    
    public int getPlays(){
        return plays;
    }
    
    public SongCounter(String genre, int plays){
        this.genre = genre;
        this.plays = plays;
    }
    
    @Override
    public String toString(){
        return "" + this.genre + " " + this.plays;
    }
    
    @Override
    public int compareTo(SongCounter sc){
        return sc.plays - this.plays;
    }
}


class Song implements Comparable<Song> {
    int index;
    String genre;
    int plays;
    
    public Song(int index, String genre, int plays){
        this.index = index;
        this.genre = genre;
        this.plays = plays;
    }
    
    @Override
    public String toString(){
        return "index: " + index + ", genre: " + genre + ", plays:" + plays; 
    }
    
    @Override
    public int compareTo(Song s){
        if(s.plays > this.plays){
            return 1;
        }else if(s.plays < this.plays){
            return -1;
        }else{
            return this.index - s.index;
        }
    }
}