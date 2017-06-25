package ldg.mybatis.repository.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ldg.mybatis.model.SaleInfo;

@Repository
public class SaleInfoMapperRepository {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<SaleInfo> selectSaleInfoById(int u_id) {
		return sqlSession.getMapper(SaleInfoMapper.class).selectSaleInfoById(u_id);
	}
	public Integer insertSaleInfo(SaleInfo saleinfo){
		Integer result = sqlSession.getMapper(SaleInfoMapper.class).insertSaleInfo(saleinfo);
		return result;
	}
	public Integer deleteSaleInfo(Map<String, Object> condition){
		return sqlSession.getMapper(SaleInfoMapper.class).deleteSaleInfo(condition);
	}
	public SaleInfo selectInfoByPrimayKey(int info_id) {
		return sqlSession.getMapper(SaleInfoMapper.class).selectInfoByPrimayKey(info_id);
	}
	public SaleInfo selectSaleInfoByS_Id(int s_id) {
		return sqlSession.getMapper(SaleInfoMapper.class).selectSaleInfoByS_Id(s_id);
	}
	public Integer deleteSaleInfoByU_id(int u_id) {
		return sqlSession.getMapper(SaleInfoMapper.class).deleteSaleInfoByU_id(u_id);
	}
	public Integer deleteSaleInfoByInfo_id(int info_id) {
		return sqlSession.getMapper(SaleInfoMapper.class).deleteSaleInfoByInfo_id(info_id);
	}
	public List<SaleInfo> selectByS_Id(int s_id) {
		return sqlSession.getMapper(SaleInfoMapper.class).selectByS_Id(s_id);
	}
	public Integer deleteSaleInfoByS_id(int s_id){
		return sqlSession.getMapper(SaleInfoMapper.class).deleteSaleInfoByS_id(s_id);
	}
}
