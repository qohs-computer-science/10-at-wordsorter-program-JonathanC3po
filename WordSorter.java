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
		for(int i = 0;i<lWords.size()-1;i++){
			for(int j = 0;j<lWords.size()-i-1;j++){
				char x = (lWords.get(j)).charAt(0);
				char y = (lWords.get(j+1)).charAt(0);
				
				String word1 = lWords.get(j);
				String word2 = lWords.get(j+1);
				if(x > y){
					String z = lWords.get(j);
					lWords.set(j, lWords.get(j+1));
        			lWords.set(j+1, z);
				}
				if(word1.equals(word2)){
					lWords.remove(word2);
					
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