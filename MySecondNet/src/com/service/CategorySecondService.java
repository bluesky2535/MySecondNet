package com.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.Dao.CategorySecondDao;
import com.domain.CategorySecond;

@Component
public class CategorySecondService {

	@Resource
	private CategorySecondDao categorySecondDao;

	// 查询全部
	public List<CategorySecond> selectAll() {
		return categorySecondDao.selectAll();

	}

	// 用id查询
	public CategorySecond findById(int csid) {

		return categorySecondDao.findById(csid);
	}
//删除
	public void delete(CategorySecond cs) {

		categorySecondDao.delete(cs);
	}
	//添加
	public void add(CategorySecond cs) {

		categorySecondDao.add(cs);
	}

	public List<CategorySecond> findbycid(int cid) {
		List<CategorySecond> cslist=categorySecondDao.findbycid(cid);
		return cslist;
	}

}
