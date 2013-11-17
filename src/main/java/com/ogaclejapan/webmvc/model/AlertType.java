package com.ogaclejapan.webmvc.model;

import com.ogaclejapan.webmvc.builder.ModelBuilder;

/**
 * アラート通知のタイプ値
 * @author ogaclejapan
 * @see ModelBuilder
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
