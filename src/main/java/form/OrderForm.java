package form;

import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

import enums.Constant;

public class OrderForm {


	@NotNull
	private String name;

	@Email(regexp = Constant.PATTERN_EMAIL)
	private String email;

	@Pattern(regexp = "(\\w*\\d\\w*)")
	private String address;

	@NotNull
	private String province;

	@NotNull
	private String district;

	@NotNull
	private String village;

	@Pattern(regexp = Constant.PATTERN_PHONE)
	private String phone;

	private Map<String, String> provinceList;;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Map<String, String> getProvinceList() {
		return provinceList;
	}
}
