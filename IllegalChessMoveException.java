public class IllegalChessMoveException extends Exception {

	//exception for illegal chess piece movements -- such as a pawn moving diagonally or sideways
	
	//sets up illegal chess move message with given message
	IllegalChessMoveException(String message) {
		super(message);
	}

}