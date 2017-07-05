package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.Goods;
import dto.GoodsType;
import dto.Pic;

public class PicDao extends BaseDao{

	//带上分页查询商品数据
	public List<Pic> getPicList(){
		SqlSession session=getSqlSession();
	
		List<Pic> picList=session.selectList("Pic.mapper.findByPic");
		closeSqlSession();
		return picList;
	}
	
	
	//带上分页查询商品数据
	public List<Pic> getShowPicList(){
		SqlSession session=getSqlSession();
	
		List<Pic> picList=session.selectList("Pic.mapper.findByPic");
		closeSqlSession();
		return picList;
	}
	
	public int  savePic(Pic pic){
		SqlSession session=getSqlSession();
	
		int count=session.insert("Pic.mapper.savePic",pic);
		session.commit();
		closeSqlSession();
		return count;
	}
	
	public Pic getShowPic(int id){
		SqlSession session=getSqlSession();
	
		Pic pic=session.selectOne("Pic.mapper.ShowPicOne",id);
		closeSqlSession();
		return pic;
	}
	
	public int  updatePic(Pic pic){
		SqlSession session=getSqlSession();
		int count=session.update("Pic.mapper.updatePic",pic);
		session.commit();
		closeSqlSession();
		return count;
	}
	
	public int  getDelete(int id){
		SqlSession session=getSqlSession();
		int count=session.update("Pic.mapper.deletePic",id);
		session.commit();
		closeSqlSession();
		return count;
	}
	
}
