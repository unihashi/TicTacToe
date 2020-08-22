package com.example.tictactoe

val GameSize = 5

val ROWS = GameSize
val COLLUMNS = GameSize
var board = Array(ROWS) { IntArray(COLLUMNS)}

val EMPTY = 0
val CROSS = 1
val NOUGHT = 2

val playing = 0
val draw = 1
val xwon = 2
val owon = 3

var currentState = EMPTY
var currentPlayer = EMPTY
var currentRow = EMPTY
var currentColumn = EMPTY

fun main(args:Array<String>){

    println()
    printBoard()
    initGame()
    do {
        playerMove(currentPlayer)
        updateGame(currentPlayer, currentRow, currentColumn)
        printBoard()

        if (currentState == xwon) {
            println("player 'x' won!")
        } else if (currentState == owon) {
            println("player 'o' won!")
        } else if (currentState == draw) {
            println("It's a Draw")
        }

        if (currentPlayer == CROSS) {
            currentPlayer = NOUGHT
        } else {
            currentPlayer = CROSS
        }
    } while (currentState == playing)
}

fun initGame() {
    for(row in 0..ROWS-1) {
        for(col in 0..COLLUMNS-1) {
            board[row][col] = EMPTY
        }
    }
    currentState = playing
    currentPlayer = CROSS
}

fun playerMove(seed: Int) {
    var validInput = false
    do {
        if(seed == CROSS) {
            println("player 'x' enter the coordinates : ")
        } else {
            println("player 'o' enter the coordinates : ")
        }
        var row = readLine()!!.toInt()
        var col = readLine()!!.toInt()
        if (row >= 0 && row < ROWS && col >= 0 && col < COLLUMNS && board[row][col] == EMPTY) {
            currentRow = row;
            currentColumn = col;
            board[currentRow][currentColumn] = seed
            validInput = true
        } else {
            println("This move at (" + (row) + "," + (col) + ") is not valid. Try again...")
        }
    } while (!validInput)
}

fun updateGame(seed: Int,currentRow: Int, currentCol: Int) {
    if (hasWon(seed, currentRow, currentCol)) {
        if (seed == CROSS) {
            currentState = xwon
        } else {
            currentState = owon
        }
    } else if (isDraw()) {
        currentState = draw
    }
}

fun isDraw(): Boolean {
    for(row in 0..ROWS-1) {
        for(col in 0..COLLUMNS-1) {
            if(board[row][col] == EMPTY) {
                return false
            }
        }
    }
    return true
}

fun hasWon(seed: Int, currentRow: Int, currentCol: Int): Boolean {
    for(col in 0..COLLUMNS-2) {
        if (board[currentRow][col] == seed && board[currentRow][col+1] == seed) {
            if (col+2 == COLLUMNS) {
                return board[currentRow][col] == seed
            }
        } else {
            break
        }
    }
    for(row in 0..ROWS-2) {
        if (board[row][currentCol] == seed && board[row+1][currentCol] == seed) {
            if (row+2 == ROWS) {
                return board[row][currentCol] == seed
            }
        } else {
            break
        }
    }
    if (currentRow == currentCol) {
        for(row in 0..ROWS-2) {
            if (board[row][row] == seed && board[row+1][row+1] == seed) {
                if (row+2 == ROWS) {
                    return board[row][row] == seed
                }
            } else {
                break
            }
        }
    }
    if (currentRow + currentCol == GameSize-1) {
        for(row in 0..ROWS-2) {
            if (board[row][GameSize-1] == seed && board[row+1][GameSize-2] == seed) {
                if (row+2 == ROWS) {
                    return board[row][GameSize-1] == seed
                }
            } else {
                break
            }
        }
    }
    return false
}

fun printBoard() {
    for(row in 0..ROWS-1) {
        for(col in 0..COLLUMNS-1) {
            printCell(board[row][col])
            if (col != COLLUMNS - 1) {
                print(" | ")
            }
        }
        println()
        if (row != ROWS - 1)
            for(row in 0..ROWS-1) {
                print("-----")
            }
        println()
    }
    println()
}

fun printCell(content: Int) {
    when (content) {
        EMPTY -> print("   ")
        NOUGHT -> print(" o ")
        CROSS -> print(" x ")
    }
}