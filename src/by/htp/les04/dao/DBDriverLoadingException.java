package by.htp.les04.dao;

public class DBDriverLoadingException extends RuntimeException {
	
	private static final long serialVersionUID = 2959604665040103915L;

	public DBDriverLoadingException() {
		super();
	}
	
	public DBDriverLoadingException(String message) {
		super(message);
	}
	
	public DBDriverLoadingException(Exception e) {
		super(e);
	}
	
	public DBDriverLoadingException(String message, Exception e) {
		super(message, e);
	}
	
	
	

}
