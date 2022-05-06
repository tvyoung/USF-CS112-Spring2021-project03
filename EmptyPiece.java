public class EmptyPiece extends ChessPiece
{
	public EmptyPiece() {
		chessValue = "-";
	}

	@Override
	public boolean move(int x, int y) {
		return true;
	}

	@Override
	public String toString() {
		return "EMPTY";
	}
}