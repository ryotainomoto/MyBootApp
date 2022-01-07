package jp.co.ino.boot.enums;

public enum GenderEnum {

	男("1"), 女("2");

	private String id;

	private GenderEnum(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
