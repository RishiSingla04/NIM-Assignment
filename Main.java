//Rishi Singla - Nov. 9, 2020: This program works as the NIM game. This program goes through each player and asks them which row and the amount of sticks they want to remove. At the end, the program checks if there are any sticks left. If not, the program will Determine the Loser out of the two player and output it. The program then asks the user if they would like to play again.


import java.util.Scanner;

class Main {
  public static void main(String[] args) { // main method which calls the other methods
    Scanner input = new Scanner(System.in); // Scanner is created
    int play = 1;
    while (play == 1) { // While loop to make sure the User wants to play again
      int[] piles = setup(); // calls setup and gets the array values
      Piles(piles); // calls piles and sends an array
      System.out.println("Would you like to play again?\n1 - Yes\n0 - No");
      play = input.nextInt(); // inputs if user wants to play again
    }
    System.out.println("Thanks For Playing!");
  }

  public static void Piles(int[] piles) { // This method receives an array and doesn't return anything
    Display(piles);
    int player1win = 0;
    int player2win = 0;
    while (DetermineLoser(piles) == false) { // While loop which calls the main methods required to run the game
      piles = Player1turn(piles);
      DetermineLoser(piles);
      if (DetermineLoser(piles) == true) { // checks if player 1 lost
        System.out.println("Player 2 Won");
        player2win = player2win+1;
        break;
      }
      piles = Player2turn(piles);
      if (DetermineLoser(piles) == true) { // checks if player 2 lost
        System.out.println("Player 1 Won");
        player1win = player1win+1;
        break;
      }
    }
    System.out.println("Player 1 has " + player1win + " wins");
    System.out.println("Player 2 has " + player2win + " wins");
  }

  public static int[] setup() { // sets up the game and recieves no parameters
    int[] piles = { 1, 3, 5, 7 };
    return piles;
  }

  public static void Display(int[] P) { // this method recieves an array so it can displays the current scores
    for (int c = 0; c < P.length; c++) {
      System.out.print("Pile " + c + " = " );
      for (int i = 0; i < P[c]; i++){
        System.out.print(" | ");
      }
      System.out.println();
    }
  }

  public static int[] Player1turn(int[] P) { // this method recieves an array so that it can run Player 1's turn
    Scanner input = new Scanner(System.in);
    System.out.println("Player #1 turn");
    boolean turn = false;
    while (turn != true) {
      System.out.println("Enter the row you want to choose: ");
      int row = input.nextInt();
      System.out.println("Enter the number of sticks you want to remove: ");
      int sticks = input.nextInt();
      if ((row > -1) && (row < P.length)) {
        if (Check(P[row]) == true) {
          if (Check(P[row], sticks) == true) {
            P[row] = RemoveNumber(P[row], sticks);
            turn = true;
          } else {
            System.out.println("Invalid number of Sticks to be Removed");
          }
        } else {
          System.out.println("Row doesn't contain any Sticks");
        }
      } else {
        System.out.println("Invalid Row");
      }
    }
    Display(P);
    return P;
  }

  public static int[] Player2turn(int[] P) { // this method recieves an array so that it can run Player 2's turn
    Scanner input = new Scanner(System.in);
    System.out.println("Player #2 turn");
    boolean turn = false;
    while (turn != true) {
      System.out.println("Enter the row you want to choose: ");
      int row = input.nextInt();
      System.out.println("Enter the number of sticks you want to remove: ");
      int sticks = input.nextInt();
      if ((row > -1) && (row < P.length)) {
        if (Check(P[row]) == true) {
          if (Check(P[row], sticks) == true) {
            P[row] = RemoveNumber(P[row], sticks);
            turn = true;
          } else {
            System.out.println("Invalid number of Sticks to be Removed");
          }
        } else {
          System.out.println("Row doesn't contain any Sticks");
        }
      } else {
        System.out.println("Invalid Row");
      }
    }
    Display(P);
    return P;

  }

  public static boolean Check(int P) { // this method recieves the amount of sticks in a pile and checks if the pile has sticks to be removen from
    boolean check = false;
    if (P > 0) {
      check = true;
    }
    return check;
  }

  public static boolean Check(int P, int S) { // this method recieves the amount of sticks and the sticks to be removen so it can checks if the number of sticks to be removen will cause an error in the game
    boolean check = false;
    if ((S <= P) && (S > 0)) {
      check = true;
    }
    return check;
  }

  public static int RemoveNumber(int P, int S) { // this method recieves the row and stick to remove and removes the sticks from the pile
    P = P - S;
    return P;

  }

  public static boolean DetermineLoser(int[] P) { // this method recieves the array and determines if the game ends or not
    boolean check = true;
    for (int c = 0; c < P.length; c++) {
      if (P[c] > 0) {
        check = false;
      }
    }
    return check;
  }
}