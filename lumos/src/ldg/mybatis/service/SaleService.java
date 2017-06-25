package ldg.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ldg.mybatis.model.Condition;
import ldg.mybatis.model.Sale;
import ldg.mybatis.repository.mapper.SaleMapperRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleMapperRepository saleRepository;

	public List<Sale> selectSale() {
		return saleRepository.selectSale();
	}
	
	public List<Sale> selectSaleByUserId(int u_id) {
		return saleRepository.selectSaleByUserId(u_id);
	}

	@Transactional
	public Integer insertSale(Sale sale) {
		return saleRepository.insertSale(sale);
	}
	
	public Sale selectSaleByPrimaryKey(int s_id) {
		Sale s = saleRepository.selectSaleByPrimaryKey(s_id);
		return s;
	}
	
	@Transactional
	public Integer deleteSale(int s_id) {
		return saleRepository.deleteSale(s_id);
	}
	
	public Integer updateSale(Sale sale) {
		return saleRepository.updateSale(sale);
	}

	public List<Sale> selectSaleByCondition(Condition condition){
		return saleRepository.selectSaleByCondition(condition);	
	}
	public Integer deleteSaleByU_id(int p_id) {
		return saleRepository.deleteSaleByU_id(p_id);
	}
	@Transactional
	public Integer updateFlag(int s_id) {
		return saleRepository.updateFlag(s_id);
	}
}
