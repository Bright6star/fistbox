package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.Type;
import dto.User;
import uitls.ConnectionManager;

public class TypeDao {

	private Connection conn = null;
	PreparedStatement ps = null;
	// 获取公告类型的id和名字

	public List<Type> getTypes(Integer typeId) {
		Type type = null;
		List<Type> typeList = new ArrayList<>();
		conn = ConnectionManager.getConnection();
		StringBuilder selectSQL = new StringBuilder("select * from type ");
		boolean flag = false;
		if (typeId != null) {
			selectSQL.append(" where id = ?");
			flag = true;
		}
		try {
			ps = conn.prepareStatement(selectSQL.toString());
			if (flag) {
				ps.setInt(1, typeId);
			}
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// 获取列数据
				type = new Type();
				type.setId(rs.getInt("id"));
				type.setName(rs.getString("name"));
				typeList.add(type);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return typeList;
	}
	//获取产品类型的id和名字
	public List<Type> getProductTypes(Integer typeId) {
		Type type = null;
		List<Type> typeList = new ArrayList<>();
		conn = ConnectionManager.getConnection();
		StringBuilder selectSQL = new StringBuilder("select * from pro_type ");
		boolean flag = false;
		if (typeId != null) {
			selectSQL.append(" where id = ?");
			flag = true;
		}
		try {
			ps = conn.prepareStatement(selectSQL.toString());
			if (flag) {
				ps.setInt(1, typeId);
			}
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// 获取列数据
				type = new Type();
				type.setId(rs.getInt("id"));
				type.setName(rs.getString("name"));
				typeList.add(type);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return typeList;
	}
}
