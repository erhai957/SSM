package com.hqyj.JWSystem.system.model;

import java.util.Date;

public class Permission {
    private Integer permissionId;

    private String pId;

    private String name;

    private String type;

    private String url;

    private String percode;

    private String available;

    private Date createTime;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPercode() {
        return percode;
    }

    public void setPercode(String percode) {
        this.percode = percode;
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
		return "Permission [permissionId=" + permissionId + ", pId=" + pId + ", name=" + name + ", type=" + type
				+ ", url=" + url + ", percode=" + percode + ", available=" + available + ", createTime=" + createTime
				+ "]";
	}

	public Permission(Integer permissionId, String pId, String name, String type, String url, String percode,
			String available, Date createTime) {
		super();
		this.permissionId = permissionId;
		this.pId = pId;
		this.name = name;
		this.type = type;
		this.url = url;
		this.percode = percode;
		this.available = available;
		this.createTime = createTime;
	}

	public Permission() {
		super();
	}
    
}