package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IBlackListDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IBlackList;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.BlackList;

@Repository
public class BlackListDaoImpl extends AbstractDaoImpl<IBlackList, Integer> implements IBlackListDao {

	   protected BlackListDaoImpl() {
	        super(BlackList.class);
	    }

	    @Override
	    public IBlackList createEntity() {
	        final BlackList blackList = new BlackList();
	        return blackList;	
	    }
}
