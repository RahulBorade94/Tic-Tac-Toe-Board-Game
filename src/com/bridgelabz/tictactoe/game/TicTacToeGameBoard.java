package com.bridgelabz.tictactoe.game;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGameBoard {
    //Playing Board Array for Locations
    private static char[] boradArray = new char[10];
    private static char player1Symbol,player2Symbol;
    private static int player1Play = 1;

    //Making Scanner Object Global
    static Scanner sc;


    //Method to Initialize Scanner Object
    private static void initScanner() {
        sc = new Scanner(System.in);
    }
    //UC 1 Method for initializing board position
    private static void initializeBoard() {
        for(int i = 1; i < 10; i++) {
            boradArray[i] = '_';
        }
    }

    //UC 3 Showing the Board Elements
    private static void showBoard() {
        for (int i = 1; i < 10; i++) {
            if ((i) % 3 == 0) {
                System.out.println(boradArray[i]);
                if (i != 10 - 1) {
                    System.out.println("-----");
                }
            } else {
                System.out.print(boradArray[i] + "|");
            }
        }
    }

    //UC 2 Method for setting Input Symbol for User
    private static void setPlayingSymbol() {
        while(player1Symbol != 'X' && player1Symbol != 'O') {
            System.out.println("Player 1 Please Select the Symbol for Play: X or O");
            //Scanner Object Initilize Method for User Input
            initScanner();
            player1Symbol = sc.next().charAt(0);
            switch (player1Symbol) {
                case 'X':
                    player2Symbol = 'O';
                    System.out.println("Player 1 Selected " + player1Symbol + " Symbol");
                    System.out.println("Player 2 Selected " + player2Symbol + " Symbol");
                    break;
                case 'O':
                    player2Symbol = 'X';
                    System.out.println("Player 1 Selected " + player1Symbol + " Symbol");
                    System.out.println("Player Selected " + player2Symbol + " Symbol");
                    break;
                default:
                    System.out.println("Please Select the Symbol From X or O only");
                    break;
            }
        }
    }

    //Method for Setting Player Turn
    private static void setPlayChance() {
        if(player1Play == 1) {
            player1Play = 0;
        } else {
            player1Play = 1;
        }
    }

    //UC 4 Get User Input and Move on Board
    private static void playGame() {
        if(player1Play == 1) {
            getSymbol(1,player1Symbol);
        } else {
            getSymbol(2,player2Symbol);
        }
        setPlayChance();
    }

    //Methode for Getting Input From Player
    private static void getSymbol(int playerNo,char symbol) {
        initScanner();
        int playerPosition;
        System.out.println("Player "+playerNo+" Please Enter the Position for Your Play :");
        playerPosition = sc.nextInt();
        if(checkFreePosition(playerPosition)) {
            boradArray[playerPosition] = symbol;
        } else {
            playGame();
            setPlayChance();
        }
    }

    //Uc 5 Check for Free Space and Make Move
    private static boolean checkFreePosition(int enteredPosition) {
        if(enteredPosition < 1 || enteredPosition > 9) {
            System.out.println("Please Enter the Position between 1 to 9 only.");
            return false;
        } else if(boradArray[enteredPosition] != '_') {
            System.out.println("Entered Location Contain Symbol. Please Enter Another Location.");
            return false;
        } else {
            return true;
        }
    }

    //Uc 6 Make Toss for Player Chance
    private static void flipToss() {
        Random tossValue = new Random();
        int toss = tossValue.nextInt(2)+1;
        if(toss == 1) {
            player1Play = 1;
            System.out.println("Player 1 Won the Toss.");
        } else {
            player1Play = 0;
            System.out.println("Player 2 Won the Toss.");
        }
    }

    public static void main(String[] args) {

        //Tic Tac Toe Game Development
        System.out.println("Welcome to Tic Tac Toe Game Simulator.");

        //Initializing the Playing Board boxes
        initializeBoard();

        //Setting the Symbol for Play
        setPlayingSymbol();

        //Showing the Initial Board
        showBoard();

        //Flip the Toss for Player Play Chance
        flipToss();

        //Play the Game till Win Or Draw
        while(true) {
            playGame();
            showBoard();
        }
    }

}


