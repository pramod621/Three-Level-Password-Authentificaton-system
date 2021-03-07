package com.example.ThreeLevelPassAuthSystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_USER")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name="firstpass")
	private String fpass;
	@Column(name="secondpass")
	private String spass;
	@Column(name="thirdpass")
	private String tpass;
	@Column(name="user_name")
	private String userName;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFpass() {
		return fpass;
	}
	public void setFpass(String fpass) {
		this.fpass = fpass;
	}
	public String getSpass() {
		return spass;
	}
	public void setSpass(String spass) {
		this.spass = spass;
	}
	public String getTpass() {
		return tpass;
	}
	public void setTpass(String tpass) {
		this.tpass = tpass;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", fpass=" + fpass + ", spass=" + spass + ", tpass=" + tpass + ", userName="
				+ userName + "]";
	}
	
	
	
}
