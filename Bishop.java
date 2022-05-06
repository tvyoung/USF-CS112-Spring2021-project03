public class Bishop extends ChessPiece {

	public Bishop() {
		chessValue = "b";
	}
	
	//moves diagonally
	@Override
	public boolean move(int x, int y) {
		//if the distance between current X coordinate and destination X coordinate
		//is the same as the distance between current Y coordinate and destination Y coordinate
		//then return true
		if (Math.abs(xCoordinate-x) == Math.abs(yCoordinate-y)) {
			return true;
		}
		//if given coordinates do not match a possible diagonal move, returns false
		return false;

		//EDIT: Changed method. Ignore this. 
		//loops to check if given coordinates match a possible diagonal move
		//as a increments, checks further and further away from Bishop's current position
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
		return "BISHOP";
	}	

}