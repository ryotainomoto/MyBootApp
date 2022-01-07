package jp.co.ino.boot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jp.co.ino.boot.dao.entity.EmployeeInfo;

@Repository(value = "EmployeeInfoRepository")
public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, String> {

	@Override
	@Query(value = "select * from dev.employee_info where delete_flg = '0' ", nativeQuery = true)
	public List<EmployeeInfo> findAll();

	@Query(value = "select * from dev.employee_info where employee_id = ?1 and delete_flg = '0' ", nativeQuery = true)
	public EmployeeInfo findOne(String employeeId);

}
