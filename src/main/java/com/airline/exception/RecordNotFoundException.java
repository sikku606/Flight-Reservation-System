package com.airline.exception;

public class RecordNotFoundException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1976326412130607547L;
	private String resouceName;
	private String id;
	private long bookingId;
	
	public RecordNotFoundException(String resouceName, String id, long bookingId) {
		super(String.format("%s not found with %s : %s", resouceName, id, bookingId));
		this.resouceName = resouceName;
		this.id = id;
		this.bookingId = bookingId;
	}

	
}
