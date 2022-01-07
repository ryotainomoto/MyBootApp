package jp.co.ino.boot.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "company_info")
public class CompanyInfo {

	@Id
	@Column(name = "company_id")
	private String companyId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "abbreviation")
	private String abbreviation;

	@Column(name = "regist_date")
	private Date registDate;

	@Column(name = "update_date")
	private Date updateDate;

	@Column(name = "delete_flg")
	private String deleteFlg;

}
