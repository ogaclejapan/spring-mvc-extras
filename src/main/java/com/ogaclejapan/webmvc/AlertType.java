package com.ogaclejapan.webmvc;


/**
 * アラート通知のタイプ値
 * @author ogaclejapan
 */
public enum AlertType {
	
	Success, 
	Info, 
	Warning, 
	Error;
	
	public String code() {
		return name().toLowerCase();
	}

}
