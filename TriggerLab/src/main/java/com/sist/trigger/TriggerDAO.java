package com.sist.trigger;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TriggerDAO {
	
	@Autowired
	private TriggerMapper mapper;
	
	public List<GoodsVO> goodsAllData(){
		return mapper.goodsAlldata();
	};
	
	public void inputInsert(InputVO vo){
		mapper.inputInsert(vo);
	}
}
