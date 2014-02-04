package com.ogaclejapan.webmvc;


/**
 * トースト通知のタイプ値
 * @author ogaclejapan
 * 
 */
public enum ToastType {
	
	Success, 
	Info, 
	Warning, 
	Error;
	
	public String code() {
		return name().toLowerCase();
	}
	
}
