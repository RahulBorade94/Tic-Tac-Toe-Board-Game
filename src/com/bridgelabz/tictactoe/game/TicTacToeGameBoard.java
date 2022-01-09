package com.bridgelabz.tictactoe.game;

import java.util.Scanner;

public class TicTacToeGameBoard {
    //Playing Board Array for Locations
    private static char[] boardArray = new char[10];
    private static char playingSymbol;

    //UC 1 Method for initializing board position
    private static void initializeBoard() {
        for(int i = 1; i < 10; i++) {
            boardArray[i] = '_';
        }
    }

    //Showing the Board Elements
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
        }    }

    //UC 2 Method for setting Input Symbol for User
    private static void setPlayingSymbol() {
        while(playingSymbol != 'X' && playingSymbol != 'O') {
            System.out.println("Please Select the Symbol for Play: X or O");
            //Scanner Method for User Input
            Scanner sc = new Scanner(System.in);
            playingSymbol = sc.next().charAt(0);
            switch (playingSymbol) {
                case 'X':
                    System.out.println("Player Selected " + playingSymbol + " Symbol");
                    break;
                case 'O':
                    System.out.println("Player Selected " + playingSymbol + " Symbol");
                    break;
                default:
                    System.out.println("Please Select the Symbol From X or O only");
                    break;
            }
        }
    }

    public static void main(String[] args) {

        //Tic Tac Toe Game Development
        System.out.println("Welcome to Tic Tac Toe Game Simulator.");

        //Initializing the Playing Board boxes
        initializeBoard();

        //Setting the Symbol for Play
        setPlayingSymbol();

        showBoard();
    }
}
