package com.shiyanlou.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shiyanlou.dao.PositionDao;
import com.shiyanlou.domain.Position;
import com.shiyanlou.service.PositionService;

@Service("positionService")
public class PositionServiceImpl implements PositionService {

	@Resource
	private PositionDao positionDao;

	@Override
	public List<Position> findPositions(Map<String, Object> map) {

		return positionDao.findPositions(map);
	}

	@Override
	public Integer getCount(Map<String, Object> map) {

		return positionDao.getCount(map);
	}

	@Override
	public Integer addPosition(Position position) {

		return positionDao.addPosition(position);
	}

	@Override
	public Integer updatePosition(Position position) {

		return positionDao.updatePosition(position);
	}

	@Override
	public Integer deletePosition(Integer id) {
		Integer flag = null;
		try {
			flag = positionDao.deletePosition(id);
		} catch (Exception e) {
			throw new RuntimeException();
		}

		return flag;
	}

}
