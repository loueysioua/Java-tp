import java.lang.reflect.Array;
import java.util.ArrayList;

public class PremiumUser implements User{
    ArrayList<Playlist> userPlaylists ;
    public PremiumUser(Playlist p){
        userPlaylists = new ArrayList<>();
        userPlaylists.add(p);
    }
    @Override
    public void listen(Playlist playlist){
        System.out.println("Your are now listening to : " + playlist.playlistName);
    }
    public void addToPlaylist(Song s, Playlist playlist){
        playlist.addSong(s);
        System.out.println("Your song was added successfully to your playlist " + playlist.playlistName);
    }

    public void displayAd(){
        System.out.println("You are a premium user, you can enjoy an ad-free experience !!");
    }

    public void displayPlaylists(){
        System.out.println("Your playlists are : ");
        for(Playlist p : userPlaylists){
            System.out.println("- " + p.playlistName + " : " + p.playlistLength + " songs");
        }
        if(userPlaylists.isEmpty())
            System.out.println("You don't have any playlists yet !");
    }

    public void displayPlaylistSongs(Playlist p){
        System.out.println("The songs in your playlist " + p.playlistName + " are : ");
        for(Song s : p.playlist){
            s.displaySong();
            System.out.println("******");
        }
    }

    public void addPlaylist(Playlist p){
        userPlaylists.add(p);
    }

}
