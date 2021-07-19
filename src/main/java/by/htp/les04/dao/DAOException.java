package by.htp.les04.dao;

public class DAOException extends Exception {

	private static final long serialVersionUID = -1639479230915612837L;

	public DAOException() {
		super();
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Exception e) {
		super(e);
	}

	public DAOException(String message, Exception e) {
		super(message, e);
	}
}
