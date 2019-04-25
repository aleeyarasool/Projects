
# coding: utf-8

# In[ ]:


from random import *

board = []

for i in range(5):
    board.append(["O"] * 5)

def printBoard(board):
    for row in board:
        print(' '.join(row))
printBoard(board)

#Generates a random point where the ship is located
def randomRow(board):
    return randint(0, len(board) - 1)
def randomColumn(board):
    return randint(0, len(board[0]) - 1)

shipRow = randomRow(board)
shipColumn = randomColumn(board)

for turn in range(4):
    print ("Turn", turn + 1)
    guessRow = int(input("Guess Row: "))
    guessColumn = int(input("Guess Column: "))

if (guessRow == shipRow) and (guessColumn == shipColumn):
    print("You sank my battleship! You win!") 
    break
else:
    if (guessRow not in range(5)) or (guessColumn not in range(5)):
        print("Invalid! Try again!")
    elif (board[guessRow][guessColumn] == 'X'):
        print("You guessed that one already. Try Again!")
    else:
        print("You missed! Try again!")
        board[guessRow][guessColumn] = "X"
    if (turn == 3):
        print("Game Over")
printBoard(board)

