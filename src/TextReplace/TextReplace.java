package TextReplace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TextReplace {
    ArrayList<Sentence> sentences = new ArrayList<>();
    int k;
    String text;
    String ch;

    public TextReplace() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter value of k: ");
        k = Integer.parseInt((reader.readLine()));
        System.out.print("Enter the character: ");
        ch = reader.readLine();
        System.out.println("Enter text");
        text = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(text, ".");
        while (tokenizer.hasMoreTokens()){
            sentences.add(new Sentence(tokenizer.nextToken().trim()));
        }
    }

    public void replace(){
        for (Sentence s : sentences){
            s.replace(k, ch);
        }
    }

    public void print(){
        for(Sentence s : sentences){
            System.out.print(s.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        TextReplace textReplace = new TextReplace();
        textReplace.replace();
        textReplace.print();

    }

}

class Sentence{
    private String text;
    private ArrayList<Word> words = new ArrayList<>();
    public Sentence(String text){
        this.text = text;
        StringTokenizer tokenizer = new StringTokenizer(text, " ");
        while (tokenizer.hasMoreTokens()){
            words.add(new Word(tokenizer.nextToken().trim()));
        }
    }

    public void replace(int k, String ch){
        for(Word w : words){
            w.replace(k, ch);
        }
    }

    @Override
    public String toString() {
        String s = words.get(0).getWord();
        for(int i = 1; i < words.size(); i++){
            s += " " + words.get(i).getWord();
        }
        return s + ". ";
    }
}

class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public void replace(int k, String ch){
        if(k <= word.length()){
            word = word.substring(0, k - 1) + ch + word.substring(k);
        }
    }

    public String getWord() {
        return word;
    }
}
