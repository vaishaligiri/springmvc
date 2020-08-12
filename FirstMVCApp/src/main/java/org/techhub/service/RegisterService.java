package org.techhub.service;

import java.util.List;

import org.techhub.model.Register;

public interface RegisterService {

	 public boolean isRegister(Register register);
	 public List<Register> getAllRecords();
	 public List<Register> getUserByName(String name);
	 public boolean isDeleteRecord(int userid);
}
