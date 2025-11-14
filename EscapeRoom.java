/*
* Problem 1: Escape Room
* 
* V1.0
* 10/10/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.util.Scanner;

/**
 * Create an escape room game where the player must navigate
 * to the other side of the screen in the fewest steps, while
 * avoiding obstacles and collecting prizes.
 */
public class EscapeRoom
{

      // describe the game with brief welcome message
      // determine the size (length and width) a player must move to stay within the grid markings
      // Allow game commands:
      //    right, left, up, down: if you try to go off grid or bump into wall, score decreases
      //    jump over 1 space: you cannot jump over walls
      //    if you land on a trap, spring a trap to increase score: you must first check if there is a trap, if none exists, penalty
      //    pick up prize: score increases, if there is no prize, penalty
      //    help: display all possible commands
      //    end: reach the far right wall, score increase, game ends, if game ended without reaching far right wall, penalty
      //    replay: shows number of player steps and resets the board, you or another player can play the same board
      // Note that you must adjust the score with any method that returns a score
      // Optional: create a custom image for your player use the file player.png on disk
    
      /**** provided code:
      // set up the game
      boolean play = true;
      while (play)
      {
        // get user input and call game methods to play 
        play = false;
      }
      */

  public static void main(String[] args) 
  {      
    // welcome message
    System.out.println("Welcome to EscapeRoom!");
    System.out.println("Get to the other side of the room, avoiding walls and invisible traps,");
    System.out.println("pick up all the prizes.\n");
    System.out.println("The following are all valid commands: Commands: right, r, left, l, up, u, down, d, pickup, p, spring, replay (when you're done call replay to see final score and steps), q, quit");
    
    GameGUI game = new GameGUI();
    game.createBoard();

    // size of move
    int m = 60; 
    // individual player moves
    int px = 0;
    int py = 0; 
    
    int score = 0;

    Scanner in = new Scanner(System.in);
    // set up game
    boolean play = true;
    while (play)
    {
      /* TODO: get all the commands working */
	    /* Your code here */
      
      System.out.print("> "); //shpws user what line they should type om
      String cmd = UserInput.getLine();  // get raw input
      
      // movement
      if (cmd.equals("right") || cmd.equals("r")) {
          score += game.movePlayer(m, 0); //moves right and changes score depending on legality of movement
          System.out.println("score=" + score); //prints score
      }
      else if (cmd.equals("left") || cmd.equals("l")) {
          score += game.movePlayer(-m, 0); //moves left and changes score depending on legality of movement
          System.out.println("score=" + score); //prints score
      }
      else if (cmd.equals("up") || cmd.equals("u")) {
          score += game.movePlayer(0, -m); //moves up and changes score depending on legality of movement
          System.out.println("score=" + score); //prints score
      }
      else if (cmd.equals("down") || cmd.equals("d")) {
          score += game.movePlayer(0, m); //moves down and changes score depending on legality of movement
          System.out.println("score=" + score); //prints score
      }

     // jump
      else if (cmd.equals("jump") || cmd.equals("jr")) {  
          score += game.jumpPlayer(m, 0); //jumps right and changes score depending on legality of movement 
          System.out.println("score=" + score); //prints score
      }
      else if (cmd.equals("jumpleft") || cmd.equals("jl")) {  
          score += game.jumpPlayer(-m, 0); //jumps left and changes score depending on legality of movement
          System.out.println("score=" + score); //prints score
      }
      else if (cmd.equals("jumpup") || cmd.equals("ju")) {  
          score += game.jumpPlayer(0, -m); //jumps up and changes score depending on legality of movement
          System.out.println("score=" + score); //prints score
      }
      else if (cmd.equals("jumpdown") || cmd.equals("jd")) {  
          score += game.jumpPlayer(0, m);  //jumps down and changes score depending on legality of movement
          System.out.println("score=" + score); //prints score
      }
      
      else if (cmd.equals("spring")) {
          score += game.springTrap(1, 0);  //checks for trap right next to the player's location
          System.out.println("Current score: " + score);
      }

      

      //prize pickup
      else if (cmd.equals("pickup") || cmd.equals("p")) {
          score += game.pickupPrize(); 
          System.out.println("score=" + score); //prints score
      }

      //replays board, also is the command you need to call to end game
      else if (cmd.equals("replay")) {
          System.out.println("steps=" + game.getSteps()); //prints steps
          score += game.replay();
          System.out.println("score=" + score); //prints score
          System.out.println("The game has now been reset.");
          score = 0;
      }

      //help menu
      else if (cmd.equals("help") || cmd.equals("?")) {
          System.out.println("Commands: right, left, up, down, pickup, spring, replay (when you're done call replay to see final score and steps), quit");
      }

      //quit game
      else if (cmd.equals("quit") || cmd.equals("q")) {
          score += game.endGame(); //quits games and adds score based on final position when quitting
          System.out.println("score=" + score); //prints score
          play = false;
      }

      else { //score deduction if you didn't type in valid command
        System.out.println("Invalid command! -5 points");
        score -= 5; //score deduction
        System.out.println("score=" + score);//prints score
      }

    }   
  }  
}

        
