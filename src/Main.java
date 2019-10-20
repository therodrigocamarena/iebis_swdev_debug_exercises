import com.sun.deploy.security.SelectableSecurityManager;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Random;

public class Main {
    /**
     * When the program fills the second board, which is smaller. It takes more than the double of time to
     * execute the process because of minningTheboard method which is clearly inefficient. It is inefficient,
     * because the blue board is of 1500000 size and the method fill it with 1499999 bombs which means mining
     * the 1499999 of the spaces, thus the method random ends sending random space numbers that are already being used.
     * In other words, the process of mining will be repeated more than 1499999 because of what I mentioned
     * beofre. Moreover, 15000000 (board size) - 1499999(n of mines) = 1. this means, we are only leaving one space empty.
     * Therefore, Makes more sense in this case, assigning a random space and then mine the rest of them
     * without to run several times the mining method
     */

    public static final int RED_BOARD = 2000000;
    public static final int BLUE_BOARD = 1500000;
    static HashMap<Integer, Element> myBoard;

    public static void settingTheBoard(int size) {
        // Setting the board
        myBoard = new HashMap<>();

        for(int i = 0; i < size; i++) {
            myBoard.put(i, new Space());
        }
    }

    /**
     *
     * @param numberMines
     * added an if in order to check the difference between the board size and the number of mines.
     *      1. If there LESS mines than (sizeoftheboard - numberofmines) we will proceed to the normal process.
     *      2. if there are MORE mines than (sizeoftheboard - numberofmines) we will prooceed to the else process,
     *      which entails
     */
    public static void minningTheBoard(int numberMines) {
        Random random = new Random();
        int []random2 = new int[myBoard.size()-numberMines];

        if(myBoard.size()-numberMines > numberMines)
            while (numberMines > 0) {
                Integer trial = new Integer(random.nextInt(myBoard.size()));

                if (myBoard.get(trial) instanceof Space) {
                    myBoard.put(trial, new Mine());
                    numberMines--;
                }
            }
        else{
            Integer trial = new Integer(random.nextInt(myBoard.size()));
            for(int i = 0; i<numberMines; i++){
                if(i != trial){
                    myBoard.put(trial, new Mine());
                }
            }
        }

    }

    public static void main(String[] args) {

        long startingTime = System.currentTimeMillis();
        settingTheBoard(RED_BOARD);
        minningTheBoard(1500000); //
        long elapsedTime = (System.currentTimeMillis() - startingTime);
        System.out.println("1,500,000 bombs planted in " + elapsedTime + " milliseconds");

        startingTime = System.currentTimeMillis();
        settingTheBoard(BLUE_BOARD);
        minningTheBoard(1499999); //
        elapsedTime = (System.currentTimeMillis() - startingTime);
        System.out.println("1,499,999 bombs planted in " + elapsedTime + " milliseconds");
    }
}
