package com.chenrui.pattern.template;

import javax.jws.soap.SOAPBinding;
import java.sql.ResultSet;
import java.util.List;

public class UserDao {
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(null);

	public List<?> getUserList(){
		String sql ="select * from t_user";
		List<?> userlist =  jdbcTemplate.executeQuery(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws Exception {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				return user;
			}
		},null);
		return userlist;
	}
}
