import java.util.Scanner;

/**
 * Created by Donal ON 07/05/2019
 * X and Os 
 */

public class XandOs {

   static Scanner keyboard = new Scanner(System.in);

   public static void main(String[] args) {

      char [] [] gameBoard = { {'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'} };

      int goes = 0;

      printBoard(gameBoard);

      boolean winner = false;

      System.out.println(" ");

      System.out.print("Select X or O: ");
      char currentChar = keyboard.next().charAt(0);

      while (!winner && goes < 9) {

         System.out.println(" ");

         System.out.println("Current player is: " + currentChar);

         System.out.print("Select Row {1, 2 or 3]: ");
         int row = keyboard.nextInt();

         System.out.print("Select Column {1, 2 or 3]: ");
         int column = keyboard.nextInt();

         if(gameBoard[row - 1] [column - 1] == 'X' || gameBoard[row - 1] [column - 1] == 'O')
         {
            System.out.println("Square is already taken!!!!");
            System.out.println("Try again.... ");
            System.out.println(" ");
         }else{
            gameBoard[row - 1] [column - 1] = currentChar;
            goes++;

            if (currentChar == 'X') {
               currentChar = 'O';
            }else{
               currentChar = 'X';
            }

            if (checkWinner(gameBoard, 'X')){
               System.out.println(" ");
               System.out.println("********************");
               System.out.println("X has won!");
               System.out.println("********************");
               System.out.println(" ");
               winner = true;
            }

            if (checkWinner(gameBoard, 'O')){
               System.out.println(" ");
               System.out.println("********************");
               System.out.println("O has won!");
               System.out.println("********************");
               System.out.println(" ");
               winner = true;
            }

            printBoard(gameBoard);

         }



      }

      if (!winner)  System.out.println("NO WINNNER :-(");

   }//main

   public static void printBoard(char[][] board){

      for (int row = 0; row < board.length; row++){
         for (int column = 0; column < board[row].length; column++){
            System.out.print(board[row][column] + "\t");
         }
         System.out.println(" ");
         System.out.println(" ");
      }

      System.out.println(" ");
   }

   public static boolean checkWinner(char[][] board, char charToCheck){

      int total = 0;

      // check rows
      for (int row = 0; row < board.length; row++){
         total = 0;
         for (int column = 0; column < board[row].length; column++){
            if(board[row][column]==charToCheck) total++;
         }
         if(total == 3) return true;
      }

      for (int column = 0; column < board[0].length; column++){
         total = 0;
         for (int row = 0; row < board.length; row++){
            if(board[row][column]==charToCheck) total++;
         }
         if(total == 3) return true;
      }

      //check diagonals
      total = 0;
      for(int i = 0; i < 3; i++){
         if(board[i][i]==charToCheck) total++;
      }
      if(total == 3) return true;

      for (int column = 0; column < board[0].length; column++){
         total = 0;
         for (int row =  board.length - 1; row >=0; row--){
            if(board[row][column]==charToCheck) total++;
         }
         if(total == 3) return true;
      }

      return false;
   }


}//class
