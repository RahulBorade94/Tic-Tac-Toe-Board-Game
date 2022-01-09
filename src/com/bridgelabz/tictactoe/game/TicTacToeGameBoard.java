package com.bridgelabz.tictactoe.game;

import java.util.Scanner;

public class TicTacToeGameBoard {
    //Playing Board Array for Locations
    private static char[] boardArray = new char[10];
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
            boardArray[i] = '_';
        }
    }

    //UC 3 Showing the Board Elements
    private static void showBoard() {
        for (int i = 1; i < 10; i++) {
            if ((i) % 3 == 0) {
                System.out.println(boardArray[i]);
                if (i != 10 - 1) {
                    System.out.println("-----");
                }
            } else {
                System.out.print(boardArray[i] + "|");
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
        initScanner();
        if(player1Play == 1) {
            System.out.println("Player 1 Please Enter Your Position for Play : ");
            int playerPosition = sc.nextInt();
            boardArray[playerPosition] = player1Symbol;
        } else {
            System.out.println("Player 2 Please Enter Your Position for Play : ");
            int playerPosition = sc.nextInt();
            boardArray[playerPosition] = player2Symbol;
        }
        setPlayChance();
    }

    public static void main(String[] args) {

        //Tic Tac Toe Game Development
        System.out.println("Welcome to Tic Tac Toe Game Simulator.");

        //Initializing the Playing Board boxes
        initializeBoard();

        //Setting the Symbol for Play
        setPlayingSymbol();

        showBoard();
        while(true) {
            playGame();
            showBoard();
        }
    }

}


