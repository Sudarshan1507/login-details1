package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.LoginDetails;

public interface LoginDetailsServiceInterface {

	public LoginDetails getLoginDetailsByLoginId(LoginDetails details);

	public List<LoginDetails> getAllLogin();

	public LoginDetails updateLoginDetails(LoginDetails details);
}
