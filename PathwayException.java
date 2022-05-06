public class PathwayException extends Exception {

	//exception for illegal move if there is another chess piece on the way - either at the destination coordinate or in the path to the destination coordinate
	//note: does not include Knight pieces
	
	//sets up illegal chess move message with given message
	PathwayException(String message) {
		super(message);
	}

}