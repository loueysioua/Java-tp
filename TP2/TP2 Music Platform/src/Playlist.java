import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
    public String playlistName;
    public ArrayList<Song> playlist;
    public int playlistLength=0;

    public Playlist(String name){
        playlist = new ArrayList<Song>();
        playlistName=name;
    }

    public Playlist(Album a , String name){
        playlist = new ArrayList<Song>();
        for(Song s : a.songs){
            playlist.add(s);
            playlistLength++;
        }
        playlistName=name;
    }
    public void addSong(Song s){
        playlistLength++;
        playlist.add(s);
    }
    public void removeSong(Song s){
        if( ( playlist.contains(s) ) )
            System.out.println("This song doesn't exist in the Album !");
        else
            playlist.remove(s);
    }
     public void shufflePlaylist(){
        Collections.shuffle(playlist);
     }
}
