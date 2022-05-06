public abstract class ChessPiece {

	//instance data all chess pieces have
	protected String chessValue;
	protected int xCoordinate;
	protected int yCoordinate; 

	//set X coordinate
	public void setXCoordinate(int givenX) {
		xCoordinate = givenX;
	}

	//get X coordinate
	public int getXCoordinate() {
		return xCoordinate;
	}

	//set Y coordinate
	public void setYCoordinate(int givenY) {
		yCoordinate = givenY;
	}

	//get Y coordinate
	public int getYCoordinate() {
		return yCoordinate;
	}

	//set both X and Y coordinates, as in, set position of the ChessPiece
	public void setCoordinates(int givenX, int givenY) {
		xCoordinate = givenX;
		yCoordinate = givenY;		
	}

	//get both X and Y coordinates, as in, get the position of the ChessPiece
	public String getCoordinates() {
		String text = "(" + xCoordinate + "," + yCoordinate + ")";
		return text;
	}

	public String getChessValue() {
		return chessValue;
	}

	//compares the chessValues of two pieces
	//returns true if they match, false if they do not match
    public boolean match(ChessPiece other)
    {
        return this.chessValue.equals(other.chessValue);
    }

	//all the chess pieces move in different ways, declare an abstract method called move
	//method returns true or false depending on if the move is valid or not
	public abstract boolean move(int x, int y);

	public abstract String toString();


} 