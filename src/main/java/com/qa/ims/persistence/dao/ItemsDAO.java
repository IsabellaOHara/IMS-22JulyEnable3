package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAO implements Dao<Items>{

	
	public Items itemsFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		String itemName = resultSet.getString("item_name");
		double price = resultSet.getDouble("price");
		return new Items(id, itemName, price);
	}
	
	// reads all the items in the database
	@Override
	public List<Items> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items");) {
			List<Items> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(itemsFromResultSet(resultSet));
			}
			return items;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}	
	
	//read latest method
	public Items readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return itemsFromResultSet(resultSet);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//CREATE
	@Override
	public Items create(Items items) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO items(item_name, price) VALUES (?, ?)");) {
			statement.setString(1, items.getItemName());
			statement.setDouble(2, items.getPrice());
			statement.executeUpdate();
			return readLatest();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//READ BY ID
	@Override
	public Items read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return itemsFromResultSet(resultSet);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Items update(Items t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Items modelFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
