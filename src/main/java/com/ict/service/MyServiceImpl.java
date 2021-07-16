package com.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.dao.MyDAO;
import com.ict.vo.BVO;
import com.ict.vo.CVO;

@Service
public class MyServiceImpl implements MyService{
	@Autowired
	private MyDAO myDAO ;
	
	@Override
	public int selectCount() throws Exception {
		return myDAO.selectCount();
	}

	@Override
	public List<BVO> selectBVOList(int begin, int end) throws Exception {
		return myDAO.selectBVOList(begin, end);
	}

	@Override
	public int insertBVO(BVO bvo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BVO selectBVOOneList(String b_idx) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteCVOComm_All(String b_idx) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBVO(BVO bvo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBVO(BVO bvo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBVOHit(String b_idx) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CVO> selectCVOList(String b_idx) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCVO(CVO cvo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCVO(String c_idx) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
