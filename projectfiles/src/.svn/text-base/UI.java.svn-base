import java.io.InputStreamReader;
import java.util.Scanner;


public class UI {
	public int getChoice(){
		//Primary method that prompts for a selection from the user and 
		//returns the selection. Verify that the selection is between 1 and 5. 
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int  choice = 0;
		while(choice < 1 || choice > 5){
			System.out.println("Enter Choice: ");	
			System.out.println("[1] List all sorted by Artst Name");
			System.out.println("[2] List all sorted by Song Title");
			System.out.println("[3] Play MP3");
			System.out.println("[4] Stop MP3 Playback");
			System.out.println("[5] Exit");
			choice = sc.nextInt();
		}
		return choice;
	}
	

}
