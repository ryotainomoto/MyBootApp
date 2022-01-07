package jp.co.ino.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jp.co.ino.boot.dao.entity.CompanyInfo;

@Repository(value = "CompanyInfoRepository")
public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, String> {

	@Query(value = "select * from dev.company_info where company_id = ?1 and delete_flg = '0' ", nativeQuery = true)
	public CompanyInfo findOne(String companyId);

}
