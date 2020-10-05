package sk.po.spse.beachclubapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class HomePlayer extends Player 
{
	@Column(nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String registrationNumber;
	
	private boolean isRightHanded;
	
	@Column(nullable = false)
	private String clothesSize;

	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public boolean isRightHanded() {
		return isRightHanded;
	}
	public void setRightHanded(boolean isRightHanded) {
		this.isRightHanded = isRightHanded;
	}
	public String getClothesSize() {
		return clothesSize;
	}
	public void setClothesSize(String clothesSize) {
		this.clothesSize = clothesSize;
	}
	
	@Override
	public String toString() {
		return "HomePlayer [phone=" + phone + ", email=" + email + ", address=" + address + ", registrationNumber="
				+ registrationNumber + ", isRightHanded=" + isRightHanded + ", clothesSize=" + clothesSize + "]";
	}
	
	
}
