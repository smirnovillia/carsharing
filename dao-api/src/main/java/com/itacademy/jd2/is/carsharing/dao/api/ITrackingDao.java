package com.itacademy.jd2.is.carsharing.dao.api;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ITracking;
import com.itacademy.jd2.is.carsharing.dao.api.filter.TrackingFilter;

public interface ITrackingDao extends IBaseDao<ITracking, Integer>{

	List<ITracking> find(TrackingFilter filter);

}
