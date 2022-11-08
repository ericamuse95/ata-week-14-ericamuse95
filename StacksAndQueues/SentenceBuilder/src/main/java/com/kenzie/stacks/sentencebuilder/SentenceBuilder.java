package com.kenzie.stacks.sentencebuilder;

import java.util.Stack;

public class SentenceBuilder {

    private Stack<String> sentenceBuilder;

    /**
     * Constructor.
     */
    public SentenceBuilder() {
            sentenceBuilder = new Stack<>();
    }

    /**
     * Adds a word to the sentence.
     * @param word to be added to the sentence.
     */
    public void addWord(String word) {
            sentenceBuilder.push(word);
    }

    /**
     * Undoes the last word added, and returns it.
     * @return The word most recently added to the sentence, if any; null, otherwise.
     */
    public String undo() {
        if (sentenceBuilder.empty()) {
            return null;
        } else {
            return sentenceBuilder.pop();
        }
    }

    /**
     * Display all the current words in our sentence.
     * @return string representation of the words currently in the sentence.
     */
    public String getSentenceWords() {
        return sentenceBuilder.toString();
    }
}
