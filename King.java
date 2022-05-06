public class King extends ChessPiece {

	public King() {
		chessValue = "K";
	}

	//moves one space in any direction
	@Override
	public boolean move(int x, int y) {
		//if the distance between given X coordinate and current X coordinate is 1 (absolute value),
		//and if the distance between given Y coordinate and current Y coordinate is 1 (absolute value), returns true
		if (Math.abs(xCoordinate - x) <= 1 && Math.abs(yCoordinate - y) <= 1) {
			return true;
		}
		//otherwise returns false
		return false;
	}

	@Override
	public String toString() {
		return "KING";
	}
}