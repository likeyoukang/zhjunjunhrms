package com.shiyanlou.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shiyanlou.domain.Post;

@Repository
public interface PostDao {
	
	/** findPosts
	 * 
	 * @return
	 */
	public List<Post>findPosts(Map<String, Object> map);
	
	/** getCount
	 * 
	 * @param map
	 * @return
	 */
	public Integer getCount(Map<String, Object> map);
	
	/** addPost
	 * 
	 * @param post
	 * @return
	 */	
	public Integer addPost(Post post);
	
	/** post
	 * 
	 * @param post
	 * @return
	 */
	public Integer updatePost(Post post);
	
	/** deletePost
	 * 
	 * @param id
	 * @return
	 */
	public Integer deletePost(Integer id);
	
	/** getPostById
	 * 
	 * @param id
	 * @return
	 */
	public Post getPostById(Integer id);
}
