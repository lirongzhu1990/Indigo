package com.idg.web.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.idg.web.untils.MD5;

@Entity
@Table(name="IDG_USER")
public class User extends ParentBean{

	@Id
	@Column(name="ID",length=32)
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;
	
	@Column(length=30,name="NAME")
	private String name;

	@Column(length=100,name="ADDRESS")
	private String address;
	
	@Column(name="AGE")
	private int age;
	
	@Column(length=32,name="PASSWORD")
	private String password;
	
	@Column(length=30,name="EMAIL")
	private String email;
	
	@Column(length=30,name="ALIAS")
	private String alias;
	
	@Column(length=100,name="IMAGEURL")
	private String imageUrl;
	
	@Column(name="ISACTIVE",nullable=false)
	private int isActive;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password){
		
		this.password = MD5.EncoderByMd5(password);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String toCookie(){
		
		return this.name + ";" + this.password;
	}
}
