package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.*;

public class OrderDaoImpl implements OrderDao {
	@Inject
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public int createOrder(Order order) {
		String sql = "INSERT INTO order_details " + "(order_detail_id, order_id) VALUES (?,?)";
		Connection connection = null;
		int result ;
		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, order.getOrderDetailId());
			preparedStatement.setInt(2, order.getOrderId());
			result = preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}
	@Override
	public int deleteAll() {
		String sql = "delete from  order_details";
		Connection connection = null;
		int result ;
		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}

}
