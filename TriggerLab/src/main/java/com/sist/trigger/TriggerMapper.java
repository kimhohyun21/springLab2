package com.sist.trigger;

import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface TriggerMapper {
	
	@Select("SELECT * FROM ��ǰ")
	public List<GoodsVO> goodsAlldata();
	
	@Insert("INSERT INTO �԰� "
			+ "VALUES((SELECT NVL(MAX(�԰��ȣ)+1, 1) FROM �԰�), "
			+ "#{��ǰ�ڵ�}, #{�԰�����},#{�԰����},#{�԰�ܰ�}, #{�԰�ݾ�})")
	public void inputInsert(InputVO vo);
}
