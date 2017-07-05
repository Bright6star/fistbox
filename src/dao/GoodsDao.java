package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.Goods;
import dto.GoodsType;

public class GoodsDao extends BaseDao{
	
	public boolean saveGoods(Goods goods){
		SqlSession session=getSqlSession();
		int count=session.insert("dto.Goods.saveGoods",goods);
		session.commit();
		closeSqlSession();
		return count>0?true:false;
		
	}
	
	public int updateGoods(Goods goods){
		SqlSession session=getSqlSession();
		int count=session.update("dto.Goods.getUpdate",goods);
		session.commit();
		closeSqlSession();
		return count;
		
	}
	
	//统计商品行数据
	public int count(Map<String , Object> params){
		SqlSession session=getSqlSession();
		int count=session.selectOne("dto.Goods.count",params);
		closeSqlSession();
		return count;
	}
	 
	//带上分页查询商品数据
	public List<Goods> getPageGoods(Map<String, Object> params){
		SqlSession session=getSqlSession();
		List<Goods> goodsList=session.selectList("dto.Goods.findByPage",params);
	
		closeSqlSession();
		return goodsList;
	}
			
			//查询所有类型信息
	public List<Goods> getGoodsList(Goods goods){
		SqlSession session=getSqlSession();
		List<Goods> goodsList=session.selectList("dto.Goods.getGoodsList",goods);
		closeSqlSession();
		return goodsList;
	}
		
			//删除单条记录
	public int getDelete(int  id){
		SqlSession session=getSqlSession();
		int count=session.delete("dto.Goods.getDelete",id);
		session.commit();
		closeSqlSession();
		return count;
	}
			
	public Goods getShowUpdate(int id) {
		SqlSession session=getSqlSession();
		Goods goods =new Goods();
		goods=session.selectOne("dto.Goods.getGoodsById",id);
		closeSqlSession();
		return goods;
				
	}
			
	public int getUpdate(GoodsType goodstype) {
		SqlSession session=getSqlSession();
		int count=session.update("dto.GoodsType.getUpdate",goodstype);
		session.commit();
		closeSqlSession();
		return count;
				
	}
			
	public Goods getGoodsById(int id){
		SqlSession session=getSqlSession();	
		Goods goods=session.selectOne("dto.Goods.getGoodsById",id);
		closeSqlSession();
		return goods;
	}
	//首页数据新品
	public List<Goods> getNewGoodsList(){
		SqlSession session=getSqlSession();
		List<Goods> goodsList=session.selectList("dto.Goods.getNewGoods");
		closeSqlSession();
		return goodsList;
	}
	//首页数据新品大图
	public List<Goods> getNewBGGoodsList(){
		SqlSession session=getSqlSession();
		List<Goods> goodsList=session.selectList("dto.Goods.getNewBGGoods");
		closeSqlSession();
		return goodsList;
	}
	
	//首页数据热卖大图
	public List<Goods> getHotBGGoodsList(){
		SqlSession session=getSqlSession();
		List<Goods> goodsList=session.selectList("dto.Goods.getHotBGGoods");
		closeSqlSession();
		return goodsList;
	}
		
	//首页数据热卖
	public List<Goods> getHotGoodsList(){
		SqlSession session=getSqlSession();
		List<Goods> goodsList=session.selectList("dto.Goods.getHotGoods");
		closeSqlSession();
		return goodsList;
	}
	
	//首页数据夏日
	public List<Goods> getsummGoodsList(){
		SqlSession session=getSqlSession();
		List<Goods> goodsList=session.selectList("dto.Goods.getSummGoods");
		closeSqlSession();
		return goodsList;
	}
		
}

