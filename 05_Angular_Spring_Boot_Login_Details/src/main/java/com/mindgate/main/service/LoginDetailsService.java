package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.LoginDetails;
import com.mindgate.main.repository.LoginDetailsRepositoryInterface;

@Service
public class LoginDetailsService implements LoginDetailsServiceInterface {

	@Autowired
	private LoginDetailsRepositoryInterface loginDetailsRepositoryInterface;

	@Override
	public List<LoginDetails> getAllLogin() {
		return loginDetailsRepositoryInterface.getAllLogin();
	}

	@Override
	public LoginDetails updateLoginDetails(LoginDetails details) {
		return loginDetailsRepositoryInterface.updateLoginDetails(details);
	}

	@Override
	public LoginDetails getLoginDetailsByLoginId(LoginDetails details) {
		LoginDetails existingLoginDetails = loginDetailsRepositoryInterface.getLoginDetailsByLoginId(details);
		if (existingLoginDetails.getLoginCount() <= 3 && existingLoginDetails.isLoginStatus()
				&& details.getPassword().equals(existingLoginDetails.getPassword())) {
			existingLoginDetails.setPassword("");
			return existingLoginDetails;
		} else {
			if (existingLoginDetails.getLoginCount() < 2) {
				existingLoginDetails.setLoginCount(existingLoginDetails.getLoginCount() + 1);
				updateLoginDetails(existingLoginDetails);
				existingLoginDetails.setPassword("");
				existingLoginDetails.setRole("");
				existingLoginDetails.setUserName("");
				return existingLoginDetails;
			} else {
				existingLoginDetails.setLoginCount(existingLoginDetails.getLoginCount() + 1);
				existingLoginDetails.setLoginStatus(false);
				updateLoginDetails(existingLoginDetails);
				existingLoginDetails.setPassword("");
				existingLoginDetails.setRole("");
				existingLoginDetails.setUserName("");
				return existingLoginDetails;
			}
		}

	}

}
