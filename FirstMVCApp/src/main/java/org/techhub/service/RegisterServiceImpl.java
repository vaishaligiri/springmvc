package org.techhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.techhub.model.Register;
import org.techhub.repository.RegisterRepository;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	RegisterRepository registerRepository;

	@Override
	public boolean isRegister(Register register) {
		// TODO Auto-generated method stub
		if(register.getName()!=null && register.getEmail()!=null && register.getContact()!=null)
		{
			return registerRepository.isRegister(register);
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public List<Register> getAllRecords() {
		// TODO Auto-generated method stub
		
		return registerRepository.getAllRecords();
	}

	@Override
	public List<Register> getUserByName(String name) {
		// TODO Auto-generated method stub
		return registerRepository.searchByName(name);
	}

	@Override
	public boolean isDeleteRecord(int userid) {
		// TODO Auto-generated method stub
		return registerRepository.isDeleteRecord(userid);
	}

}
