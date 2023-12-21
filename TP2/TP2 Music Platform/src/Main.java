
public class Main {
    public static void main(String[] args) {
        Song s1 = new Song("Song1", 3);
        Song s2 = new Song("Song2", 4);
        Song s3 = new Song("Song3", 5);
        Song s4 = new Song("Song4", 6);
        Album a1 = new Album("Album1");
        a1.addSong(s1);
        a1.addSong(s2);
        Playlist playlist1 = new Playlist("Playlist1");
        playlist1.addSong(s1);
        playlist1.addSong(s2);
        playlist1.addSong(s3);
        Playlist playlist2 = new Playlist(a1, "Playlist2");
        playlist2.addSong(s4);
        PremiumUser u1 = new PremiumUser(playlist1);
        u1.addPlaylist(playlist2);
        u1.listen(playlist1);
        u1.addToPlaylist(s4, playlist1);
        u1.displayPlaylists();
        u1.displayPlaylistSongs(playlist1);
        FreeUser u2 = new FreeUser(playlist2);
        u2.listen(playlist2);
        u2.addToPlaylist(s3, playlist2);
        u2.displayPlaylists();
        u2.displayPlaylistSongs(playlist2);

    }
}