package cn.hncu.domain;

import java.util.List;
import java.util.Map;

public interface UserMapper {
	/**
	 * 查询所有user信息
	 * @return 封装所有用户信息的List
	 */
	public List<User> all();
	/**
	 * 根据用户id查询相应的用户
	 * @param id User的id属性，主键
	 * @return user 或者 null
	 */
	public User query1(int id);
	/**
	 * 模糊查询，按理条件查询应该使用查询值对象
	 * @param user 值对象
	 * @return 封装符合条件的用户信息的List
	 */
	public List<User> query2(User user);
	/**
	 * 范围查询，使用查询值对象
	 * @param uqm 查询值对象
	 * @return 封装符合条件的用户信息的List
	 */
	public List<User> query3(UserQueryModel uqm);
	/**
	 * 范围查询，使用map封装查询条件，与查询值对象相比较灵活，但是使用时需要注意key值的对应
	 * @param map 封装查询条件的map
	 * @return 封装符合条件的用户信息的List
	 */
	public List<User> query4(Map<String, Object> map);
	
	/**
	 * 添加一条用户记录
	 * @param user 封装了用户信息的值对象
	 */
	public Integer add(User user);
	/**
	 * 根据用户id删除相应的用户记录
	 * @param id 用户id,主键
	 */
	public Integer del(Integer id);
	/**
	 * 修改用户信息
	 * @param user 新的用户信息
	 * @return
	 */
	public Integer update(User user);
	
	public List<User> sqlDemo();
	
	public Integer autoKeys(User user);
	public Integer autoKeys2(Map<String, Object> map);
}
