package com.cloud.hotel.model.system;

public class Receptionist extends Users {
 private long maNhanVien;

 public long getMaNhanVien() {
	return maNhanVien;
}

public void setMaNhanVien(long maNhanVien) {
	this.maNhanVien = maNhanVien;
}

public String getCaTruc() {
	return caTruc;
}

public void setCaTruc(String caTruc) {
	this.caTruc = caTruc;
}

private String caTruc;
 
}
