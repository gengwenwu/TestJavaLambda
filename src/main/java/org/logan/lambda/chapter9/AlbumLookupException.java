package org.logan.lambda.chapter9;

/**
 * desc:  <br/>
 * time: 2020/6/28 6:06 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class AlbumLookupException extends RuntimeException {

	public AlbumLookupException(Throwable cause) {
		super(cause);
	}

	public AlbumLookupException(String message) {
		super(message);
	}

}