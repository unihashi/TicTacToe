# TicTacToe
Game Tic Tac Toe with command line

this game is support any size of Tic Tac Toe all you need is only change GameSize before you start to play a game!

val GameSize = 3

val ROWS = GameSize
val COLLUMNS = GameSize
var board = Array(ROWS) { IntArray(COLLUMNS)}

this coordinates in this game is 2d array (row,collumn) you need to enter input row and input collumn once you play the game

  player 'o' enter the coordinates : 
2
1
  x  |     |    
 ---------------
  o  |  x  |    
 ---------------
     |  o  |    


  player 'x' enter the coordinates : 
2
2
  x  |     |    
 ---------------
  o  |  x  |    
 ---------------
     |  o  |  x 


player 'x' won!


