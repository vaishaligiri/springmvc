package org.techhub.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.techhub.model.Register;

@Repository("registerRepository")
public class RegisterRepositoryImpl implements RegisterRepository {

	@Autowired
	JdbcTemplate template;

	private List<Register> regList;

	@Override
	public boolean isRegister(Register register) {
		// TODO Auto-generated method stub
		int value = template.update("insert into springmvcreg values('0',?,?,?)", new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, register.getName());
				ps.setString(2, register.getEmail());
				ps.setString(3, register.getContact());

			}

		});
		if (value > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<Register> getAllRecords() {
		// TODO Auto-generated method stub
		regList = template.query("select *from springmvcreg", new RowMapper() {

			@Override
			public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Register r = new Register();
				r.setId(rs.getInt(1));
				r.setName(rs.getString(2));
				r.setEmail(rs.getString(3));
				r.setContact(rs.getString(4));
				return r;
			}

		});
		return regList;
	}

	@Override
	public List<Register> searchByName(String name) {
		// TODO Auto-generated method stub
		regList = template.query("select *from springmvcreg where name like '%" + name + "%'",
				new RowMapper<Register>() {

					@Override
					public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						Register r = new Register();
						r.setId(rs.getInt(1));
						r.setName(rs.getString(2));
						r.setEmail(rs.getString(3));
						r.setContact(rs.getString(4));
						return r;
					}

				});
		return regList;
	}

	@Override
	public boolean isDeleteRecord(int userid) {
		// TODO Auto-generated method stub
		int value = template.update("delete from springmvcreg where regid=?", new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, userid);

			}

		});
		if (value > 0) {
			return true;
		} else {
			return false;
		}
	}

}
