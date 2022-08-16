package com.lockerfacility.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="locker")
public class Locker {
	@Id
	private int lockerId;
	private String lockerType;
	private double rent;
	public Locker(int lockerId, String lockerType, double rent) {
		super();
		this.lockerId = lockerId;
		this.lockerType = lockerType;
		this.rent = rent;
	}
	public Locker() {
		super();
	}
	public int getLockerId() {
		return lockerId;
	}
	public void setLockerId(int lockerId) {
		this.lockerId = lockerId;
	}
	public String getLockerType() {
		return lockerType;
	}
	public void setLockerType(String lockerType) {
		this.lockerType = lockerType;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	@Override
	public String toString() {
		return "Locker [lockerId=" + lockerId + ", lockerType=" + lockerType + ", rent=" + rent + "]";
	}
	
	
}
