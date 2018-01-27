package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "order", catalog = "mypham")
public class RstOrderDto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer orderId;
	private String name;
	private String email;
	private String adress;
	private String phone;
	private String totalPrice;
	private Date orderDate;
	public RstOrderDto() {
	}

	public RstOrderDto(String name, String email, String adress, String phone, String totalPrice, Date orderDate) {
		this.name = name;
		this.email = email;
		this.adress = adress;
		this.phone = phone;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "OrderID", unique = true, nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "Name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Adress", nullable = false, length = 80)
	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Column(name = "Phone", nullable = false, length = 3)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "TotalPrice", nullable = false, length = 4)
	public String getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OrderDate", nullable = false, length = 19)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}
