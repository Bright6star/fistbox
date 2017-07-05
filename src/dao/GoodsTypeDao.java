package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.GoodsType;


public class GoodsTypeDao extends BaseDao{
	
	//查询所有类型信息
		public List<GoodsType> getGoodsTypeList(){
			SqlSession session=getSqlSession();
			List<GoodsType> userList=session.selectList("dto.GoodsType.getGoodsTypeList");
			closeSqlSession();
			return userList;
		}
	
		//删除单条记录
		public int getDelete(String code){
			SqlSession session=getSqlSession();
			int count=session.delete("dto.GoodsType.getDelete",code);
			session.commit();
			closeSqlSession();
			return count;
		}
		
		public GoodsType getShowUpdate(String code) {
			SqlSession session=getSqlSession();
			GoodsType goodsType =new GoodsType();
			goodsType=session.selectOne("dto.GoodsType.getUserById",code);
			closeSqlSession();
			return goodsType;
			
		}
		
		public int getUpdate(GoodsType goodstype) {
			SqlSession session=getSqlSession();
			int count=session.update("dto.GoodsType.getUpdate",goodstype);
			session.commit();
			closeSqlSession();
			return count;
			
		}
		
		public int getAddGT(GoodsType goodstype) {
			SqlSession session=getSqlSession();
			int count=session.insert("dto.GoodsType.getAddGT",goodstype);
			session.commit();
			closeSqlSession();
			return count;
			
		}
		
		public GoodsType findGoodsTypeByCode(String code){
			SqlSession session=getSqlSession();
			GoodsType goodsType=session.selectOne("dto.GoodsType.findGoodsTypeByCode",code);
			closeSqlSession();
			return goodsType;
		}

}
