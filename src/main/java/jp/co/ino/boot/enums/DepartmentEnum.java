package jp.co.ino.boot.enums;

public enum DepartmentEnum {

	DEP01("01", "開発"), DEP02("02", "インフラ"), DEP03("03", "検証");

	private String id;
	private String value;

	private DepartmentEnum(String id, String value) {
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
