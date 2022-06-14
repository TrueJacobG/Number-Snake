package game;

import java.io.IOException;

public class Game {
    public Game(){
        run();
    }

    private void run() {
        clearConsole();

        int maxLengthOfSnake = 4;
        int maxLengthOfRow = 10;

        int n = 0;
        String symbols = "";
        String spaces = "";
        String newLines = "";
        int whereToBreak = 0;

        while(true){
            if(symbols.length() >= maxLengthOfSnake){
                spaces += " ";
            }

            symbols += String.valueOf(n);

            if(spaces.length() + symbols.length() >= maxLengthOfRow){
                symbols = symbols.replace("\n", "");
                symbols = symbols.substring(1);
                symbols = symbols.substring(0, symbols.length()-whereToBreak) + "\n" + symbols.substring(symbols.length()-whereToBreak);

                if(symbols.startsWith("\n")){
                    spaces = "";
                    newLines += "\n";
                    symbols = symbols.substring(1);
                    whereToBreak = 0;
                }
                whereToBreak++;

            } else if(symbols.length() == maxLengthOfSnake + 1){
                symbols = symbols.substring(1);
                spaces += " ";
            }

            if(n == 9){
                n = -1;
            }

            n++;

            print(newLines);
            print(spaces);
            print(symbols);
            sleep();
            clearConsole();
        }

    }

    private void print(String s){
        System.out.print(s);
    }

    private void clearConsole(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void sleep(){
        try{
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
