package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Ccwc {

    private File file;
    Ccwc(File file) {
        this.file= file;
    }

    long countBytes() {
        return file.length(); //returns length of file in bytes
    }

    /***
     * no of characters in a file depends on encoding used. If single byte
     * encoding (like ASCII)- each character is represented by a byte.
     * No. of characters = No of bytes
     * In multi-byte encoding (like UTF-8)- each character can be represnted by
     * different no. of bytes. In UTF-8 encoded files, characters range from 1-4 bytes.
     * ASCII characters in UTF-8 files are of 1 byte but emoji's, characters from other locales
     * might be of different no of bytes
     * @return
     */
    int countChars() {
        int b= 0;
        int charCount= 0;
        try {
            BufferedReader br= new BufferedReader(new FileReader(file));
            while((b=br.read())!= -1) { //br.read() reads each character of a file
                charCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } return charCount;
    }

    int countLines() {
        int lines= 0;
        try {
            BufferedReader br= new BufferedReader(new FileReader(file));
            while(br.readLine() != null) { //br.readLine() reads text line by line
                lines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } return lines;
    }

    //This method counts words in each line.
    int countWords() {
        //We specify character encoding of file
        Charset charset= StandardCharsets.UTF_8;
        int c; //current character being read
        boolean inWord=  false; //currently in word?
        int words= 0;
        try {
            BufferedReader br= new BufferedReader(new FileReader(file, charset));
            //read each character in file
            while((c= br.read())!= -1) {
                //check if current character is a whitespace
                if(Character.isWhitespace(c)) {
                    if(inWord) inWord = false;
                        //if the current character being read is a whitespace
                        //and we were previously inside a word, set inWord to false
                        //as we are out of word now
                } else {
                    //if the current character is not a whitespace, it is part of a word
                    //if the previous character was a whitespace (inWord= false)- a new word is starting
                    //we are starting a new word; set inWord= true
                    if (!inWord) {
                        inWord = true;
                        //a new word
                        words++;
                    }
                }
            } return words;
        } catch (IOException e) {
            e.printStackTrace();
        } return -1;
    }
}
