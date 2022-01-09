package com.bridgelabz.tictactoe.game;

public class TicTacToeGameBoard {
    //Playing Board Array for Locations
    private static char[] boradArray = new char[10];

    //UC 1 Method for initializing board position
    private static void initializeBoard() {
        for(int i=1; i<10; i++) {
            boradArray[i]=' ';
        }
    }

    public static void main(String[] args) {


        System.out.println("Welcome to Tic Tac Toe Game Simulator.");

        //Initializing the Playing Board boxes
        initializeBoard();
    }
}
