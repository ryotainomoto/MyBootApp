package jp.co.ino.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.ino.boot.dao.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

}
