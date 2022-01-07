package jp.co.ino.boot.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "employee_info")
public class EmployeeInfo {

	@Column(name = "no")
	private String no;

	@Id
	@Column(name = "employee_id")
	private String employeeId;

	@Column(name = "company_info_id")
	private String companyInfoId;

	@Column(name = "department")
	private String department;

	@Column(name = "position")
	private String position;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "name_kana", length = 50, nullable = false)
	private String nameKana;

	@Column(name = "birthday", nullable = false)
	private String birthday;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "mail_address", length = 200)
	private String mailAddress;

	@Column(name = "telephone_number", nullable = false)
	private String telephoneNumber;

	@Column(name = "boss", nullable = false)
	private String boss;

	@Column(name = "regist_date")
	private Date registDate;

	@Column(name = "update_date")
	private Date updateDate;

	@Column(name = "delete_flg")
	private String deleteFlg;

}
