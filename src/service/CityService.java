package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.NoticeDao;
import dao.ProductDao;
import dao.TypeDao;
import dao.UserDao;
import dto.Product;
import dto.Type;
import dto.User;
import dto.noice;
import info.newServlet;
import uitls.ConnectionManager;
import uitls.PageModel;

public class CityService {

	NoticeDao dao = new NoticeDao();
	UserDao userDao = new UserDao();

	TypeDao typeDao = new TypeDao();
	ProductDao productDao=new ProductDao();

	public List<noice> getNotices(Integer typeId) throws SQLException {
		List<noice> noticelist = dao.getNotices(typeId);
		for (noice notice : noticelist) {
			Type type = typeDao.getTypes(notice.getType().getId()).get(0);
			notice.setType(type);
			User user = userDao.getUserById(notice.getUser().getId());
			notice.setUser(user);
		}
		return noticelist;
	}

	public List<Type> getNoticeTypes(Integer typeId) {
		return typeDao.getTypes(typeId);

	}
	//产品
	public List<Type> getProTypes(Integer typeId) {
		return typeDao.getProductTypes(typeId);

	}

	public User getUserByName(User user) {
		return userDao.getUser(user);
	}
	
	public List<Product> getProductPublish(String product_name, PageModel pageModel1) throws SQLException {
		int recordCount = productDao.countPublish(product_name);
		pageModel1.setRecordCount(recordCount);
		List<Product> productslist = productDao.getProductPublish(product_name, pageModel1);		
//		for (Product product : productslist) {
//			Type type = typeDao.getProductTypes(product.getType().getId()).get(0);
//			product.setType(type);
//			User user = userDao.getUserById(product.getUser().getId());
//			product.setUser(user);
//		}

		return productslist;
	}
	
	public List<Product> getProductByPage(String product_name, PageModel pageModel1) throws SQLException {
		int recordCount = productDao.count(product_name);
		pageModel1.setRecordCount(recordCount);
		List<Product> productslist = productDao.getProductByPage(product_name, pageModel1);		
		for (Product product : productslist) {
			Type type = typeDao.getProductTypes(product.getType().getId()).get(0);
			product.setType(type);
			User user = userDao.getUserById(product.getUser().getId());
			product.setUser(user);
		}

		return productslist;
	}

	public List<noice> getNoticePublish(String title, PageModel pageModel) throws SQLException {

		int recordCount = dao.countPublish(title);

		pageModel.setRecordCount(recordCount);
		List<noice> noiceslist = dao.getNoticePublish(title, pageModel);		
//		for (noice notice : noiceslist) {
//			Type type = typeDao.getTypes(notice.getType().getId()).get(0);
//			notice.setType(type);
//			User user = userDao.getUserById(notice.getUser().getId());
//			notice.setUser(user);
//		}
		return noiceslist;
	}
	
	public List<noice> getNoticeByPage(String title, PageModel pageModel) throws SQLException {

		int recordCount = dao.count(title);

		pageModel.setRecordCount(recordCount);
		List<noice> noiceslist = dao.getNoticeByPage(title, pageModel);		
		for (noice notice : noiceslist) {
			Type type = typeDao.getTypes(notice.getType().getId()).get(0);
			notice.setType(type);
			User user = userDao.getUserById(notice.getUser().getId());
			notice.setUser(user);
		}
		return noiceslist;
	}

	// 获取单条记录
	public noice getNoticeById(int id) {
		return dao.getNotice(id);
	}

	public Product getProductById(int id) {
		return productDao.getProduct(id);
	}
	
	// 获取所有公告列表
	public List<noice> showNotice() {
		return dao.getNotices();

	}

	public String addNotice(noice notice) {
		int count = dao.save(notice);
		return count > 0 ? "新增成功" : "新增失败";
	}
	
	public String addProduct(Product product) {
		int count = productDao.save(product);
		return count > 0 ? "新增成功" : "新增失败";
	}
	
	public String publish(String[] ids, int userId) throws SQLException {

		int count = dao.publishUpdate(ids, userId);
		return count > 0 ? "发布成功" : "发布失败";
	}

	public String update(noice notice) {

		int count = dao.update(notice);
		return count > 0 ? "修改成功" : "修改失败";
	}

	public String delete(int id) {
		int count = dao.delete(id);
		return count > 0 ? "删除成功" : "删除失败";
	}
	/*
	 * 产品的操作*/
	public String deletepro(int id) {
		int count = productDao.delete(id);
		return count > 0 ? "删除成功" : "删除失败";
	}
	
	public String updatepro(Product product) {

		int count = productDao.update(product);
		return count > 0 ? "修改成功" : "修改失败";
	}
	
	public String publishpro(String[] ids, int userId) throws SQLException {

		int count = productDao.publishUpdate(ids, userId);
		return count > 0 ? "发布成功" : "发布失败";
	}
	
	public List<Product> getProducts(Integer typeId) throws SQLException {
		List<Product> productlist = productDao.getProducts(typeId);
		for (Product product : productlist) {
			Type type = typeDao.getTypes(product.getType().getId()).get(0);
			product.setType(type);
			User user = userDao.getUserById(product.getUser().getId());
			product.setUser(user);
		}
		return productlist;
	}
}
