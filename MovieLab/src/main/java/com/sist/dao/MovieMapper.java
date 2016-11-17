package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

public interface MovieMapper {
	@SelectKey(keyProperty="mno", before=true, resultType=int.class,
			statement="SELECT NVL(MAX(mno)+1, 1) as mno FROM bigMovie")
	@Insert("INSERT INTO bigMovie VALUES(#{mno}, #{title}, #{director}, "
			+ "#{actor}, #{genre}, #{poster}, #{story}, #{rank}, #{star}, #{grade})")
	public void movieInsert(MovieVO vo);
	
	
	@Select("SELECT mno, title, poster, rank, star, grade, num "
			+ "FROM(SELECT mno, title, poster, rank, star, grade, Rownum as num "
			+ "FROM (SELECT mno, title, poster, rank, star, grade FROM bigMovie ORDER BY mno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<MovieVO> movieListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/7) FROM bigMovie")
	public int totalPageCount();
}
