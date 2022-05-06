public class OutOfBoardException extends Exception {

	//exception for a move whose destination is outside the playing board
	
	//sets up out of board exception message with given message
	OutOfBoardException(String message) {
		super(message);
	}
}