import java.util.logging.Level;
import java.util.logging.Logger;



public class Driver{
	
/*
 * Example user input: java Driver /Users/srollins/mymusic
 */
	public static void main(String[] args){
		if(args.length != 1){
			System.out.println("Wrong number of arguments. Please enter path of directory.");
		}
		String path = args[0];
		//http://emeraldjava.blogspot.com/2011/05/jaudiotagger-logging-levels.html
		Logger.getLogger("org.jaudiotagger").setLevel(Level.SEVERE); 
		SongList sl = SongList.buildSongList(path);
		try {
			sl.songManager();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}