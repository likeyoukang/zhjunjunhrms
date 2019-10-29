package com.shiyanlou.service;

import java.util.List;
import java.util.Map;

import com.shiyanlou.domain.Post;

public interface PostService {
	
	/** findPosts
	 * 
	 * @param map
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
	
	/** updatePost
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
