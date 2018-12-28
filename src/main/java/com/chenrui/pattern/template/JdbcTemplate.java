package com.chenrui.pattern.template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
	private DataSource dataSource;

	public JdbcTemplate(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values){
		try{
			//1、获取连接
			Connection conn = this.createConnection();
			//2、创建语句集
			PreparedStatement pstmt = this.createPreparedStatement(conn,sql);
			//3、执行语句集，获取结果集
			ResultSet rs = this.execute(pstmt,values);
			//4、解析结果集
			List<?> rsList = this.parseResultSet(rs,rowMapper);
			//5、关闭语句集
			closeStatement(pstmt);
			//6、关闭连接
			closeConn(conn);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	private void closeConn(Connection conn)throws Exception  {
		if(null != conn){
			conn.close();
		}
	}

	private void closeStatement(PreparedStatement pstmt)throws Exception {
		//连接放入连接池
		/*if(null != pstmt){
			pstmt.close();
		}*/
	}

	private List<?> parseResultSet(ResultSet rs, RowMapper<?> rowMapper)throws Exception {
		List<Object> result = new ArrayList();
		int rowNum = 1;
		while (rs.next()){
			result.add(rowMapper.mapRow(rs,rowNum++));
		}
		return result;
	}

	private ResultSet execute(PreparedStatement pstmt, Object[] values)throws Exception {
		for(int i=0;i<values.length;i++){
			pstmt.setObject(i,values[i]);
		}
		return pstmt.executeQuery();
	}

	private PreparedStatement createPreparedStatement(Connection conn, String sql)throws Exception {
		return conn.prepareStatement(sql);
	}

	private Connection createConnection() throws Exception{
		return this.dataSource.getConnection();
	}
}
