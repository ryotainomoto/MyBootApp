package jp.co.ino.boot.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	/**
	 * 生年月日 年齢計算メソッド
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public String editBirthday(String birthday) throws ParseException {

		if (birthday != null) {

			// データフォーマット
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

			// birthdayをDate型変換
			Date formatBirth = sdf.parse(birthday);

			// 現在の日付を取得
			Date now = new Date();

			// 年齢計算 (現日付(yyyyMMdd) - 生年月日(yyyyMMdd) ÷ 10000 )
			int BeforeAge = (Integer.parseInt(sdf.format(now)) - Integer.parseInt(sdf.format(formatBirth))) / 10000;

			// 数字型年齢(BeforeAge)を文字列型(age)に変換
			String age = String.valueOf(BeforeAge);

			// 年齢計算後の文字列型 年齢を返す
			return age;

		} else {
			return null;// 処理なし
		}
	}

}
