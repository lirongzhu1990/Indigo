package com.idg.web.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.idg.web.untils.ConstantEnum;

@Entity
@Table(name="IDG_MENU")
public class Menu extends ParentBean{

	@Id
	@Column(name="ID",length=32)
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;
	
	@Column(length=30,name="NAME")
	private String name;
	
	@Column(length=30,name="IMAGE_NAME")
	private String imageName;
	
	@Column(length=100,name="IMAGE_URL")
	private String imageUrl;
	
	@Column(length=10,name="BACKGROUND_COLOR")
	private String backGroundColor;
	
	@Column(length=100,name="ACTION_URL")
	private String actionUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getBackGroundColor() {
		return backGroundColor;
	}

	public void setBackGroundColor(String backGroundColor) {
		this.backGroundColor = backGroundColor;
	}

	public String getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl() {
		this.imageUrl = "./" + ConstantEnum.COVER_IMAGE_FOLDER.toString() + imageName;
	}
}
