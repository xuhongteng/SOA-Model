package cn.test.xu.pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.test.xu.mapper.TbItemMapper;
import cn.test.xu.pojo.TbItem;
import cn.test.xu.pojo.TbItemExample;

public class PageHelperTest {
	
	@Test
	public void testPageHelper() throws Exception{
		//初始化spring容器用来获取Mapper代理对象
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		//从容其中获得代理对象，即获得Mapper的映射文件
		TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class);
		//执行sql语句之前设置分页信息 1表示开始查询的页码，10表示每页的记录数
		PageHelper.startPage(1, 10);
		//执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
		//获取分页信息
		PageInfo pageInfo = new PageInfo<>(list);
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getPages());
		System.out.println(list.size());
		
	}

}
