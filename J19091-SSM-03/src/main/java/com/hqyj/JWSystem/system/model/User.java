package com.hqyj.JWSystem.system.model;

public class User {
    private Integer id;

    private String name;

    private String account;

    private String password;

    private String salt;

    private String locked;

    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", account=" + account + ", password=" + password + ", salt="
				+ salt + ", locked=" + locked + ", createTime=" + createTime + "]";
	}

	public User(Integer id, String name, String account, String password, String salt, String locked,
			String createTime) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.password = password;
		this.salt = salt;
		this.locked = locked;
		this.createTime = createTime;
	}

	public User() {
		super();
	}
    
}