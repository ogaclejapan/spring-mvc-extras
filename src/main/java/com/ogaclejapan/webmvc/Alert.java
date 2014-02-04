package com.ogaclejapan.webmvc;

/**
 * アラート通知情報をモデルとして返却するためのクラス
 * @author ogaclejapan
 *
 */
public class Alert {

	private final String message;
	private final String title;
	private final AlertType type;

	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public Alert(String message, String title, AlertType type) {
		this.message = message;
		this.title = title;
		this.type = type;
	}
	
	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	public String getMessage() {
		return message;
	}

	public String getTitle() {
		return title;
	}

	public AlertType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alert other = (Alert) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Alert [message=");
		builder.append(message);
		builder.append(", title=");
		builder.append(title);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}
	

}
