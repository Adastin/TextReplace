package TextReplace;

public class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public void replace(int k, String ch){
        if(k <= word.length()){
            if(Character.isLetter(word.charAt(k-1))){
                word = word.substring(0, k - 1) + ch + word.substring(k);
            }
        }
    }

    @Override
    public String toString() {
        return word;
    }
}
