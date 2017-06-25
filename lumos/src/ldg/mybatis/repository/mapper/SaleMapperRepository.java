package ldg.mybatis.repository.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ldg.mybatis.model.Condition;
import ldg.mybatis.model.Sale;

@Repository
public class SaleMapperRepository {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public Integer insertSale(Sale sale) {
		Integer result = sqlSession.getMapper(SaleMapper.class).insertSale(sale);
		return result;
	}
	
	public List<Sale> selectSale() {
		return sqlSession.getMapper(SaleMapper.class).selectSale();
	}
	
	public Integer deleteSale(int s_id) {
		Integer result = sqlSession.getMapper(SaleMapper.class).deleteSale(s_id);
		return result;
	}
	
	public Sale selectSaleByPrimaryKey(int s_id) {
		return sqlSession.getMapper(SaleMapper.class).selectSaleByPrimaryKey(s_id);
	}
	
	public List<Sale> selectSaleByCondition(Condition condition) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(SaleMapper.class).selectSaleByCondition(condition);
	}
	public Integer updateSale(Sale sale){
		return sqlSession.getMapper(SaleMapper.class).updateSale(sale);
	}
	
	public List<Sale> selectSaleByUserId(int u_id){
		return sqlSession.getMapper(SaleMapper.class).selectSaleByUserId(u_id);
	}
	public Integer deleteSaleByU_id(int u_id) {
		return sqlSession.getMapper(SaleMapper.class).deleteSaleByU_id(u_id);
	}
	public Integer updateFlag(int s_id) {
		return sqlSession.getMapper(SaleMapper.class).updateFlag(s_id);
	}
}
