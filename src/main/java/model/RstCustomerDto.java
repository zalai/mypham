package model;
// default package
// Generated Feb 4, 2018 3:01:45 PM by Hibernate Tools 5.1.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "customer", catalog = "mypham")
public class RstCustomerDto implements java.io.Serializable {

	private Integer customerId;
	private String name;
	private String email;
	private String phone;
	private String pwd;
	private boolean state;
	private Set<RstOrderDto> orderDtos;

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "CustomerID", unique = true, nullable = false)
	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column(name = "Name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Email", nullable = false, length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Phone", nullable = false, length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "PWD", nullable = false, length = 10)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "State", nullable = false)
	public boolean isState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customerDto")
	public Set<RstOrderDto> getOrderDtos() {
		return orderDtos;
	}

	public void setOrderDtos(Set<RstOrderDto> orderDtos) {
		this.orderDtos = orderDtos;
	}

}
