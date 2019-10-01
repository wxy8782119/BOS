package com.itheima.bos.service;

import java.util.List;

import com.itheima.bos.domain.Region;

public interface IRegionService {

	public void saveBatch(List<Region> regionList);

}
