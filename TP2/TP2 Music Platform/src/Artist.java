import java.util.ArrayList;

public class Artist {
    public ArrayList<Album> artistAlbums;
    public String artistName;
    public Artist ( String artistName){
        artistAlbums = null;
        this.artistName = artistName;
    }
    public void addAlbum(Album a){
        artistAlbums.add(a);
    }
    public void removeAlbum(Album a){
        if( ( artistAlbums.contains(a) ) )
            System.out.println("This Album doesn't exist in the artist Albums !");
        else
            artistAlbums.remove(a);
    }
    public void displayAlbum(){
        System.out.println("The artist" + artistName +"has : ");
        for(Album a : artistAlbums){
            a.displayAlbum();
            System.out.println("******");
        }
    }
}
