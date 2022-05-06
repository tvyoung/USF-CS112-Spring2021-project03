import java.io.*;
import java.util.*;

public class ChessBasics {

	public static void main(String[] args) throws FileNotFoundException {
	   	Scanner scan = new Scanner(new File("game.txt"));
	   	String line;
	   	String[] lineSegment;

	   	//for user input
	   	Scanner enter = new Scanner(System.in);

	    //create new ChessBoard
	    ChessBoard board = new ChessBoard(new EmptyPiece());

	    //exception for out of bounds
	    OutOfBoardException outOfBounds = new OutOfBoardException("Invalid Board Position.");
	    //exception for illegal pathway
	    PathwayException illegalPathway = new PathwayException("Invalid Location. Space already occupied.");

	    ChessPiece p;
	    int x;
	    int y;

	    //scans input file to add pieces to the board
	   	while(scan.hasNextLine())
	   	{
	      	line = scan.nextLine();
	       	lineSegment = line.split(" "); // stores all input in array of Strings
				//System.out.println(lineSegment[0]);

	        //lineSegment is an array made up of the given line in the txt file 
	        //go through given line to setPiece
	        for (int i = 0; i < lineSegment.length; i++) {
	            //FOR TESTING
	            //System.out.println(lineSegment[i]);

	            //if any String in lineSegment is pawn, creates new piece Pawn
	            if (lineSegment[i].equals("pawn")) {
	                p = new Pawn();
	            //if any String in lineSegment is rook, creates new piece Rook
	            } else if (lineSegment[i].equals("rook")) {
	                p = new Rook();
	            //if any String in lineSegment is knight, creates new piece Knight
	            } else if (lineSegment[i].equals("knight")) {
	                p = new Knight();
	            //if any String in lineSegment is bishop, creates new piece Bishop
	            } else if (lineSegment[i].equals("bishop")) {
	                p = new Bishop();
	            } else if (lineSegment[i].equals("king")) {
	                p = new King();
	            } else if (lineSegment[i].equals("queen")) {
	                p = new Queen();

	            //if any String in lineSegment is move, break from while loop
	            //assumes that all chess pieces have already been placed
	            } else if (lineSegment[i].equals("move")) {
	            	break;
	            
	            //else if current String does not match a chess piece or "move," then continue for loop (dont run the code below to set a board piece)
	            } else {
	                continue;
	            }

	            //this assumes that in the given lineSegment, the name of the piece is followed by its coordinates in (x,y) order
	            x = Integer.valueOf(lineSegment[i+1]);
	            y = Integer.valueOf(lineSegment[i+2]);

		    	try {            	
					//1: checks if the coordinates point to a destination out of bounds on the board
		 			//if coordinates are out of bounds (returns true), throws OutOfBoardException
					if (board.checkOutOfBounds(x,y)) {
						throw outOfBounds;
			       	}

			       	//2: checks if the destination coordinates point to a free space on the board
			       	//if the coordinates point to a location that is NOT free (another piece already occupies it), returns false, throws exception
			       	if (!board.checkFreeSpace(x,y)) {
			       		throw illegalPathway;
			       	}

			    //catch out of bounds exception	
		        } catch (OutOfBoardException e) {
		        	System.out.println("\n" + p + ": (" + x + "," + y + ")");
		           	System.out.print(outOfBounds.getMessage());
		            System.out.println(" (" + x + "," + y + ")");
	            	
	            	System.out.println("Press anything to continue.");
	            	enter.nextLine();

		            //continue (dont run the code below to set piece down on board)
		            continue;

		        //catch invalid pathway exception   	
		        } catch (PathwayException e) {
		        	System.out.println("\n" + p + ": (" + x + "," + y + ")");
		        	System.out.print(illegalPathway.getMessage());
		        	System.out.println(" (" + x + "," + y + ")");

		        	System.out.println("Press anything to continue.");
		        	enter.nextLine();

		        	//continue (dont run the code below to set a piece down on board)
		        	continue;
		        } 

	            //if the above check is passed, sets down the piece on the board
	            board.setPiece(p, x, y);

	            //FOR TESTING
	            System.out.println(p + ": " + p.getCoordinates());            
	 	   	}
		}
		//after placing all chess pieces, print current board
	    System.out.println("\nPieces successfully placed down. Current board:");
	    System.out.println(board);

	    //scan input file again to reset file
	    scan = new Scanner(new File("game.txt"));

	    //then scans input file again to moves pieces on the board
	    System.out.println("Moving pieces. Press anything to continue. \n");
	    enter.nextLine();
	   	while(scan.hasNextLine())
	   	{
	      	line = scan.nextLine();
	       	lineSegment = line.split(" "); // stores all input in array of Strings
				//System.out.println(lineSegment[0]);

	        //lineSegment is an array made up of the given line in the txt file 
	        //go through given line to setPiece
	        for (int i = 0; i < lineSegment.length; i++) {
	        	if (lineSegment[i].equals("move")) {
	            	moveChessPiece(board, lineSegment);

	            	//for ease of access
	            	System.out.println("Press anything to continue.");
	            	enter.nextLine();
	            }
	        }

	   	}


	}


