package service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import model.RstUserDto;
import prmDto.PrmUserDeleteUserDto;
import prmDto.PrmUserDto;
import prmDto.PrmUserShowUserInfoDto;

@Service("userService")
public class UserService {
	public Map<Integer, RstUserDto> userMap = new HashMap<Integer, RstUserDto>();

	public Map<Integer, RstUserDto> getAllUser(){

		// For fist request
		if (CollectionUtils.isEmpty(userMap)) {
				
			RstUserDto rst01Dto = new RstUserDto();
			rst01Dto.setId(1);
			rst01Dto.setName("Nguyen Van Qui");
			rst01Dto.setEmail("zalai1992@gmail.com");
			rst01Dto.setNewsletter(true);
			rst01Dto.setFramework(Arrays.asList("Spring MVC", "JSF 2"));
			rst01Dto.setSex("Male");
			rst01Dto.setNumber(3);
			rst01Dto.setCountry("Viet Nam");
			rst01Dto.setSkill(Arrays.asList("Hibernate", "Groovy"));
	
			userMap.put(rst01Dto.getId(),rst01Dto);
	
			RstUserDto rst02Dto = new RstUserDto();
			rst02Dto.setId(2);
			rst02Dto.setName("Nguyen Van Dai");
			rst02Dto.setEmail("dainguyen1994@gmail.com");
			rst02Dto.setFramework(Arrays.asList("Apache Wicket", "linkQ"));
			rst02Dto.setSex("Male");
			rst02Dto.setNumber(4);
			rst02Dto.setCountry("Viet Nam");
			rst02Dto.setSkill(Arrays.asList("Grails", "Struts"));
			
			userMap.put(rst02Dto.getId(),rst02Dto);
		}

		return userMap;
	}

	public RstUserDto getUserInfo(PrmUserShowUserInfoDto prmUserDto) {

		return userMap.get(prmUserDto.userId);
	}

	public void deleteUser(PrmUserDeleteUserDto prmUserDeleteUserDto) {

		userMap.remove(prmUserDeleteUserDto.id);

	}

	public void saveOrUpdate(PrmUserDto prmUserDto) {

		if (prmUserDto.isNew()) {

			Double squence = Math.random()*100;
			prmUserDto.setId(squence.intValue());

			insertUser(prmUserDto);
		} else {

			updateUser(prmUserDto);
		}
	}

	private void insertUser(PrmUserDto prmUserDto) {
		RstUserDto rstUserDto = new RstUserDto();

		BeanUtils.copyProperties(prmUserDto, rstUserDto);
		userMap.put(prmUserDto.getId(), rstUserDto);

	}

	private void updateUser(PrmUserDto prmUserDto) {

		RstUserDto rstUserDto = userMap.get(prmUserDto.getId());
		BeanUtils.copyProperties(prmUserDto, rstUserDto);
	}
}
