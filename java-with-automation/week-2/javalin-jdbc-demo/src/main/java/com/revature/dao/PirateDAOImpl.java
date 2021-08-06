package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Pirate;
import com.revature.util.ConnectionUtility;

public class PirateDAOImpl implements PirateDAO {

	@Override
	public List<Pirate> getAllPiratesFromShip(int shipId) throws SQLException {
		try(Connection con = ConnectionUtility.getConnection()) {
			List<Pirate> pirates = new ArrayList<>();
			
			String sql = "SELECT * FROM jdbc_demo.pirate p WHERE p.ship_id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, shipId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				Pirate p = new Pirate(id, name, age);
				pirates.add(p);
			}
			
			return pirates;
		}
	}

}
