import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class Play {
	SongList songList;

	public Play(SongList sl){
		songList = sl;
	}

	public void playSong(final int songChoice, final SongList sl) throws JavaLayerException{

		//http://emeraldjava.blogspot.com/2011/05/jaudiotagger-logging-levels.html
		Logger.getLogger("org.jaudiotagger").setLevel(Level.SEVERE); 	
		Thread t = new Thread() {
			public void run(){
				Song song = songList.get(songChoice - 1);
				InputStream in = null;
				try {
					in = new FileInputStream(song.getAbsolutePath());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
					return;
				}
				Player player = null;
				try {
					player = new Player(in);
				} catch (JavaLayerException e1) {
					e1.printStackTrace();
					return;
				}
				sl.setPlayer(player);
				try{
					player.play();
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		};
		t.start();
	}
}
