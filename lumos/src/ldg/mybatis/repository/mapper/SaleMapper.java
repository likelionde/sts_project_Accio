package ldg.mybatis.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import ldg.mybatis.model.Condition;
import ldg.mybatis.model.Sale;

public interface SaleMapper {

		Integer insertSale(Sale sale);

		List<Sale> selectSale();
		
		List<Sale> selectSaleByUserId(int u_id);
		
		List<Sale> selectSaleByStu_num(int stu_num);
		
		Sale selectSaleByPrimaryKey(int s_id);
		
		@Delete("DELETE FROM SALE WHERE s_id = #{s_id}")
		Integer deleteSale(int s_id);

		Integer updateSale(Sale sale);

		List<Sale> selectSaleByCondition(Condition condition);
		@Delete("DELETE FROM SALE WHERE u_id = #{u_id}")
		Integer deleteSaleByU_id(int u_id);
		@Update ("UPDATE SALE SET flag = 1 WHERE s_id = #{s_id}")
		Integer updateFlag(int s_id);
}
