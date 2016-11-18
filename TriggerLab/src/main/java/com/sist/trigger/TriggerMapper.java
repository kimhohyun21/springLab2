package com.sist.trigger;

import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface TriggerMapper {
	
	@Select("SELECT * FROM 상품")
	public List<GoodsVO> goodsAlldata();
	
	@Insert("INSERT INTO 입고 "
			+ "VALUES((SELECT NVL(MAX(입고번호)+1, 1) FROM 입고), "
			+ "#{상품코드}, #{입고일자},#{입고수량},#{입고단가}, #{입고금액})")
	public void inputInsert(InputVO vo);
}
