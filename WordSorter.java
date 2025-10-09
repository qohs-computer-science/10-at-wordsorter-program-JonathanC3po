import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class WordSorter 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in); 
		Scanner keyB = new Scanner(System.in); 
		try
		{
			in = new Scanner(new File("article.txt"));	
		}
		catch(Exception e)
		{
			System.out.println("Cannot find file... Exiting Program");
			return;
		}	
		ArrayList<String> words = new ArrayList<String>();
		String word = "";
		while(in.hasNext())
		{
			word = in.next();

			word = word.replace(",", "");
			word = word.replace("(tm)", "");
			word = word.replace(")", "");
			word = word.replace("(", "");
			word = word.replace(".", "");
			word = word.replace("'s", "");
			word = word.replace(":", "");
			word = word.replace("!", "");
			word = word.replace("?", "");
			word = word.replace("'", "");
			System.out.println(word);
			
			words.add(word);
			
		}
		List<String> lWords = new ArrayList<>();
        for (String wordy : words) {
            lWords.add(wordy.toLowerCase());
        }
		for(int i = 0;i<lWords.size();i++){
			for(int i = 0;i<lWords.size()-1;i++){
				String x = (lWords.get(i)).chartAt(0)
				String y = (lWords.get(i+1)).chartAt(0)
				
				if(x < y){
					lWords.set(
					)
				}
			}
		}
		System.out.println("type 1 if you want to show the list");
		int val = keyB.nextInt();
		if (val == 1){
			System.out.println(lWords);
		}
		
		

	}
}