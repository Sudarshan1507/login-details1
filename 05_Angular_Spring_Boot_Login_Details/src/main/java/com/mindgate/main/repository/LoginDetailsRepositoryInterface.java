package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.LoginDetails;

public interface LoginDetailsRepositoryInterface {

	public LoginDetails getLoginDetailsByLoginId(LoginDetails details);

	public List<LoginDetails> getAllLogin();

	public LoginDetails updateLoginDetails(LoginDetails details);
	
	public List<LoginDetails> getInActiveUser();
}
