package ldg.mybatis.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import ldg.mybatis.model.SaleInfo;

public interface SaleInfoMapper {
	
	List<SaleInfo> selectSaleInfoById(int u_id);
	SaleInfo selectSaleInfoByS_Id(int s_id);
	@Insert("INSERT INTO SALE_INFO(s_id, u_id, info_date) VALUES (#{sale.s_id}, #{user.u_id}, #{info_date})")
	Integer insertSaleInfo(SaleInfo saleinfo);
	Integer deleteSaleInfo(Map<String, Object> condition);

	SaleInfo selectInfoByPrimayKey(int info_id);
	Integer deleteSaleInfoByU_id(int u_id);
	Integer deleteSaleInfoByInfo_id(int info_id);
	
	@Delete("DELETE FROM SALE_INFO WHERE s_id = #{s_id}")
	Integer deleteSaleInfoByS_id(int s_id);
	
	List<SaleInfo> selectByS_Id(int s_id);
}
