import java.util.ArrayList;

public class FreeUser implements User{
    ArrayList<Playlist> userPlaylists ;
    static int nbPlaylists=0;
    public FreeUser(Playlist p){
        userPlaylists = new ArrayList<>();
        if(nbPlaylists<3) {
            nbPlaylists++;
            userPlaylists.add(p);
        }
        else {
            System.out.println("You have reached the maximum number of playlists !");
        }
    }

    public void displayAd(){
        System.out.println("Update your account to premium for ad-free experience !!");
    }
    @Override
    public void listen(Playlist playlist){
        System.out.println("Your are now listening to : " + playlist.playlistName);
    }
    @Override
    public void addToPlaylist(Song s,Playlist playlist){
        playlist.addSong(s);
        System.out.println("Your song was added successfully to your playlist " + playlist.playlistName);
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
        if(nbPlaylists<3) {
            nbPlaylists++;
            userPlaylists.add(p);
        }
        else {
            System.out.println("You have reached the maximum number of playlists !");
        }
    }
}
