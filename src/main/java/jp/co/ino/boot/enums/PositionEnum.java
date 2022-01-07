package jp.co.ino.boot.enums;

public enum PositionEnum {

	POS01("01", "社員"), POS02("02", "サブリーダー"), POS03("03", "リーダー"), POS04("04", "マネージャー");

	private String id;
	private String value;

	private PositionEnum(String id, String value) {
		this.id = id;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

}
