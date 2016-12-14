package com.kaishengit.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class DbHelp {
	private static Connection getConnerction(){
		return ConnectionManager.getConnection();
	}
		
	public static void update(String sql,Object... params){
		Connection connection = getConnerction();
		
		try {
			QueryRunner queryRunner = new QueryRunner();
			queryRunner.update(connection, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(connection);
		}
	}
	
	public static <T> T query(String sql,ResultSetHandler<T> handler,Object... params){
		
		Connection connection = getConnerction();
		
		try {
			QueryRunner queryRunner = new QueryRunner();
			T t = queryRunner.query(connection, sql, handler, params);
			return t;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(connection);
		}
		return null;	
	}

	private static void close(Connection connection) {
		
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
