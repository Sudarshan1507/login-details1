package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.LoginDetails;

@Repository
public class LoginDetailsRepository implements LoginDetailsRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SELECT_ONE_LOGINDETAIL = "select * from login_details_spring_boot where login_id=?";
	private final String SELECT_ALL_LOGINDETAILS = "select login_id,user_name,password,role,login_count,login_status from login_details_spring_boot";
	private final String SELECT_ALL_IN_ACTIVE_USER = "select * from login_details_spring_boot where login_status='false'";
	private final String UPDATE_LOGIN_DETAILS = "update login_details_spring_boot set user_name=?,password=?,role=?,login_count=?,login_status=? where login_id=? ";

	@Override
	public List<LoginDetails> getAllLogin() {
		LoginDetailsRowMapper loginDetailsRowMapper = new LoginDetailsRowMapper();
		return jdbcTemplate.query(SELECT_ALL_LOGINDETAILS, loginDetailsRowMapper);
	}

	@Override
	public LoginDetails getLoginDetailsByLoginId(LoginDetails details) {
		LoginDetailsRowMapper loginDetailsRowMapper = new LoginDetailsRowMapper();
		return jdbcTemplate.queryForObject(SELECT_ONE_LOGINDETAIL, loginDetailsRowMapper, details.getLoginId());
	}

	@Override
	public LoginDetails updateLoginDetails(LoginDetails details) {
		Object[] parameters = { details.getUserName(), details.getPassword(), details.getRole(),
				details.getLoginCount(), details.isLoginStatus(), details.getLoginId() };
		int rowCount = jdbcTemplate.update(UPDATE_LOGIN_DETAILS, parameters);
		if (rowCount > 0)
			return getLoginDetailsByLoginId(details);
		return null;
	}

	@Override
	public List<LoginDetails> getInActiveUser() {
		LoginDetailsRowMapper loginDetailsRowMapper = new LoginDetailsRowMapper();
		return jdbcTemplate.query(SELECT_ALL_IN_ACTIVE_USER, loginDetailsRowMapper);
	}

}
