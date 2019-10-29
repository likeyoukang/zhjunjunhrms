package com.shiyanlou.service;

import java.util.List;
import java.util.Map;

import com.shiyanlou.domain.Position;

public interface PositionService {
	
	/**findPositions
	 * 
	 * @param map
	 * @return
	 */
	public List<Position> findPositions(Map<String, Object> map);
	
	/**getCount
	 * 
	 * @param map
	 * @return
	 */
	public Integer getCount(Map<String, Object> map);
		
	/**addPosition
	 * 
	 * @param position
	 * @return
	 */
	public Integer addPosition(Position position);
	
	/**updatePosition
	 * 
	 * @param position
	 * @return
	 */
	public Integer updatePosition(Position position);
	
	/**deletePosition
	 * 
	 * @param id
	 * @return
	 */
	public Integer deletePosition(Integer id);
}
