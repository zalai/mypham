package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail", catalog = "mypham")
public class RstOrderDetailDetail implements java.io.Serializable {

	private static final long serialVersionUID = -863889139570259913L;
	private Integer id;
	private int maSp;
	private double gia;
	private int soLuong;
	private double thanhTien;
	private int orderId;

	public RstOrderDetailDetail() {
	}

	public RstOrderDetailDetail(int maSp, double gia, int soLuong, double thanhTien, int orderId) {
		this.maSp = maSp;
		this.gia = gia;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
		this.orderId = orderId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "MaSP", nullable = false)
	public int getMaSp() {
		return this.maSp;
	}

	public void setMaSp(int maSp) {
		this.maSp = maSp;
	}

	@Column(name = "Gia", nullable = false, precision = 22, scale = 0)
	public double getGia() {
		return this.gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	@Column(name = "SoLuong", nullable = false)
	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Column(name = "ThanhTien", nullable = false, precision = 22, scale = 0)
	public double getThanhTien() {
		return this.thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Column(name = "OrderID", nullable = false)
	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
