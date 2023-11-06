package com.mindgate.main.domain;

import java.util.Objects;

public class LoginDetails {

	private int loginId;
	private String userName;
	private String password;
	private String role;
	private int loginCount;
	private boolean loginStatus;

	public LoginDetails() {
		// TODO Auto-generated constructor stub
	}

	public LoginDetails(int loginId, String userName, String password, String role, int loginCount,
			boolean loginStatus) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.loginCount = loginCount;
		this.loginStatus = loginStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(loginCount, loginId, loginStatus, password, role, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDetails other = (LoginDetails) obj;
		return loginCount == other.loginCount && loginId == other.loginId && loginStatus == other.loginStatus
				&& Objects.equals(password, other.password) && Objects.equals(role, other.role)
				&& Objects.equals(userName, other.userName);
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public boolean isLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}

	@Override
	public String toString() {
		return "LoginDetails [loginId=" + loginId + ", userName=" + userName + ", password=" + password + ", role="
				+ role + ", loginCount=" + loginCount + ", loginStatus=" + loginStatus + "]";
	}

}
