package jp.co.ino.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ino.boot.common.CommonConst;
import jp.co.ino.boot.common.Message;
import jp.co.ino.boot.dao.entity.Users;
import jp.co.ino.boot.services.DEV001Service;
import jp.co.ino.boot.services.DEV003Service;

/**
 * コントローラークラス
 */
@Controller
public class AppController {

	/** ログインサービス */
	@Autowired
	DEV001Service dev001Service;

	/** 検索サービス */
	@Autowired
	DEV003Service dev003Service;

	/**
	 * ログイン 初期表示
	 * 
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = CommonConst.INDEX_PASS, method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {

		try {
			// ログイン画面へ遷移
			return dev001Service.init(mav);
		} catch (Exception e) {
			// 例外発生の場合
			return error();
		}
	}

	/**
	 * ログイン処理
	 * 
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = CommonConst.INDEX_PASS, method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute(CommonConst.FORM_MODEL) Users users, ModelAndView mav) {

		try {
			// ログイン画面へ遷移
			return dev001Service.login(users, mav);
		} catch (Exception e) {
			// 例外発生の場合
			return error();
		}
	}

	/**
	 * 検索画面 初期表示
	 * 
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = CommonConst.MAIN_PASS, params = CommonConst.SEARCH_PARAM, method = RequestMethod.GET)
	public ModelAndView searchInit(ModelAndView mav) {

		try {
			// 検索画面へ遷移
			return dev003Service.init(mav);
		} catch (Exception e) {
			// 例外発生の場合
			return error();
		}
	}

	/**
	 * ログアウト処理
	 * 
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = CommonConst.MAIN_PASS, params = CommonConst.LOGOUT_PARAM, method = RequestMethod.GET)
	public ModelAndView logout(ModelAndView mav) {

		try {
			// ログアウト
			return this.index(mav);
		} catch (Exception e) {
			// 例外発生の場合
			return error();
		}
	}

	/**
	 * エラー共通処理
	 * 
	 * @return
	 */
	public ModelAndView error() {

		// 初期化
		ModelAndView mav = new ModelAndView();

		// システムエラーメッセージ設定
		mav.addObject("msg", Message.SYS_ERROR);
		mav.setViewName(CommonConst.VIEW_NAME_INDEX);
		// ログイン画面へ遷移
		return mav;
	}

}
