package com.ltf.exception;

import java.text.MessageFormat;

/**
 * @author dreamneverdie
 *
 */
public class ParamException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParamException() {
		super();
	}

	public ParamException(String message) {
		super(message);
	}

	public ParamException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParamException(Throwable cause) {
		super(cause);
	}

	protected ParamException(String message, Throwable cause, 
							 boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	@Override
	public Throwable fillInStackTrace() {
		return this;
	}

	@Override
	public String toString() {
		return MessageFormat.format("{0}[{1}]", "生日", "格式错误");
	}
}
