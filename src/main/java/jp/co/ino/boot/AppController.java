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

@Controller
public class AppController {

	/** ログインサービス */
	@Autowired
	DEV001Service dev001Service;

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

	@RequestMapping(value = "edit", params = "goToTop", method = RequestMethod.POST)
	public ModelAndView main() {

		return null;
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
