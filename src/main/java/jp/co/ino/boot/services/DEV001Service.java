package jp.co.ino.boot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ino.boot.common.CommonConst;
import jp.co.ino.boot.common.CommonLogic;
import jp.co.ino.boot.common.Message;
import jp.co.ino.boot.dao.entity.Users;
import jp.co.ino.boot.repositories.UsersRepository;

@Service(value = "DEV001Service")
@Transactional
public class DEV001Service {

	/** ログイン情報リポジトリー */
	@Autowired
	UsersRepository usersRepository;

	/** 共通ロジック */
	CommonLogic clg = new CommonLogic();

	/**
	 * ログイン画面初期表示
	 * 
	 * @param mav
	 * @return
	 */
	public ModelAndView init(ModelAndView mav) {

		// 空のメッセージ
		mav.addObject("msg", CommonConst.EMPTY);
		mav.addObject(CommonConst.FORM_MODEL, new Users());
		mav.setViewName(CommonConst.VIEW_NAME_INDEX);

		// ログイン画面へ遷移
		return mav;
	}

	/**
	 * ログインロジック
	 * 
	 * @param users
	 * @param mav
	 * @return
	 */
	public ModelAndView login(Users users, ModelAndView mav) {

		String id = users.getId();
		String password = users.getPassword();

		// 未入力チェック
		if (this.clg.isEmpty(id) || this.clg.isEmpty(password)) {
			// 未入力エラーダイアログ設定
			mav.addObject("msg", Message.LOGIN_NOT_ENTERED);
			mav.setViewName(CommonConst.VIEW_NAME_INDEX);
			return mav;
		}

		Optional<Users> getUsers = usersRepository.findById(users.getId());

		if (getUsers.isPresent()) {

			mav.setViewName(CommonConst.VIEW_NAME_MAIN);
		} else {

			mav.addObject("msg", Message.LOGIN_MISS);
			mav.setViewName(CommonConst.VIEW_NAME_INDEX);
		}

		return mav;
	}

}
