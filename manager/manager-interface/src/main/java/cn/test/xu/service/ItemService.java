package cn.test.xu.service;

import cn.test.xu.common.pojo.EasyUIGridResult;
import cn.test.xu.pojo.TbItem;

public interface ItemService {
	TbItem getItemById(long id);
	
	EasyUIGridResult getItemList(int page,int rows);
}