	//move a chess piece
	public static void moveChessPiece(ChessBoard currentBoard, String[] line) {
    	//exception for out of bounds move
    	OutOfBoardException outOfBounds = new OutOfBoardException("Invalid Board Position.");
    	//exception for illegal move
    	IllegalChessMoveException illegalMove = new IllegalChessMoveException("Invalid Move.");
    	//exception for pathway obstruction
    	PathwayException illegalPathway = new PathwayException("Invalid Pathway.");

		//assumes that in the given line, "move" is followed by the coordinates to a piece in (x,y) order
	    int x = Integer.valueOf(line[1]);
		int y = Integer.valueOf(line[2]);
	    //assumes it is then followed by the coordinates of where the piece should move in (x,y) order            	
		int moveX = Integer.valueOf(line[3]);
		int moveY = Integer.valueOf(line[4]);

        //1: checks if given coordinates do match to a piece on the board
	    //if the coordinates DONT point to a piece on the board, prints a message stating so, then returns (doesnt continue)
	    if (!currentBoard.checkForPiece(x,y)) {
	    	System.out.println("Given coordinates (" + x + "," + y + ") do not match to a piece on the board.");
	    	return;
	    } 

	    //2: prints out the chess piece's current coordinates and next move's destination
		//gets piece at given coordinates
	    ChessPiece p = currentBoard.getPiece(x,y);
		//prints out: PIECE: (current x,y) (move to x,y)
		System.out.println(p + ": " + p.getCoordinates() + " to (" + moveX + "," + moveY + ")");

    	try {            	
			//3: checks if the move coordinates point to a destination out of bounds on the board
 			//if move coordinates are out of bounds (returns true), throws OutOfBoardException
			if (currentBoard.checkOutOfBounds(moveX,moveY)) {
				throw outOfBounds;
	       	}

	       	//4: (BONUS) checks if there is another chess piece on the way
	       	//either at the destination coordinate or in the path to the destination coordinate
	       	//if there is not a free pathway (returns false), then throws exception
	       	if (!currentBoard.checkFreePathway(x,y,moveX,moveY)) {
	       		throw illegalPathway;
	       	}

	       	//5: moves the chess piece if the above checks are passed
          	//if the move is valid (returns true), move the piece on the board
          	if (p.move(moveX,moveY)) {
	            System.out.println("Moved! " + p.getCoordinates() + " to (" + moveX + "," + moveY + ")");
	            currentBoard.movePiece(x,y,moveX,moveY);
				//then print updated board
				System.out.println("\nCurrent board:");
	            System.out.println(currentBoard);

	        //else if the move is not valid (returns false), throws IllegalChessMoveException
	        } else {
	            throw illegalMove;
	        }

	    //catch out of bounds exception	
        } catch (OutOfBoardException e) {
           	System.out.print(outOfBounds.getMessage());
            System.out.println(" " + p.getCoordinates() + " to (" + moveX + "," + moveY + ")");

        //catch illegal chess move exception
       	} catch (IllegalChessMoveException e) {
          	System.out.print(illegalMove.getMessage());
           	System.out.println(" " + p.getCoordinates() + " to (" + moveX + "," + moveY + ")");

        //catch invalid pathway exception   	
        } catch (PathwayException e) {
        	System.out.print(illegalPathway.getMessage());
        	System.out.println(" " + p.getCoordinates() + " to (" + moveX + "," + moveY + ")");
        }


	}


}