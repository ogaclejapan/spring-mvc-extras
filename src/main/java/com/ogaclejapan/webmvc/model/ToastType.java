package com.ogaclejapan.webmvc.model;

import com.ogaclejapan.webmvc.builder.ModelBuilder;

/**
 * トースト通知のタイプ値
 * @author ogaclejapan
 * @see ModelBuilder
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
