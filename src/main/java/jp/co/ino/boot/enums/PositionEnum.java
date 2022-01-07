package jp.co.ino.boot.enums;

public enum PositionEnum {

	社員("01"), サブリーダー("02"), リーダー("03"), マネージャー("04");

	private String id;

	private PositionEnum(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
