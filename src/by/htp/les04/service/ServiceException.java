package by.htp.les04.service;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 8718291206260578838L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String message, Exception e) {
		super(message, e);
	}
}
