public class Knight extends ChessPiece {

	public Knight() {
		chessValue = "h";
	}
	
	//jumps in an L-shaped pattern
	@Override
	public boolean move(int x, int y) {
		//checks all eight possible L-shape moves a knight can make. i dont really know how to explain this cause i had to draw a graph . . .

		//RIGHT SIDE
		//if given x and y coordinates match the Knight's L-shape move to the forward upper right, returns true  
		if (x == xCoordinate+1 && y == yCoordinate+2) {
			return true;
		//if given x and y coordinates match the Knight's L-shape move to the forward lower right, returns true
		} else if (x == xCoordinate+2 && y == yCoordinate+1) {
			return true;
		//if given x and y coordinates match the Knight's L-shape move to the backward upper right, returns true
		} else if (x == xCoordinate+2 && y == yCoordinate-1) {
			return true;
		//if given x and y coordinates match the Knight's L-shape move to the backward lower right, returns true
		} else if (x == xCoordinate+1 && y == yCoordinate-2) {
			return true;
		//LEFT SIDE
		//if given x and y coordinates match the Knight's L-shape move to the forward upper left, returns true
		} else if (x == xCoordinate-1 && y == yCoordinate+2) {
			return true;
		//if given x and y coordinates match the Knight's L-shape move to the forward lower left, returns true
		} else if (x == xCoordinate-2 && y == yCoordinate+1) {
			return true;
		//if given x and y coordinates match the Knight's L-shape move to the backward upper left, returns true
		} else if (x == xCoordinate-2 && y == yCoordinate-1) {
			return true;
		//if given x and y coordinates match the Knight's L-shape move to the backward lower left, returns true
		} else if (x == xCoordinate-1 && y == yCoordinate-2) {
			return true;
		} 
		//if the given destination coordinates do not match any valid L-shape move, returns false 
		return false;
	}

	//knight is denoted as "h" to avoid confusion with the presence of a king
	@Override
	public String toString() {
		return "KNIGHT";
	}

}