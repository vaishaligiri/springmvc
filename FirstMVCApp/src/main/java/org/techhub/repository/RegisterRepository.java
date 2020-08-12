package org.techhub.repository;

import java.util.List;

import org.techhub.model.Register;

public interface RegisterRepository {

	public boolean isRegister(Register register);
	public List<Register> getAllRecords();
	public List<Register> searchByName(String name);
	public boolean isDeleteRecord(int userid);
}
