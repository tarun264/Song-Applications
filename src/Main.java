import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Album s1= new Album("KK","Zara si");
        Album s2= new Album("Sidhu Moosewala","PBX");

        s1.addSong("zara si",3.45);
        s1.addSong("Ankhon mai teri",4.32);
        s1.addSong("Dil Ibadat",4.02);

        s2.addSong("Death Route",3.14);
        s2.addSong("So High",3.32);
        s2.addSong("Level",4.12);
        s2.addSong("sidhu anthem", 4.37);

        // to check whether song is present in album
        if(s1.searchsong("Hale dill")){
            System.out.println("Playing Hale dil");
        }else{
            System.out.println("Sorry! song not found");
        }
        if(s2.searchsong("So High")){
            System.out.println("Playing so high");
        }else {
            System.out.println("Sorry! song not found");
        }

        // creating the playlist
        LinkedList<Songs> myPlayList= new LinkedList<>();
        s1.addToPlaylistfromAlbum(1,myPlayList);
        s1.addToPlaylistfromAlbum(2,myPlayList);
        s2.addToPlaylistFromAlbum("So High", myPlayList);
        s2.addToPlaylistfromAlbum(3,myPlayList);
        s2.addToPlaylistfromAlbum(4,myPlayList);

        //adding wrong song to playlist
        s1.addToPlaylistfromAlbum(6,myPlayList);
        s2.addToPlaylistFromAlbum("kuch is tarah",myPlayList);


        playSong(myPlayList);

    }
    public static void playSong(LinkedList<Songs>PlayList) {
        // to play song we need itereator to iterate in linkedlist
        ListIterator<Songs> itr = PlayList.listIterator();

        //if itr does not have next song
        if (!itr.hasNext()) {
            System.out.println("Your PlayList is Empty");
            return;
        }
        System.out.println("Now Playing: ");
        System.out.println(itr.next());

        // calling menu function to get playing commands
        printMenu();

        Scanner sc = new Scanner(System.in);

        // wasNext will help us to keep the track whether we are coming from next or prev
        // we will keep wasNext true while going forward & false while going prev
        boolean wasNext = true;

        while (true) {
            System.out.println("Please enter your option ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    //if i am going to prev song after moving to next my wasNext should be false
                    if (!wasNext) {
                        itr.next();
                        wasNext = true;
                    }
                    if (itr.hasNext()) {
                        System.out.println("Now Playing: ");
                        System.out.println(itr.next());
                        wasNext = true;
                    } else {
                        System.out.println("You have reached to the end of the playlist");
                    }
                    break;
                case 2:
                    if (wasNext) {
                        itr.previous();
                        wasNext = false;
                    }
                    if (itr.hasPrevious()) {
                        System.out.println("Now Playing: ");
                        System.out.println(itr.previous());
                        wasNext = false;
                    } else {
                        System.out.println("You have reached to the starting of the playlist");
                    }
                    break;
                case 3: // to repeat a song
                    if (wasNext) {
                        if (itr.hasPrevious()) {
                            System.out.println("Now Playing: ");
                            System.out.println(itr.previous());
                            wasNext = false;
                        }
                    } else {
                        if (itr.hasNext()) {
                            System.out.println("Now Playing: ");
                            itr.next();
                            wasNext = true;
                        }
                    }
                    break;
                case 4:
                    printAllSong(PlayList);
                    break;
                case 5:
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:
                    exit(0);
            }
        }
    }
        public static void printAllSong(LinkedList<Songs>PlayList){
        for(Songs s: PlayList){
            System.out.println(s);
        }
        return;
    }
    public static void printMenu(){
        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Repeat the current song");
        System.out.println("4. Show all songs in playlist");
        System.out.println("5. delete the current song");
        System.out.println("6. Show the menu again");
        System.out.println("7. Exit");
    }

}