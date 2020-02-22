import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

//LINKEDLIST CLASS
public class EnglishAndFrenchArrays {
    private LinkedList<String> English;
    private LinkedList<String> French;
    private Random randnum = new Random();
    private String wordToTranslate;
    private int language;
    private int word;
    private String answer;
    
    //CONSTRUCTOR FOR ENGLISHANDFRENCHARRAYS CLASS
    public EnglishAndFrenchArrays(){
        this.French = new LinkedList<>();
        this.English = new LinkedList<>();
    }
    //METHOD FOR OBTAINING INPUT TO English LINKEDLIST
    public LinkedList<String> getEnglish() {
        BufferedReader reader;
            try {
                int i =0;
                reader = new BufferedReader(new FileReader(   //gets info from file
                "/Users/Gibson/Documents/NetBeansProjects/LanguageStudyGUI/test/English.txt"));
		String englishLine = reader.readLine().trim(); //gets line from file
                while (englishLine != null) {//loops through file to create linkedList
                    English.add(i,englishLine);//adds numbered line to english linkedList
                    englishLine = reader.readLine(); //gets next line
                    i++; //increase number for next line
		}
                reader.close();
		} catch (IOException e) {
			System.out.print(e);
		}
        return English;
    }
    //METHOD FOR SETTING ENGLISH LINKEDLIST
    public void setEnglish(LinkedList<String> English) {
        this.English = English;
    }
    //METHOD FOR OBTAINING INPUT TO FRENCH LINKEDLIST
    public LinkedList<String> getFrench() {
        BufferedReader reader;
            try {
                int i = 0;
                reader = new BufferedReader(new FileReader(   //gets info from file
                "/Users/Gibson/Documents/NetBeansProjects/LanguageStudyGUI/test/French.txt"));
                String frenchLine = reader.readLine().trim();  //gets line from file
                while (frenchLine != null) { //loops through file to create linkedList
                    French.add(i,frenchLine);  //adds numbered line to french linkedList
                    frenchLine = reader.readLine();//gets next line
                    i++;  //increase number for next line
                    }
		} catch (IOException e) {
			System.out.print(e);
            }
        return French;
    }
    //METHOD FOR SETTING FRENCH LINKEDLIST
    public void setFrench(LinkedList<String> French) {
        this.French = French;
    }
    //METHOD FOR OBTAINING A RANDOM
    public int randnum(int i) {
         return randnum.nextInt(i);
    }   
    //METHOD FOR OBTAINING A RANDOM LANGUAGE TYPE
    public int getLanguage(){
        language = randnum(2);//word is either in french or english
        return language;
    }
    //METHOD FOR OBTAINING A RANDOM WORD
    public int getWord(){
        word = randnum(20);
        return word;
    }
    //GETS THE WORD TO BE TRANSLATED USING RANDOM WORD AND LANGUAGE
    public String getWordToTranslate(int language, int word){
                if(language == 0)//language is english
                    {
                    wordToTranslate = getEnglish().get(word);
                    }
                else//language is french
                    {
                    wordToTranslate = getFrench().get(word);
                    }
                return wordToTranslate;
    }
    //GETS THE ANSWER TO THE TRANSLATED WORD
    public String getAnswer(int language, int word){
                if(language == 0)
                    {
                    answer = getFrench().get(word);//set answer to french word
                    }
                else
                    {
                    answer = getEnglish().get(word);//set answer to english word
                    }
                return answer;
    }
}
