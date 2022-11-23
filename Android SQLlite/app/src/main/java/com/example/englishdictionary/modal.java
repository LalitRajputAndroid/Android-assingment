package com.example.englishdictionary;

public class modal {
    String word;
    String meaning;

    public modal() {
    }

    public modal(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

}
