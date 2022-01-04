package jp.co.ino.boot.dao;

import java.io.Serializable;

import jp.co.ino.boot.dao.entity.Users;

public interface UsersDao<T> extends Serializable {
	public Users getOne();
}
