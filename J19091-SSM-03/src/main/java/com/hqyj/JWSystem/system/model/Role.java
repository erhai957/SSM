package com.hqyj.JWSystem.system.model;

import java.util.Date;

public class Role {
    private Integer roleId;

    private String roleName;

    private String available;

    private Date createTime;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", available=" + available + ", createTime="
				+ createTime + "]";
	}

	public Role(Integer roleId, String roleName, String available, Date createTime) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.available = available;
		this.createTime = createTime;
	}

	public Role() {
		super();
	}
    
}