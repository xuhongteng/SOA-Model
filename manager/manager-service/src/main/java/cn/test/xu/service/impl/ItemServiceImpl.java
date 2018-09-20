package cn.test.xu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.test.xu.service.ItemService;
import cn.test.xu.common.pojo.EasyUIGridResult;
import cn.test.xu.mapper.TbItemMapper;
import cn.test.xu.pojo.TbItem;
import cn.test.xu.pojo.TbItemExample;


@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem getItemById(long id) {
		TbItem item = itemMapper.selectByPrimaryKey(id);
		return item;
	}

	@Override
	public EasyUIGridResult getItemList(int page, int rows) {
		PageHelper.startPage(page, rows);
		TbItemExample example = new TbItemExample();
		
		//执行查询
		List<TbItem> list = itemMapper.selectByExample(example);
		//创建一个返回值对象
		EasyUIGridResult result = new EasyUIGridResult();
		//给对象的Rows（为list集合）赋值
		result.setRows(list);
		//创建PageInfo对象，取出分页结果
		PageInfo pageInfo = new PageInfo<>(list);
		//取出总记录数
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
