package com.calculator.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Menu implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String name;
	@Column
	private Integer orderId;
	@Column
	private String imagePath;
	@Column
	private boolean active;
	@Column
	private boolean mainTemplate = false;
	@OneToMany(mappedBy="menu", cascade=CascadeType.ALL)
	private List<Node> pages = new ArrayList<Node>();	
		
	public Menu(){}
	
	@Transient
	private boolean editMode = false;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public List<Node> getPages() {
		return pages;
	}
	public void setPages(List<Node> pages) {
		this.pages = pages;
	}
	
	public boolean isEditMode() {
		return editMode;
	}
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isMainTemplate() {
		return mainTemplate;
	}
	public void setMainTemplate(boolean mainTemplate) {
		this.mainTemplate = mainTemplate;
	}
	
}
