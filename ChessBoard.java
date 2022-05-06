//creates a chess board of the game using a 2D array
//this board follows the Cartesian Coordinate System
//the (0,0) coordinate pair is not the intersection of the two planes
//not printing out our 2D arrays beginning with (0,0) at the top left of the grid

public class ChessBoard {

	private int size = 8;
    private ChessPiece[][] board;

    //constructor that creates a size x size board of ChessPieces
    //each ChessPiece set to an initial ChessPiece
    public ChessBoard(ChessPiece c) 
    {
        board = new ChessPiece[size][size];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = c;
            }
        }
    }

    //FOR TESTING (in Setup.java)
    //print board coordinates
    public void printBoardCoordinates()
    {
        for (int i=0; i<board.length; i++) 
        {
            for (int j=0; j<board[i].length; j++)
            {
                System.out.print("["+i+","+j+"] ");
            }
            System.out.println();
        }
        System.out.println();
    }

	//String representation of the board showing the contents of each space 
    public String toString()
    {
        String text = "";
        for (int row = 0; row < board.length; row++) {
        	text += "=" + (board.length-row-1) + "= ";
            for (int column = 0; column < board[row].length; column++) {
                text += "-" + board[row][column].getChessValue() + "- ";
            }
            text += "\n\n";
        }
        text += "=== =0= =1= =2= =3= =4= =5= =6= =7=\n";
        return text;
    }

	//sets a ChessPiece on the board with coordinates (x,y)
    public boolean setPiece(ChessPiece c, int x, int y)
    {
    	/*
    	(0,0) corresponds to (7,0)
    	(3,2) corresponds to (5,3)
    	for board[i][j]
    	i = board.length-1 - y (as in, 7-y)
     	j = x
    	*/
     	c.setCoordinates(x,y);
        board[board.length-1-y][x] = c;
        return true;
    }

 	//gets a ChessPiece that is on the board with coordinates (x,y)  
    public ChessPiece getPiece(int x, int y)
    {
    	return board[board.length-1-y][x];
    }

    //checks if there is a piece on the board with the given coordinates (x,y)
    public boolean checkForPiece(int x, int y) {
    	ChessPiece freeSpace = new EmptyPiece();
    	//if the coordinates do NOT point to a free space on the board, return true
    	if (!getPiece(x,y).match(freeSpace)) {
    		//FOR TESTING
    		//System.out.println(getPiece(x,y) + " is present");
    		return true;
    	}
    	//otherwise return false
    	return false;
    }

    //checks if there is a free space on the board with at the given coordinates (x,y)
    public boolean checkFreeSpace(int x, int y) {
        ChessPiece freeSpace = new EmptyPiece();
        //if the coordinates do NOT point to a free space on the board, return false
        if (!getPiece(x,y).match(freeSpace)) {
            //FOR TESTING
            //System.out.println(getPiece(x,y) + " is present");
            return false;
        }
        //otherwise return false
        return true;
    }


    //checks if the given coordinates (x,y) are out of bounds of the board
    public boolean checkOutOfBounds(int x, int y) {

    	//if both the x and y coordinates are positive numbers and less than the size of the board, return false (not out of bounds)
    	if (x >= 0 && x < size && y >= 0 && y < size) {
    		return false;
    	}
    	//otherwise return true (is out of bounds)
    	return true;
    }

    //moves a chess piece at current (x,y) to a new spot 
    public void movePiece(int currentX, int currentY, int moveX, int moveY) {
    	//creates an emptySpace empty chess piece
    	ChessPiece emptySpace = new EmptyPiece();
    	//gets the chess piece at current location
    	ChessPiece c = board[board.length-1-currentY][currentX];

    	//sets current location's chess piece to new location
		setPiece(c, moveX, moveY);
		//sets emptySpace at current location (clears out current location) 
		setPiece(emptySpace, currentX, currentY);
    }

    //checks if there is another chess piece on the way, either at the destination coordinate or in the path to the destination coordinate
    public boolean checkFreePathway(int currentX, int currentY, int moveX, int moveY) {
    	//creates an emptySpace empty chess piece
    	ChessPiece emptySpace = new EmptyPiece();    	
    	//gets the chess piece at current location
    	ChessPiece c = board[board.length-1-currentY][currentX];

    	//if pathway from chesspiece C to destination is occupied by any other chesspiece (anything thats not blank) then return false
    	//first check if the space itself is occupied; if this is already occupied, no need to check pathway, just return false

    	//if destination coordinate does not match a free space, return false
    	if (!getPiece(moveX,moveY).match(emptySpace)) {
    		return false;
    	}
    	//if current chess piece is a Bishop
    	if (c.getChessValue().equals("b")) {
    		//first check in which direction is the Bishop piece moving (by comparing between current and destination coordinates)
            //need to check for loop with i = 1 so as to not check current/destination coordinates (destination coordinates already checked)
            //if Bishop is moving northeast (diagonal top right)
            if (currentX < moveX && currentY < moveY) {
                //check pathway along diagonal; if any space is not free, return false
                for (int i = 1; i < moveX; i++) {
                    if (!getPiece(currentX+i,currentY+i).match(emptySpace)) {
                        return false;
                    }
                }
            //if Bishop is moving southeast (diagonal lower right)    
            } else if (currentX < moveX && currentY > moveY) {
                //check pathway along diagonal; if any space is not free, return false
                for (int i = 1; i < moveX; i++) {
                    if (!getPiece(currentX+i,currentY-i).match(emptySpace)) {
                        return false;
                    }
                }
            //if Bishop is moving southwest (diagonal lower left)    
            } else if (currentX > moveX && currentY > moveY) {
                //check pathway along diagonal; if any space is not free, return false
                for (int i = 1; i < moveX; i++) {
                    if (!getPiece(currentX-i,currentY-i).match(emptySpace)) {
                        return false;
                    }
                }
            //if Bishop is moving northwest (diagonal top left)     
            } else if (currentX > moveX && currentY < moveY) {
                //check pathway along diagonal; if any space is not free, return false
                for (int i = 1; i < moveX; i++) {
                    if (!getPiece(currentX-i,currentY+i).match(emptySpace)) {
                        return false;
                    }
                }
            }
		//if current chess piece is a Rook
    	} else if (c.getChessValue().equals("r")) {
    		//first check in which direction is the Rook piece moving
            //need to check for loop with i+1 so as to not check current/destination coordinates (destination coordinates already checked)
    		//if Rook is moving north/up 
    		if (currentX == moveX && currentY < moveY) {
                //check pathway along Y coordinate for free space, if any is not free, return false
                //checking from bottom (currentY) to up (moveY)
                for (int i = currentY+1; i < moveY; i++) {
                    if (!getPiece(currentX,i).match(emptySpace)) {
                        return false;
                    }
                }
            //if Rook is moving south/down  
            } else if (currentX == moveX && currentY > moveY) {
                //check pathway along Y coordinate for free space, if any is not free, return false
                //checking from bottom (moveY) to up (currentY)
                for (int i = moveY+1; i < currentY; i++) {
                    if (!getPiece(currentX,i).match(emptySpace)) {
                        return false;
                    }
                }
            //if Rook is moving east/right
            } else if (currentX < moveX && currentY == moveY) {
                //check pathway along X coordinate for free space, if any is not free, return false
                //checking from left (currentX) to right (moveX)
                for (int i = currentX+1; i < moveX; i++) {
                    if (!getPiece(i,currentY).match(emptySpace)) {
                        return false;
                    }
                }
            //if Rook is moving west/left    
            } else if (currentX > moveX && currentY == moveY) {
                //check pathway along X coordinate for free space, if any is not free, return false
                //checking from left (moveX) to right (currentX)
                for (int i = moveX+1; i < currentX; i++) {
                    if (!getPiece(i,currentY).match(emptySpace)) {
                        return false;
                    }
                }
            }
    	//if current chess piece is a Pawn	
    	} else if (c.getChessValue().equals("p")) {
    		//only need to check if the pawn is moving two spaces (first move)
    		//if distance between current y coordinate and destination's y coordinate is 2 (meaning pawn's first move)
    		if (Math.abs(currentY - moveY) == 2) {
    			//check if the space in between is an emptySpace (because the destination has already been checked)
    			//X Coordinate should be the same for currentX and moveX. just need space between currentY and moveY, as in, the MEAN
    			if (!getPiece(currentX,((currentY + moveY)/2)).match(emptySpace)) {
    				return false;
    			}
    		}
    	//if current chess piece is a Queen 	
    	} else if (c.getChessValue().equals("Q")) {
    		//first check in which direction is the Queen piece moving (this is a combination of Rook and Bishop moves)
            //need to check for loop with i+1 so as to not check current/destination coordinates (destination coordinates already checked)
            //if Queen is moving north/up 
            if (currentX == moveX && currentY < moveY) {
                //check pathway along Y coordinate for free space, if any is not free, return false
                //checking from bottom (currentY) to up (moveY)
                for (int i = currentY+1; i < moveY; i++) {
                    if (!getPiece(currentX,i).match(emptySpace)) {
                        return false;
                    }
                }
            //if Queen is moving south/down  
            } else if (currentX == moveX && currentY > moveY) {
                //check pathway along Y coordinate for free space, if any is not free, return false
                //checking from bottom (moveY) to up (currentY)
                for (int i = moveY+1; i < currentY; i++) {
                    if (!getPiece(currentX,i).match(emptySpace)) {
                        return false;
                    }
                }
            //if Queen is moving east/right
            } else if (currentX < moveX && currentY == moveY) {
                //check pathway along X coordinate for free space, if any is not free, return false
                //checking from left (currentX) to right (moveX)
                for (int i = currentX+1; i < moveX; i++) {
                    if (!getPiece(i,currentY).match(emptySpace)) {
                        return false;
                    }
                }
            //if Queen is moving west/left    
            } else if (currentX > moveX && currentY == moveY) {
                //check pathway along X coordinate for free space, if any is not free, return false
                //checking from left (moveX) to right (currentX)
                for (int i = moveX+1; i < currentX; i++) {
                    if (!getPiece(i,currentY).match(emptySpace)) {
                        return false;
                    }
                }
            //need to check for loop with i = 1 so as to not check current/destination coordinates (destination coordinates already checked)
            //if Queen is moving northeast (diagonal top right)
            } else if (currentX < moveX && currentY < moveY) {
                //check pathway along diagonal; if any space is not free, return false
                for (int i = 1; i < moveX; i++) {
                    if (!getPiece(currentX+i,currentY+i).match(emptySpace)) {
                        return false;
                    }
                }
            //if Queen is moving southeast (diagonal lower right)    
            } else if (currentX < moveX && currentY > moveY) {
                //check pathway along diagonal; if any space is not free, return false
                for (int i = 1; i < moveX; i++) {
                    if (!getPiece(currentX+i,currentY-i).match(emptySpace)) {
                        return false;
                    }
                }
            //if Queen is moving southwest (diagonal lower left)    
            } else if (currentX > moveX && currentY > moveY) {
                //check pathway along diagonal; if any space is not free, return false
                for (int i = 1; i < moveX; i++) {
                    if (!getPiece(currentX-i,currentY-i).match(emptySpace)) {
                        return false;
                    }
                }
            //if Queen is moving northwest (diagonal top left)     
            } else if (currentX > moveX && currentY < moveY) {
                //check pathway along diagonal; if any space is not free, return false
                for (int i = 1; i < moveX; i++) {
                    if (!getPiece(currentX-i,currentY+i).match(emptySpace)) {
                        return false;
                    }
                }
            }
    	}
    	//NOTE: if current chess piece is a Knight, King, or Pawn:
   	    	//Knight pieces can jump over other chess pieces, so no need to check pathway, only destination
    		//King usually only move one space, so only need to check destination as well
    		//Pawns also can only move one space unless on their first move (2 spaces); hence only need to check destination and 2-space moves

    	//if all these checks are passed, then destination and pathway must be valid/free; return true   	
    	return true;
    }


}