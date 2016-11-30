package com.sist.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BoardImpl implements Board {

	@Override
	public String getBoardName() {
		return "Notice Board";
	}

}
