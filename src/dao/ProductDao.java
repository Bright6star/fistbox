package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.tribes.transport.RxTaskPool;

import com.oracle.jrockit.jfr.Producer;

import dto.Product;
import dto.Type;
import dto.User;
import dto.noice;
import uitls.ConnectionManager;
import uitls.PageModel;

public class ProductDao {

	private Connection conn = null;
	PreparedStatement ps = null;
	
	//
	public  List<Product> getProducts(Integer typeId) {
		boolean flag = false;
		StringBuilder sql = new StringBuilder("select * from product where publishStatus = 1 ");

		if (typeId != null) {
			sql.append(" and product_typeId = ? ");
			flag = true;
		}
		sql.append(" ORDER BY publishDate DESC");
		conn = ConnectionManager.getConnection();
		List<Product> productlist = new ArrayList<>();
		try {
			if (flag) {
				ps.setInt(1, typeId);
			}
			ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setProduct_voltage(rs.getString("product_voltage"));
				product.setProduct_power(rs.getString("product_power"));
				product.setProduct_water(rs.getString("product_water"));
				product.setProduct_pressure(rs.getString("product_pressure"));
				product.setProduct_shell(rs.getString("product_shell"));
				product.setProduct_capacity(rs.getString("product_capacity"));
				product.setContent(rs.getString("content"));
				product.setProduct_url(rs.getString("product_url"));
				product.setCreateDate(rs.getDate("createDate"));
				product.setPublishDate(rs.getDate("publishDate"));
				product.setPublishStatus(rs.getInt("publishStatus"));
				Type type = new Type();
				type.setId(rs.getInt("product_typeId"));
				product.setType(type);

				User user = new User();
				user.setId(rs.getInt("userId"));
				product.setUser(user);
				productlist.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productlist;
	}
	//根据id获取单条记录
	public Product getProduct(int id) {
		conn = ConnectionManager.getConnection();
		String select = "select * from product where product_id = ? ";
		Product product = null;
		try {
			ps = conn.prepareStatement(select);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				product = new Product();
				product.setId(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setProduct_voltage(rs.getString("product_voltage"));
				product.setProduct_power(rs.getString("product_power"));
				product.setProduct_water(rs.getString("product_water"));
				product.setProduct_pressure(rs.getString("product_pressure"));
				product.setProduct_shell(rs.getString("product_shell"));
				product.setProduct_capacity(rs.getString("product_capacity"));
				product.setContent(rs.getString("content"));
				product.setProduct_url(rs.getString("product_url"));
				product.setCreateDate(rs.getDate("createDate"));
				product.setPublishDate(rs.getDate("publishDate"));
				product.setPublishStatus(rs.getInt("publishStatus"));
				Type type = new Type();
				type.setId(rs.getInt("product_typeId"));
				product.setType(type);

				User user = new User();
				user.setId(rs.getInt("userId"));
				product.setUser(user);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	//查询所有已发布的产品信息
	public List<Product> getProductPublish(String product_name,PageModel pageModel1) throws SQLException{
		boolean flag = false;
		StringBuilder sql = new StringBuilder(" select * from product where publishStatus = 1 ORDER BY publishDate DESC");
//
//		if (product_name != null && !"".equals(product_name)) {
//			sql.append(" where product_name like ? ");
//			flag = true;
//		}
		pageModel1.setPageSize(9);
		sql.append(" limit ?,?");
		conn = ConnectionManager.getConnection();
		ps = conn.prepareStatement(sql.toString());

		int cursor = 1;
//		if (flag) {
//			ps.setString(cursor++, "%" + product_name + "%");
//		}
		ps.setInt(cursor++, pageModel1.getStarRow());
		ps.setInt(cursor++, pageModel1.getPageSize());
		ResultSet rs = ps.executeQuery();
		List<Product> productslist = new ArrayList<>();


		while (rs.next()) {
			Product product = new Product();
			product.setId(rs.getInt("product_id"));
			product.setProduct_name(rs.getString("product_name"));
			product.setProduct_voltage(rs.getString("product_voltage"));
			product.setProduct_power(rs.getString("product_power"));
			product.setProduct_water(rs.getString("product_water"));
			product.setProduct_pressure(rs.getString("product_pressure"));
			product.setProduct_shell(rs.getString("product_shell"));
			product.setProduct_capacity("product_capacity");
			product.setContent(rs.getString("content"));
			product.setProduct_url(rs.getString("product_url"));
			product.setCreateDate(rs.getDate("createDate"));
			product.setPublishDate(rs.getDate("publishDate"));
			product.setPublishStatus(rs.getInt("publishStatus"));

			Type type = new Type();
			type.setId(rs.getInt("product_typeId"));
			product.setType(type);

			User user = new User();
			user.setId(rs.getInt("userId"));
			product.setUser(user);
			if (productslist.add(product)) {
			}

		}

		return productslist;
	}
	//设置后台产品分页和所有信息
	public List<Product> getProductByPage(String product_name, PageModel pageModel1) throws SQLException {
		boolean flag = false;
		StringBuilder sql = new StringBuilder(" select * from product ");

		if (product_name != null && !"".equals(product_name)) {
			sql.append(" where product_name like ? ");
			flag = true;
		}
		sql.append(" limit ?,?");
		conn = ConnectionManager.getConnection();
		ps = conn.prepareStatement(sql.toString());

		int cursor = 1;
		if (flag) {
			ps.setString(cursor++, "%" + product_name + "%");
		}
		ps.setInt(cursor++, pageModel1.getStarRow());
		ps.setInt(cursor++, pageModel1.getPageSize());
		ResultSet rs = ps.executeQuery();
		List<Product> productslist = new ArrayList<>();


		while (rs.next()) {
			Product product = new Product();
			product.setId(rs.getInt("product_id"));
			product.setProduct_name(rs.getString("product_name"));
			product.setProduct_voltage(rs.getString("product_voltage"));
			product.setProduct_power(rs.getString("product_power"));
			product.setProduct_water(rs.getString("product_water"));
			product.setProduct_pressure(rs.getString("product_pressure"));
			product.setProduct_shell(rs.getString("product_shell"));
			product.setProduct_capacity("product_capacity");
			product.setContent(rs.getString("content"));
			product.setProduct_url(rs.getString("product_url"));
			product.setCreateDate(rs.getDate("createDate"));
			product.setPublishDate(rs.getDate("publishDate"));
			product.setPublishStatus(rs.getInt("publishStatus"));

			Type type = new Type();
			type.setId(rs.getInt("product_typeId"));
			product.setType(type);

			User user = new User();
			user.setId(rs.getInt("userId"));
			product.setUser(user);
			if (productslist.add(product)) {
//				System.out.println("************");
			}

		}

		return productslist;
	}
	//查询所有已发布的产品信息
	public int countPublish(String product_name) throws SQLException {
//		boolean flag = false;
		StringBuilder sql = new StringBuilder(" select count(*) from product where publishStatus = 1");

//		if (product_name != null && !"".equals(product_name)) {
//			sql.append(" where product_name like ? ");
//			flag = true;
//		}

		conn = ConnectionManager.getConnection();
		ps = conn.prepareStatement(sql.toString());
//		if (flag) {
//			ps.setString(1, "%" + product_name + "%");
//		}

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
		} else {
			return 0;
		}
	}
	//后台所有的产品信息
	public int count(String product_name) throws SQLException {
		boolean flag = false;
		StringBuilder sql = new StringBuilder(" select count(*) from product ");

		if (product_name != null && !"".equals(product_name)) {
			sql.append(" where product_name like ? ");
			flag = true;
		}

		conn = ConnectionManager.getConnection();
		ps = conn.prepareStatement(sql.toString());
		if (flag) {
			ps.setString(1, "%" + product_name + "%");
		}

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
		} else {
			return 0;
		}
	}
	//删除方法
	public int delete(int id) {
		conn = ConnectionManager.getConnection();
		int count = 0;
		String delete = "delete from product where product_id = ?";
		try {
			ps = conn.prepareStatement(delete);
			ps.setInt(1, id);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	//添加方法
	public int save(Product product) {

		int count = 0;
		conn = ConnectionManager.getConnection();

		String insert = "insert into product(product_name,product_voltage,product_power,"
				+ "product_water,product_pressure,product_shell,product_capacity,"
				+ "content,product_url,product_typeId,userId) values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(insert);
			ps.setString(1, product.getProduct_name());
			ps.setString(2, product.getProduct_voltage());
			ps.setString(3, product.getProduct_power());
			ps.setString(4, product.getProduct_water());
			ps.setString(5, product.getProduct_pressure());
			ps.setString(6, product.getProduct_shell());
			ps.setString(7, product.getProduct_capacity());
			ps.setString(8, product.getContent());
			ps.setString(9, product.getProduct_url());
			ps.setInt(10, product.getType().getId());
			ps.setInt(11, product.getUser().getId());

			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int publishUpdate(String[] ids, int userId) throws SQLException {
		StringBuilder sql = new StringBuilder("update product set publishStatus = ? , ");
		sql.append("publishDate = ?,userId = ? where product_id in (");
		List<Object> params = new ArrayList<>();
		// 绑定需要的数据
		params.add(1);
		params.add(new Date());
		params.add(userId);
		// 数组有多少个就循环多个ID
		for (int i = 0; i < ids.length; i++) {
			sql.append(i == 0 ? "?" : ", ?");
			params.add(Integer.valueOf(ids[i]));
		}

		sql.append(");");
		conn = ConnectionManager.getConnection();
		try {
			ps = conn.prepareStatement(sql.toString());

			for (int i = 0; i < params.size(); i++) {
				ps.setObject(i + 1, params.get(i));
			}

		} catch (Exception e) {

		}

		return ps.executeUpdate();
	}
	//更新方法
	public int update(Product product) {
		conn = ConnectionManager.getConnection();
		int count = 0;
		String update = "update product set product_name = ? ,product_voltage = ? ,"
				+ "product_power = ? ,product_water = ? ,product_pressure = ? ,"
				+ "product_shell = ? ,product_capacity = ? ,content = ? ,product_url = ? ,"
				+ "product_typeId = ? where product_id = ?";
		try {
			ps = conn.prepareStatement(update);
			ps.setString(1, product.getProduct_name());
			ps.setString(2, product.getProduct_voltage());
			ps.setString(3, product.getProduct_power());
			ps.setString(4, product.getProduct_water());
			ps.setString(5, product.getProduct_pressure());
			ps.setString(6, product.getProduct_shell());
			ps.setString(7, product.getProduct_capacity());
			ps.setString(8, product.getContent());
			ps.setString(9, product.getProduct_url());
			ps.setInt(10, product.getType().getId());
			ps.setInt(11, product.getId());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
