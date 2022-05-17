package com.khie.nonspring01;

public class ServiceImpl {
	
	private DAO dao;
	
	public ServiceImpl() { }

	public ServiceImpl(DAO dao) {
		this.dao = dao;
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	// 비지니스 로직
	public void bis() {
		dao.add();
	}
	
}
