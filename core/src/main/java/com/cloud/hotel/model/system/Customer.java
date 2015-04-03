package com.cloud.hotel.model.system;

public class Customer extends Users {
	public long getMaBenhNhan() {
		return maBenhNhan;
	}
	public void setMaBenhNhan(long maBenhNhan) {
		this.maBenhNhan = maBenhNhan;
	}
	public boolean isTaiKham() {
		return taiKham;
	}
	public void setTaiKham(boolean taiKham) {
		this.taiKham = taiKham;
	}
	private long maBenhNhan;
	private boolean taiKham;
}
