package jp.co.ino.boot.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ino.boot.common.CommonConst;
import jp.co.ino.boot.common.CommonLogic;
import jp.co.ino.boot.dao.entity.EmployeeInfo;
import jp.co.ino.boot.enums.DepartmentEnum;
import jp.co.ino.boot.enums.GenderEnum;
import jp.co.ino.boot.enums.PositionEnum;
import jp.co.ino.boot.repositories.CompanyInfoRepository;
import jp.co.ino.boot.repositories.EmployeeInfoRepository;

@Service(value = "DEV003Service")
@Transactional
public class DEV003Service {

	/** 社員情報リポジトリー */
	@Autowired
	EmployeeInfoRepository employeeInfoRepository;

	/** 会社情報リポジトリー */
	@Autowired
	CompanyInfoRepository companyInfoRepository;

	/** 共通ロジック */
	CommonLogic clg = new CommonLogic();

	public ModelAndView init(ModelAndView mav) throws ParseException {

		List<EmployeeInfo> employeeList = employeeInfoRepository.findAll();

		if (employeeList != null) {

			for (EmployeeInfo emp : employeeList) {

				// 会社名を設定
				String companyName = companyInfoRepository.findOne(emp.getCompanyInfoId()).getCompanyName();
				emp.setCompanyInfoId(companyName);

				// 事業部名称を設定
				DepartmentEnum department = Stream.of(DepartmentEnum.values())
						.filter(e -> e.getId().equals(emp.getDepartment())).findFirst().get();
				emp.setDepartment(department.toString());

				// 職位名称を設定
				PositionEnum position = Stream.of(PositionEnum.values())
						.filter(e -> e.getId().equals(emp.getPosition())).findFirst().get();
				emp.setPosition(position.toString());

				// 誕生日を設定
				emp.setBirthday(clg.editBirthday(emp.getBirthday()));

				// 性別を設定
				GenderEnum gender = Stream.of(GenderEnum.values()).filter(e -> e.getId().equals(emp.getGender()))
						.findFirst().get();
				emp.setGender(gender.toString());
			}

		} else {
			employeeList = new ArrayList<EmployeeInfo>();
		}

		mav.addObject("datalist", employeeList);
		mav.setViewName(CommonConst.VIEW_NAME_SEARCH);

		return mav;
	}

}
