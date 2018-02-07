package model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Sanpham generated by hbm2java
 */
@Entity
@Table(name = "PRODUCT", catalog = "mypham")
public class RstProductDto implements java.io.Serializable {

	private static final long serialVersionUID = -832366475349641125L;
	private Integer maSp;
	@JsonIgnore
	private RstProducTypeDto rstProducTypeDto;
	private String tenSp;
	private String moTa;
	private String noiSx;
	private Date ngayNhap;
	private String mauSac;
	private String hinh;
	private double giaGoc;
	private double giaBan;
	private int soLuong;
	private boolean uuTien;
	private boolean remove;

	public RstProductDto(Integer maSp, String tenSp, String moTa, String noiSx, String mauSac, String hinh, double giaBan) {
		this.maSp = maSp;
		this.tenSp = tenSp;
		this.moTa = moTa;
		this.noiSx = noiSx;
		this.mauSac = mauSac;
		this.hinh = hinh;
		this.giaBan = giaBan;
	}

	public RstProductDto() {
		
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "MaSP", unique = true, nullable = false)
	public Integer getMaSp() {
		return this.maSp;
	}

	public void setMaSp(Integer maSp) {
		this.maSp = maSp;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MaLoai", nullable = false)
	public RstProducTypeDto getRstProducTypeDto() {
		return rstProducTypeDto;
	}

	public void setRstProducTypeDto(RstProducTypeDto rstProducTypeDto) {
		this.rstProducTypeDto = rstProducTypeDto;
	}

	@Column(name = "TenSP", nullable = false, length = 300)
	public String getTenSp() {
		return this.tenSp;
	}

	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}

	@Column(name = "MoTa", nullable = false, length = 200)
	public String getMoTa() {
		return this.moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Column(name = "NoiSX", nullable = false, length = 100)
	public String getNoiSx() {
		return this.noiSx;
	}

	public void setNoiSx(String noiSx) {
		this.noiSx = noiSx;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "NgayNhap", nullable = false, length = 19)
	public Date getNgayNhap() {
		return this.ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	@Column(name = "MauSac", nullable = false, length = 200)
	public String getMauSac() {
		return this.mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	@Column(name = "Hinh", nullable = false, length = 200)
	public String getHinh() {
		return this.hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	@Column(name = "GiaGoc", nullable = false, precision = 22, scale = 0)
	public double getGiaGoc() {
		return this.giaGoc;
	}

	public void setGiaGoc(double giaGoc) {
		this.giaGoc = giaGoc;
	}

	@Column(name = "GiaBan", nullable = false, precision = 22, scale = 0)
	public double getGiaBan() {
		return this.giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	@Column(name = "SoLuong", nullable = false)
	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Column(name = "UuTien", nullable = false)
	public boolean isUuTien() {
		return this.uuTien;
	}

	public void setUuTien(boolean uuTien) {
		this.uuTien = uuTien;
	}

	@Column(name = "REMOVE", nullable = false)
	public boolean isRemove() {
		return this.remove;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}
}
