package org.example;

import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Main {

    private static void commandLineOption(String ip, File file) throws IOException {
       Ccwc ccwc= new Ccwc(file);
        String fileName= file.getName();
        switch (ip) {
            case "-c":
               long x= ccwc.countBytes();
                System.out.println(x + " " + fileName);
                break;
            case "-l":
                int l= ccwc.countLines();
                System.out.println(l + " " + fileName);
                break;
            case "-w":
               // int w= countWordsInLine(file);
                int w= ccwc.countWords();
                System.out.println(w + " " + fileName);
                break;
            case "-m":
                int m= ccwc.countChars();
                System.out.println(m + " " + fileName);
                break;
            case " ":
                System.out.println(ccwc.countLines() + " " + ccwc.countWords() + " " + ccwc.countBytes() + " " + fileName);
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner= new Scanner(System.in);
        String userInput= scanner.nextLine();
        String[] userInputArr= userInput.split(" ");
        if(userInputArr.length == 3) {
            String fileName = userInputArr[2];
            String cmd = userInputArr[1];
            File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\"+fileName);
            commandLineOption(cmd, file);
        } else if (userInputArr.length == 2) {
            String fileName= userInputArr[1];
            String cmd= " ";
            File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\"+fileName);
            commandLineOption(cmd, file);
        }

    }

}