//Jonathan Conte, adams, pd3
//This code is made to filter through a text file in multiple different ways with some ways being based on user input





import java.io.File;//used to import file
import java.util.ArrayList;//import array list
import java.util.List;//import list
import java.util.Scanner;//import scanners
public class WordSorter 
{
	public static void main(String[] args) 
	{
		ArrayList<String>[] letterLists = new ArrayList[26];
		for (int i = 0; i < letterLists.length; i++) {
			letterLists[i] = new ArrayList<String>();
		}
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
				
			}
		}
		ArrayList<String> uWords = new ArrayList<String>();

		for(int i = 0; i < lWords.size(); i++) {
           uWords.add(lWords.get(i));
    	}


		for(int i = 0; i < uWords.size(); i++){
           for(int x = uWords.size() - 1; x>i ; x-- ) {
              
               if(uWords.get(i).equals(uWords.get(x))) {
                   uWords.remove(x);
                  
                  
               }
           }
       	}
	   	for (String wordy : uWords) {
			if (wordy.length() > 0) {
				char first = wordy.charAt(0);
    			if (first >= 'a' && first <= 'z') {
        			int index = first - 'a';
					if (!letterLists[index].contains(wordy)) {
        				letterLists[index].add(wordy);
					}
    			}
			}
		}


	   boolean part2 = true;
	   while(part2){

			System.out.println("type the corresponding number to call a specific action");
			System.out.println("1. Print out all words starting with a specific letter");
			System.out.println("2. Print out all words");
			System.out.println("3. Print out the total number of unique words");
			System.out.println("4. Search and determine if a word is in the article");
			System.out.println("5. Remove a word from the data structure");
			System.out.println("6. Exit");
			int input = keyB.nextInt();
			keyB.nextLine();

			if(input == 1){
				System.out.println("Enter your specific letter:");
				String inputLetter = keyB.nextLine().toLowerCase();
				char letter = inputLetter.charAt(0);
				boolean found = false;

				for (String wordy : uWords) {
        			if (wordy.length() > 0 && wordy.charAt(0) == letter) {
            			System.out.println(wordy);
						found = true;
					}
				}
				if(!found){
					System.out.println("No words start with this letter");
				}
			}

			else if(input == 2){
				boolean empty = true;
				for(int i = 0; i < letterLists.length; i++) {
                   if(letterLists[i].size() > 0){
					   empty = false;
				   }
                   System.out.println((char)('a' + i) +" words"+ ": " + letterLists[i]);
               }
			   if(empty){
				   System.out.println("Empty List");
			   }

				
			}
			else if(input == 3){
				if(uWords.isEmpty()){
					System.out.println("Empty List");
				}
				else{
					System.out.println("There are " + uWords.size() + " unique words in the article");
				}
			}
			else if(input == 4) {
               	System.out.println("Type the word you want to search for: ");
               	String Word = keyB.nextLine().toLowerCase();
               	if(uWords.contains(Word)) 
				{
                   	System.out.println("Word found in the article");
               	} 
				else 
				{
                   	System.out.println("Word NOT found in the article");
               	}
           	}
			else if(input == 5) {
               	System.out.println("What word do you want to remove? ");
              	String removeWord = keyB.nextLine().toLowerCase();
               	if(uWords.contains(removeWord)) {
                   	uWords.remove(removeWord);
                   	int index = removeWord.charAt(0) - 'a';
                   	letterLists[index].remove(removeWord);
                   	System.out.println("Word successfully removed from the list");
               	} 	
				else {
                   	System.out.println("Word NOT found in the article");
				}
			}
			else if(input == 6) {
               	part2 = false;
               		System.out.println("Exiting program");
           	}
           	else {
               	System.out.println("Invalid choice - try again...");
           	}

	   	}
	   		
	   
		
		

	}//end
}//main
