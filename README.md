# project3-chess

Vicki Young

CS 112-01

due date: 2021.05.15 at 2359

completed: 2021.05.10

NOTES
- of course i pulled code from project 2 to help create project 3
- received no outside help aside from visiting office hours and asking in class questions
- created custom class EmptyPiece to represent empty spaces on the chess board
- created input3.txt for custom testing
- both ChessMoves and ChessBasics have two while loops to run the input file twice (once to set down pieces, and another time to move pieces).
	- this has to assume that all chess pieces will be placed down first before attempting to move any. 
- there is a check for setting a piece down out of bounds on the board (part of OutOfBoardException)
- there is also a check for setting a piece down on a location that is free (part of PathwayException); a piece will not be able to replace another piece in the same location
	- this is demonstrated in game.txt, when placing down a Rook at (7,6) results in an error, because the location is already occupied by a pawn.
- game.txt tests moves first by demonstrating the different types of exceptions that can be caught, followed by demonstrations of each chess piece's types of moves + moves they cannot make due to pathway obstructions. 
- for the bonus part, in ChessBoard's checkFreePathway() method, im pretty sure i could have simplified it even further to just include bishop/rook checks in the queen check, because checking a queen's possible moves is just checking a combination of rook/bishop moves. but i left it the way it is because the further simplification would have been too confusing for me to look at. 
- Setup implements no exceptions. ChessMoves implements only OutOfBoardException and IllegalChessMoveException (it implements PathwayException but only when setting down a piece). ChessBasics implements OutOfBoardException, IllegalChessMoveException, and PathwayException.

PERSONAL/QUESTIONS
- for input files it is assumed that the same format will always be followed 
	- ex. setting a piece will always start with the name of a piece in lowercase, followed by coordinates, x first and then y
	- ex. moving a piece will always start with "move" in lowercase, followed by the coordinates of a piece (first x, then y) and then followed by the destination (first x, and then y)

CHECKLIST

part A (3 files)
- README
- ChessPiece
- ChessBoard

part B (7 files)
- EmptyPiece
- Pawn
- Rook
- Knight
- Bishop
- Setup
- input1.txt

part C (2 files)
- input2.txt
- ChessMoves

part D (3 files)
- OutOfBoardException
- IllegalChessMoveException
- tester.txt 

part E (4 files)
- ChessBasics
- King
- Queen
- game.txt

bonus (1 file)
- PathwayException

alphabetical
1) Bishop
2) ChessBasics
3) ChessBoard
4) ChessMoves
5) ChessPiece
6) EmptyPiece
7) game.txt
8) IllegalChessMoveException
9) input1.txt
10) input2.txt
11) input3.txt
12) King
13) Knight
14) OutOfBoardException
15) PathwayException
16) Pawn
17) Queen
18) README
19) Rook
20) Setup



