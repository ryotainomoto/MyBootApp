package jp.co.ino.boot.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import jp.co.ino.boot.dao.UsersDao;
import jp.co.ino.boot.dao.entity.Users;

@Repository
public class UsersDaoImpl implements UsersDao<Users> {

	private EntityManager entityManager;

	public UsersDaoImpl() {
		super();
	}

	public UsersDaoImpl(EntityManager manager) {
		this();
		entityManager = manager;
	}

	@Override
	public Users getOne() {
		return null;
	}

}
