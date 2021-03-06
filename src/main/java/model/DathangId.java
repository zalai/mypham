package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DathangId generated by hbm2java
 */
@Embeddable
public class DathangId implements java.io.Serializable {

	private String tenKhach;
	private String diaChi;
	private String sdt;
	private String maKv;
	private String maSp;
	private int soLuong;
	private Date ngayDat;

	public DathangId() {
	}

	public DathangId(String tenKhach, String diaChi, String sdt, String maKv, String maSp, int soLuong, Date ngayDat) {
		this.tenKhach = tenKhach;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.maKv = maKv;
		this.maSp = maSp;
		this.soLuong = soLuong;
		this.ngayDat = ngayDat;
	}

	@Column(name = "TenKhach", nullable = false, length = 150)
	public String getTenKhach() {
		return this.tenKhach;
	}

	public void setTenKhach(String tenKhach) {
		this.tenKhach = tenKhach;
	}

	@Column(name = "DiaChi", nullable = false, length = 300)
	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Column(name = "SDT", nullable = false, length = 11)
	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	@Column(name = "MaKV", nullable = false, length = 3)
	public String getMaKv() {
		return this.maKv;
	}

	public void setMaKv(String maKv) {
		this.maKv = maKv;
	}

	@Column(name = "MaSP", nullable = false, length = 4)
	public String getMaSp() {
		return this.maSp;
	}

	public void setMaSp(String maSp) {
		this.maSp = maSp;
	}

	@Column(name = "SoLuong", nullable = false)
	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Column(name = "NgayDat", nullable = false, length = 19)
	public Date getNgayDat() {
		return this.ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DathangId))
			return false;
		DathangId castOther = (DathangId) other;

		return ((this.getTenKhach() == castOther.getTenKhach()) || (this.getTenKhach() != null
				&& castOther.getTenKhach() != null && this.getTenKhach().equals(castOther.getTenKhach())))
				&& ((this.getDiaChi() == castOther.getDiaChi()) || (this.getDiaChi() != null
						&& castOther.getDiaChi() != null && this.getDiaChi().equals(castOther.getDiaChi())))
				&& ((this.getSdt() == castOther.getSdt()) || (this.getSdt() != null && castOther.getSdt() != null
						&& this.getSdt().equals(castOther.getSdt())))
				&& ((this.getMaKv() == castOther.getMaKv()) || (this.getMaKv() != null && castOther.getMaKv() != null
						&& this.getMaKv().equals(castOther.getMaKv())))
				&& ((this.getMaSp() == castOther.getMaSp()) || (this.getMaSp() != null && castOther.getMaSp() != null
						&& this.getMaSp().equals(castOther.getMaSp())))
				&& (this.getSoLuong() == castOther.getSoLuong())
				&& ((this.getNgayDat() == castOther.getNgayDat()) || (this.getNgayDat() != null
						&& castOther.getNgayDat() != null && this.getNgayDat().equals(castOther.getNgayDat())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTenKhach() == null ? 0 : this.getTenKhach().hashCode());
		result = 37 * result + (getDiaChi() == null ? 0 : this.getDiaChi().hashCode());
		result = 37 * result + (getSdt() == null ? 0 : this.getSdt().hashCode());
		result = 37 * result + (getMaKv() == null ? 0 : this.getMaKv().hashCode());
		result = 37 * result + (getMaSp() == null ? 0 : this.getMaSp().hashCode());
		result = 37 * result + this.getSoLuong();
		result = 37 * result + (getNgayDat() == null ? 0 : this.getNgayDat().hashCode());
		return result;
	}

}
