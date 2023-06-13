import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String Artist;
    private String Name;
    private List<Songs> song;

    public Album() {
    }

    public Album(String artist, String name) {
        Artist = artist;
        Name = name;
        this.song = new ArrayList<>();
    }

    public String getArtist() {
        return Artist;
    }

    public List<Songs> getSong() {
        return song;
    }

    public void setSong(List<Songs> song) {
        this.song = song;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public boolean searchsong(String title){
        for(Songs s:song){
            if(s.getTitle().equals(title)) return true;
        }
        return false;
    }
    public boolean addSong(String title, double duration) {
        if(!searchsong(title)){
            Songs s= new Songs(title,duration);
            this.song.add(s);

            System.out.println("Song added successfully!");
            return true;
        }
        System.out.println("Song already added");
        return false;
    }
    // Method Overloading -> Compile time Polymorphsim
    public boolean addToPlaylistFromAlbum(String title, LinkedList<Songs> myPlayList){

        if(searchsong(title)){
            for(Songs s: this.song){
                if(s.getTitle().equals(title)){
                    myPlayList.add(s);
                    System.out.println("Congrats!! Song has been added to your playlist");
                    return true;
                }
            }
        }
        System.out.println("Sorry! The song is not present in the album");
        return false;
    }

    //  other way to add song to playlist
    public boolean addToPlaylistfromAlbum(int index, LinkedList<Songs>myPlayList){
        // if the song is present in album,
            index=index-1;

            if(index>=0 && index<this.song.size()){
                myPlayList.add(this.song.get(index));
                System.out.println("Song has been added succesfully to playlist");
                return true;
            }

        System.out.println("Sorry!, Invalid Song Number" );
        return false;
    }
}
