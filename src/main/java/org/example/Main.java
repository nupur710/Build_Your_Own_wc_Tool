package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    private static void commandLineOption(String ip, File file) {
        String fileName= file.getName();
        switch (ip) {
            case "-c":
               long x= countBytes(file);
                System.out.println(x + " " + fileName);
                break;
            case "-l":
                int l= countLines(file);
                System.out.println(l + " " + fileName);
                break;
            case "-w":
                int w= countWords(file);
                System.out.println(w + " " + fileName);
                break;
            case "-m":
                int m= countChars(file);
                System.out.println(m + " " + fileName);

        }
    }

    private static int countWords(File file) {
        int words= 0;
        try {
            BufferedReader br= new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null) {
                words+= countWordsInLine(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        } return words;
    }

    private static int countWordsInLine(String line) {
        if(line == null || line.isEmpty()) {
            return 0;
        } int wordCount= 0;
        return 0;
    }

    private static int countLines(File file) {
        int count= 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String lines;
            while ((lines = br.readLine()) != null)
                count++;
        } catch (IOException e) {

        } return count;
    }

    private static int countChars(File file) {
        int b= 0;
        int length= 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((b = br.read()) != -1) {
                length++;
            }
        }catch (IOException e) {

        }
        return length;
    }
    private static long countBytes(File fis) {
        return fis.length();
    }
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String userInput= scanner.nextLine();
        String[] userInputArr= userInput.split(" ");
        String fileName= userInputArr[2];
        String cmd= userInputArr[1];
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\"+fileName);
        commandLineOption(cmd, file);
    }

}