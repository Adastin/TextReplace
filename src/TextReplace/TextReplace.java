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

    public TextReplace(String text, int k, String ch){
        this.text = text;
        this.k = k;
        this.ch = ch;
        StringTokenizer tokenizer = new StringTokenizer(text, ".!?", true);
        while (tokenizer.hasMoreTokens()){
            String txt = tokenizer.nextToken().trim();
            if(tokenizer.hasMoreTokens()){
                String tail = tokenizer.nextToken();
                sentences.add(new Sentence(txt, tail));
            } else{
                sentences.add(new Sentence(txt));
            }
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter value of k: ");
        int k = Integer.parseInt((reader.readLine()));
        System.out.print("Enter the character: ");
        String ch = reader.readLine();
        System.out.println("Enter text");
        String text = reader.readLine();
        TextReplace textReplace = new TextReplace(text, k, ch);
        textReplace.replace();
        textReplace.print();
    }
}

