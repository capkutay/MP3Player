import java.io.File;


import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

/*
 * Song class will contain the information needed for each song. It will get the absolute path
 * for the song and use JAudioTagger to extract metadata for each mp3.
 */

public class Song  {
	
	AudioFile audioFile;
	Tag tag;
	AudioHeader audioHeader;
	String artist;
	String title;

	
	Song(File file) throws Exception{
		audioFile = AudioFileIO.read(file);
		tag = audioFile.getTag();
		audioHeader = audioFile.getAudioHeader();
		artist = tag.getFirst(FieldKey.ARTIST);
		title = tag.getFirst(FieldKey.TITLE);
	}
	
	public String getArtist(){
		return artist;
	}
	
	
	public String getTitle(){
		return title;
	}
	
	public String getAbsolutePath(){
		File file = audioFile.getFile();
		String absolutePath = file.getAbsolutePath();
		return absolutePath;
	}
	
	public String toString(){
		String s = "Artist:" + " " + getArtist() + " " + "Song:"+ " " + getTitle();
		return s;
	}
}
