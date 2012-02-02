import java.io.File;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

@SuppressWarnings("serial")
public class SongList extends LinkedList<Song> {
	
	Player player = null;
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player newPlayer){
		player = newPlayer;
	}
	
	public void print(){
		for(int i = 0; i < size(); i++){
			Song s = (Song)get(i);
			System.out.println("[" + (i+1) + "]" + s);
		}
	}

	public void sortByArtist(){
		Collections.sort(this, new Comparator<Song>() {
			public int compare(Song s1, Song s2) {
				return s1.getArtist().compareTo(s2.getArtist());
			}
		});

	}

	public void sortByTitle(){
		Collections.sort(this, new Comparator<Song>() {
			public int compare(Song s1, Song s2) {
				return s1.getTitle().compareTo(s2.getTitle());
			}
		});
	}

	public void songManager() {
		UI ui = new UI();
		int choice = ui.getChoice();
		Play p = new Play(this);

		while(choice != 5){
			switch(choice){
			case 1:
				sortByArtist();
				print();
				break;
			case 2:
				sortByTitle();
				print();
				break;
			case 3:
				Scanner sc = new Scanner(new InputStreamReader(System.in));
				int songChoice = 0;
				while(songChoice < 1 || songChoice > size()){
					System.out.println("Enter Song Choice: ");
					sortByArtist();
					print();
					songChoice = sc.nextInt();
				}
				try {
					p.playSong(songChoice, this);
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				if (player != null){
					player.close();					
				}
				break;
			default: break;
			}
			choice = ui.getChoice();
			if (choice == 5)
				break;
		}
	}

	public static SongList buildSongList(String path) {
		File f = new File(path);
		if(!f.exists()){
			System.out.println("Directory does not exist.");
			return null;
		}
		SongList sl = new SongList();
		buildList(f, sl);
		return sl;			

	}

	private static void buildList(File f, SongList sl) {
		if (f.isFile()) {
			if (f.getAbsolutePath().endsWith(".mp3")){
				try {
					sl.add(new Song(f));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else
				return;
		} 
		else {
			File[] files = f.listFiles();
			for (int i = 0; i < files.length; ++i) {
				buildList(files[i], sl);
			}
		}
	}
}
