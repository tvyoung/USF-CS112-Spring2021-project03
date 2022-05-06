public class Queen extends ChessPiece {

	public Queen() {
		chessValue = "Q";
	}

	//moves any amount of spaces in any direction 
	//combination of a Rook and a Bishop's possible moves
	@Override
	public boolean move(int x, int y) {
		//checks if moving forward/backward
		//if the given x coordinate is the same as the Queen's current x coordinate, returns true
		if (x == xCoordinate) {
			return true;
		//checks if moving sideways
		//if the given y coordinate is the same as the Queen's current y coordinate, returns true
		} else if (y == yCoordinate) {
			return true;
		}
		//checks if moving diagonally
		//if the distance between Queen's current X coordinate and destination X coordinate
		//is the same as the distance between Queen's current Y coordinate and destination Y coordinate
		//then return true
		if (Math.abs(xCoordinate-x) == Math.abs(yCoordinate-y)) {
			return true;
		}
		//if no given coordinates match a possible move, returns false
		return false;
	
		//EDIT: ignore this. old method. 
		//checks if moving diagonally in any direction
		//as a increments, checks further and further away from Queens's current position
		//NOTE: assumes board size of 8
		/*for (int a = 1; a <= 8; a++) {
			//diagonally forward right
			if (x == xCoordinate+a && y == yCoordinate+a) {
				return true;
			//diagonally backward right
			} else if (x == xCoordinate+a && y == yCoordinate-a) {
				return true;
			//diagonally forward left
			} else if (x == xCoordinate-a && y == yCoordinate+a) {
				return true;
			//diagonally backward left
			} else if (x == xCoordinate-a && y==yCoordinate-a) {
				return true;
			}
		}*/
	}

	@Override
	public String toString() {
		return "QUEEN";
	}
}