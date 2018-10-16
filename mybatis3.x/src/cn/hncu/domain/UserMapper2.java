package cn.hncu.domain;

import java.util.List;
import java.util.Map;

public interface UserMapper2 {
	List<User> dynamicQuery1(Map<String, Object> map);
	List<User> dynamicQuery2(Map<String, Object> map);
	List<User> dynamicQuery3(Map<String, Object> map);
	Integer dynamicUpdate(Map<String, Object> map);
	List<User> inQuery(List<Integer> ids);
}
