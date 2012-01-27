package projectsauss;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * <p>A class representing a single dictionary library for 
 * translation.</p>
 * @author antoniomalvagomes
 */
public class Dictionary {
    
    private HashMap<String, ArrayList<String>> myLanguage;
    
    /**
     * <p>A constructor taking a <code>String</p> descriptor of the 
     * language to load.</p>
     * @param lang A <code>String</code> descriptor of the language
     */
    public Dictionary(String lang)
    {
        myLanguage = new HashMap<String, ArrayList<String>>();
        File dict;
        if(lang.compareTo("German")==0)
        {
            System.out.println("Specified German");
            dict = new File("../lib/German.txt");
        }
        else
        {
            dict = null;
        }
        try
        {
            Scanner readFile = new Scanner(dict);
            String currentWord = "";
            ArrayList<String> defs = null;
            while(readFile.hasNextLine())
            {
                String line = readFile.nextLine();
                StringTokenizer strtok = new StringTokenizer(line, "\t", false);
                while(strtok.hasMoreTokens())
                {
                    String word = strtok.nextToken();
                    if(currentWord.compareTo(word)!=0)
                    {
                        myLanguage.put(currentWord, defs);
                        currentWord = word;
                        defs = new ArrayList<String>();
                    }
                    defs.add(strtok.nextToken());
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.err.println("Language not found.");
        }
    }
    
    /**
     * <p>Takes a <code>String</code> English word and translates it to the
     * loaded language.</p>
     * @param eWord The word to be translated.
     * @return the translates word in <code>String</code> form.
     */
    public String wordTranslate(String eWord)
    {
        if(myLanguage.containsKey(eWord))
        {
            return myLanguage.get(eWord).get(0);
        }
        return eWord;
    }
}
