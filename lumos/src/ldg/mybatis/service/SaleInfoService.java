package ldg.mybatis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ldg.mybatis.model.SaleInfo;
import ldg.mybatis.repository.mapper.SaleInfoMapperRepository;

@Service
public class SaleInfoService {
	@Autowired
	private SaleInfoMapperRepository saleinfoRepository;
	
	public List<SaleInfo> selectSaleInfoById(int u_id) {
		return saleinfoRepository.selectSaleInfoById(u_id);
	}
	public SaleInfo selectSaleInfoByS_Id(int s_id) {
		return saleinfoRepository.selectSaleInfoByS_Id(s_id);
	}
	@Transactional
	public Integer insertSaleInfo(SaleInfo saleinfo){
		return saleinfoRepository.insertSaleInfo(saleinfo);
	}
	@Transactional
	public SaleInfo selectInfoByPrimayKey(int info_id) {
		return saleinfoRepository.selectInfoByPrimayKey(info_id);
	}
	@Transactional
	public Integer deleteSaleInfo(int u_id, int s_id){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("u_id", u_id);
		condition.put("s_id", s_id);
		
		return saleinfoRepository.deleteSaleInfo(condition);
	}
	public Integer deleteSaleInfoByU_id(int u_id) {
		return saleinfoRepository.deleteSaleInfoByU_id(u_id);
	}
	public Integer deleteSaleInfoByInfo_id(int info_id) {
		return saleinfoRepository.deleteSaleInfoByInfo_id(info_id);
	}
	public List<SaleInfo> selectByS_Id(int s_id) {
		return saleinfoRepository.selectByS_Id(s_id);
	}
	public Integer deleteSaleInfoByS_id(int s_id){
		return saleinfoRepository.deleteSaleInfoByS_id(s_id);
	}

}
