package TextReplace;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sentence{
    private ArrayList<Word> words = new ArrayList<>();
    private String tail = "";
    public Sentence(String text){
        StringTokenizer tokenizer = new StringTokenizer(text, " ,", true);
        while (tokenizer.hasMoreTokens()){
            words.add(new Word(tokenizer.nextToken()));
        }
    }
    public Sentence (String text, String tail){
        this(text);
        this.tail = tail;
    }

    public void replace(int k, String ch){
        for(Word w : words){
            w.replace(k, ch);
        }
    }

    @Override
    public String toString() {
        String s = "";
        if(!words.isEmpty()){
            for(int i = 0; i < words.size(); i++){
                s += words.get(i).toString();
            }
        }
        return s + tail + " ";
    }
}
