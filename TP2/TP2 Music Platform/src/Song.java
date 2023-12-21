public class Song {
    public String songName;
    public int songLength;
    public Song ( String songName, int songLength){
        this.songLength = songLength;
        this.songName = songName;
    }
    public void playSong(){
        System.out.println("Now playing : " + songName);
    }
    public int getSongLength(){
        return(songLength);
    }
    public void displaySong(){
        System.out.println(songName);
    }
}
