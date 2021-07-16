package com.ict.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ict.vo.BVO;
import com.ict.vo.CVO;

public interface MyService {
	int selectCount() throws Exception ;
	List<BVO> selectBVOList(int begin, int end) throws Exception;
	int insertBVO(BVO bvo) throws Exception;
	BVO selectBVOOneList(String b_idx) throws Exception;
	int deleteCVOComm_All(String b_idx) throws Exception;
	int deleteBVO(BVO bvo) throws Exception;
	int updateBVO(BVO bvo) throws Exception;
	int updateBVOHit(String b_idx) throws Exception;
	List<CVO> selectCVOList(String b_idx) throws Exception;
	int insertCVO(CVO cvo) throws Exception;
	int deleteCVO(String c_idx) throws Exception; 
}
