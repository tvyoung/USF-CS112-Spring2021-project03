import java.io.*;
import java.util.*;

public class Setup {

	public static void main(String[] args) throws FileNotFoundException {
       	Scanner scan = new Scanner(new File("input1.txt"));
       	String line;
       	String[] lineSegment;

        //create new ChessBoard
        ChessBoard board = new ChessBoard(new EmptyPiece());

        ChessPiece p;
        int x;
        int y;

        //scans input1.txt file to add pieces to the board
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
                //else if current String matches none of the above, continue for loop (dont run the code below to set a board piece)
                } else {
                    continue;
                }

                //this assumes that in the given lineSegment, the name of the piece is followed by its coordinates in (x,y) order
                x = Integer.valueOf(lineSegment[i+1]);
                y = Integer.valueOf(lineSegment[i+2]);
                //sets down the piece on the board
                board.setPiece(p, x, y);      

                //FOR TESTING
                System.out.println(p + ": " + p.getCoordinates());            
          

            }

       	}

        System.out.println(board);

        //FOR TESTING
        board.printBoardCoordinates();

	}
}
