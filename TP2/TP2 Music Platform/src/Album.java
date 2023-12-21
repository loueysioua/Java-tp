import java.util.ArrayList;

public class Album {
    public ArrayList<Song> songs;
    public String albumName;
    public Album ( String albumName){
        songs = new ArrayList<Song>();
        this.albumName = albumName;
    }
    public void addSong(Song s){
        songs.add(s);
    }
    public void removeSong(Song s){
        if( ( songs.contains(s) ) )
            System.out.println("This song doesn't exist in the Album !");
        else
            songs.remove(s);
    }
    public void displayAlbum(){
        System.out.println("The Album" + albumName + " contains : ");
        for(Song s : songs){
            s.displaySong();
            System.out.println("******");
        }
    }

}
