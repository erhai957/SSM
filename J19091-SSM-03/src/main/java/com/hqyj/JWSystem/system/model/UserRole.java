package com.hqyj.JWSystem.system.model;

public class UserRole {
    private Integer userRoleId;

    private Integer userId;

    private Integer roleId;

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userId=" + userId + ", roleId=" + roleId + "]";
	}

	public UserRole(Integer userRoleId, Integer userId, Integer roleId) {
		super();
		this.userRoleId = userRoleId;
		this.userId = userId;
		this.roleId = roleId;
	}

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}