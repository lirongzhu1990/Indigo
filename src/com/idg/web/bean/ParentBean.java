package com.idg.web.bean;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class ParentBean {
	
	public ParentBean(){
		
		this.setCreateUser(null);
		this.setCreateDate(null);
		this.setModifyUser(null);
		this.setModifyDate(null);
	}
	
	@Column(name="CREATEUSER",length=32)
	private String createUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATEDATE",length=32)
	private Date createDate;
	
	@Column(name="MODIFYUSER",length=32)
	private String modifyUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MODIFYDATE",length=32)
	private Date modifyDate;

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		
		this.createDate = Calendar.getInstance().getTime();
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate =  Calendar.getInstance().getTime();;
	}
}
