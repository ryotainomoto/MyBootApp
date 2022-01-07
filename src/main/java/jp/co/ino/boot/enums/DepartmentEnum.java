package jp.co.ino.boot.enums;

public enum DepartmentEnum {

	開発("01"), インフラ("02"), 検証("03");

	private String id;

	private DepartmentEnum(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
