package jp.co.ino.boot.common;

public class CommonLogic {

	/**
	 * 空文字チェック
	 * 
	 * @param target
	 * @return
	 */
	public boolean isEmpty(String target) {

		if (target == null) {
			return true;
		} else if (target.replaceAll(" ", "").replaceAll("　", "").isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 空文字チェック
	 * 
	 * @param target
	 * @return
	 */
	public boolean isNotEmpty(String target) {

		if (target == null) {
			return false;
		} else if (target.replaceAll(" ", "").replaceAll("　", "").isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * 引数の文字列が数字であるかのチェック
	 * 
	 * @param num
	 * @return true=数字である. false=数字ではない
	 */
	public boolean isNumber(String num) {
		try {
			// 数字型に変換
			Integer.parseInt(num);
			// 出来ればtrue
			return true;
		} catch (NumberFormatException e) {
			// 出来なければfalse
			return false;
		}
	}

	/**
	 * 引数の文字列が数字であるかのチェック
	 * 
	 * @param num
	 * @return true=数字でない. false=数字である
	 */
	public boolean isNotNumber(String num) {
		try {
			// 数字型に変換
			Integer.parseInt(num);
			// 出来ればfalse
			return false;
		} catch (NumberFormatException e) {
			// 出来なければtrue
			return true;
		}
	}

}
