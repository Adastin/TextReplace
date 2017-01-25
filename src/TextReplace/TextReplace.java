package TextReplace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TextReplace {
    List<Sentence> sentences = new ArrayList<>();
    String text;

    public TextReplace(String text){
        this.text = text;
        StringTokenizer token = new StringTokenizer(text, ".!?", true);
        while (token.hasMoreTokens()){
            String txt = token.nextToken().trim();
            if(token.hasMoreTokens()){
                String tail = token.nextToken();
                sentences.add(new Sentence(txt, tail));
            } else{
                sentences.add(new Sentence(txt));
            }
        }
    }

    public void replace(int k, String ch){
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
        int k;
        while (true){
            k = Integer.parseInt((reader.readLine()));
            if(k > 0){
                break;
            }
            System.out.print("Value of k must be greater than 0. Please, try again: ");
        }
        System.out.print("Enter character: ");
        String ch = reader.readLine();
        System.out.println("Enter text");
        String text = reader.readLine();
        reader.close();
        TextReplace textReplace = new TextReplace(text);
        textReplace.replace(k, ch);
        textReplace.print();
    }
}

