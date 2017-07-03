package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Product;
import dto.Type;
import dto.noice;
import dto.User;
import uitls.ConnectionManager;
import uitls.PageModel;

public class NoticeDao {

	private Connection conn = null;
	PreparedStatement ps = null;
	//查询公告的总数
	public int count(String product_name) throws SQLException {
		boolean flag = false;
		StringBuilder sql = new StringBuilder("select count(*) from notice");

		if (product_name != null && !"".equals(product_name)) {
			sql.append(" where title like ?");
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
	//查询公告的发布总数
	public int countPublish(String product_name) throws SQLException {
//		boolean flag = false;
		StringBuilder sql = new StringBuilder("select count(*) from notice where publishStatus = 1");
//		if (product_name != null && !"".equals(product_name)) {
//			sql.append(" where title like ?");
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
//首页的已发布公告查询
	public List<noice> getNotices(Integer typeId) throws SQLException {
		boolean flag = false;
		StringBuilder sql = new StringBuilder("select * from notice where publishStatus = 1 ");

		if (typeId != null) {
			sql.append(" and typeId = ? ");
			flag = true;
		}
		sql.append(" ORDER BY publishDate DESC");
		conn = ConnectionManager.getConnection();
		ps = conn.prepareStatement(sql.toString());
		int cursor = 1;
		if (flag) {
			ps.setInt(1, typeId);
		}
		ResultSet rs = ps.executeQuery();
		List<noice> noiceslist = new ArrayList<>();
		while (rs.next()) {
			noice noice = new noice();
			noice.setId(rs.getInt("id"));
			noice.setTitle(rs.getString("title"));
			noice.setContent(rs.getString("content"));
			noice.setCreateDate(rs.getDate("createDate"));
			noice.setPublishDate(rs.getDate("publishDate"));
			noice.setPublishStatus(rs.getInt("publishStatus"));

			Type type = new Type();
			type.setId(rs.getInt("typeId"));
			noice.setType(type);

			User user = new User();
			user.setId(rs.getInt("userId"));
			noice.setUser(user);
			noiceslist.add(noice);

		}

		return noiceslist;
	}
	//设置公告页面的的页数和公告
	public List<noice> getNoticePublish(String title, PageModel pageModel) throws SQLException{
		
//		boolean flag = false;
		StringBuilder sql = new StringBuilder("select * from notice where publishStatus = 1");

//		if (title != null && !"".equals(title)) {
//			sql.append(" where title like ? ");
//			flag = true;
//		}
		sql.append(" limit ?,?");
		conn = ConnectionManager.getConnection();
		ps = conn.prepareStatement(sql.toString());

		int cursor = 1;
//		if (flag) {
//			ps.setString(cursor++, "%" + title + "%");
//		}
		ps.setInt(cursor++, pageModel.getStarRow());
		ps.setInt(cursor++, pageModel.getPageSize());
		ResultSet rs = ps.executeQuery();
		List<noice> noiceslist = new ArrayList<>();
		while (rs.next()) {
			noice noice = new noice();
			noice.setId(rs.getInt("id"));
			noice.setTitle(rs.getString("title"));
			noice.setContent(rs.getString("content"));
			noice.setCreateDate(rs.getDate("createDate"));
			noice.setPublishDate(rs.getDate("publishDate"));
			noice.setPublishStatus(rs.getInt("publishStatus"));

			Type type = new Type();
			type.setId(rs.getInt("typeId"));
			noice.setType(type);

			User user = new User();
			user.setId(rs.getInt("userId"));
			noice.setUser(user);
			noiceslist.add(noice);

		}

		return noiceslist;
	}
	//后台所有公告信息
	public List<noice> getNoticeByPage(String title, PageModel pageModel) throws SQLException {
		boolean flag = false;
		StringBuilder sql = new StringBuilder("select * from notice");

		if (title != null && !"".equals(title)) {
			sql.append(" where title like ? ");
			flag = true;
		}
		sql.append(" limit ?,?");
		conn = ConnectionManager.getConnection();
		ps = conn.prepareStatement(sql.toString());

		int cursor = 1;
		if (flag) {
			ps.setString(cursor++, "%" + title + "%");
		}
		ps.setInt(cursor++, pageModel.getStarRow());
		ps.setInt(cursor++, pageModel.getPageSize());
		ResultSet rs = ps.executeQuery();
		List<noice> noiceslist = new ArrayList<>();
		while (rs.next()) {
			noice noice = new noice();
			noice.setId(rs.getInt("id"));
			noice.setTitle(rs.getString("title"));
			noice.setContent(rs.getString("content"));
			noice.setCreateDate(rs.getDate("createDate"));
			noice.setPublishDate(rs.getDate("publishDate"));
			noice.setPublishStatus(rs.getInt("publishStatus"));

			Type type = new Type();
			type.setId(rs.getInt("typeId"));
			noice.setType(type);

			User user = new User();
			user.setId(rs.getInt("userId"));
			noice.setUser(user);
			noiceslist.add(noice);

		}

		return noiceslist;
	}

	public int publishUpdate(String[] ids, int userId) throws SQLException {
		StringBuilder sql = new StringBuilder("update notice set publishStatus=?, ");
		sql.append("publishDate = ?,userId = ? where id in (");
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

	// 更新的方法
	public int update(noice noice) {
		conn = ConnectionManager.getConnection();
		int count = 0;
		String update = "update notice set title = ? ,content = ? ,typeId = ? where id = ?";
		try {
			ps = conn.prepareStatement(update);
			ps.setString(1, noice.getTitle());
			ps.setString(2, noice.getContent());
			ps.setInt(3, noice.getType().getId());
			ps.setInt(4, noice.getId());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	//删除公告方法
	public int delete(int id) {
		conn = ConnectionManager.getConnection();
		int count = 0;
		String delete = "delete from notice where id = ?";
		try {
			ps = conn.prepareStatement(delete);
			ps.setInt(1, id);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// 根据公告的id获取公告
	public noice getNotice(int id) {
		conn = ConnectionManager.getConnection();
		String select = "select * from notice where id = ?";
		noice noice = null;
		try {
			ps = conn.prepareStatement(select);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int ids = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date createDate = rs.getDate("createDate");
				Date publishDate = rs.getDate("publishDate");
				int publishStatus = rs.getInt("publishStatus");
				int typeId = rs.getInt("typeId");
				int userId = rs.getInt("userId");
				noice = new noice();

				noice.setId(ids);
				noice.setTitle(title);
				noice.setContent(content);
				noice.setCreateDate(createDate);
				noice.setPublishDate(publishDate);
				noice.setPublishStatus(publishStatus);

				Type type = new Type();
				type.setId(typeId);
				noice.setType(type);

				User user = new User();
				user.setId(userId);
				noice.setUser(user);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noice;
	}
//所有公告信息
	public List<noice> getNotices() {
		List<noice> noiceslist = new ArrayList<>();

		conn = ConnectionManager.getConnection();
		String select = "select * from notice";
		try {
			ps = conn.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date createDate = rs.getDate("createDate");
				Date publishDate = rs.getDate("publishDate");
				int publishStatus = rs.getInt("publishStatus");
				int typeId = rs.getInt("typeId");
				int userId = rs.getInt("userId");
				noice noice = new noice();

				noice.setId(id);
				noice.setTitle(title);
				noice.setContent(content);
				noice.setCreateDate(createDate);
				noice.setPublishDate(publishDate);
				noice.setPublishStatus(publishStatus);
				Type type = new Type();
				type.setId(typeId);
				noice.setType(type);

				User user = new User();
				user.setId(userId);
				noice.setUser(user);
				noiceslist.add(noice);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noiceslist;
	}
	//添加方法
	public int save(noice noice) {

		int count = 0;
		conn = ConnectionManager.getConnection();

		String insert = "insert into notice(title,content,typeId,userId) values(?,?,?,?)";
		try {
			ps = conn.prepareStatement(insert);

			ps.setString(1, noice.getTitle());
			ps.setString(2, noice.getContent());
			ps.setInt(3, noice.getType().getId());
			ps.setInt(4, noice.getUser().getId());

			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
