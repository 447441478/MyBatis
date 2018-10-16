package cn.hncu.multiTable.domain;

import java.util.List;

public interface BookMapper {
	/**
	 * 查询有属主的书籍情况
	 * @return
	 */
	List<Book> mulTabQuery();
}
