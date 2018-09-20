package cn.test.xu.common.pojo;

import java.io.Serializable;
import java.util.List;

public class EasyUIGridResult implements Serializable{
	private long total;
	private List rows;
	
	public EasyUIGridResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EasyUIGridResult(long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "EasyUIGridResult [total=" + total + ", rows=" + rows + "]";
	}
	

}
