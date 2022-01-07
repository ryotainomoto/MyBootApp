package jp.co.ino.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jp.co.ino.boot.dao.entity.Users;

@Repository(value = "UsersRepository")
public interface UsersRepository extends JpaRepository<Users, String> {

	@Query(value = "select * from dev.users where id = ?1 and password = ?2 ", nativeQuery = true)
	public Users findOne(String id, String password);

}
