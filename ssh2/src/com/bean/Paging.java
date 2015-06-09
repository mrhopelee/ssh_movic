package com.bean;
//分页类用来记录分页信息
public class Paging {
	
	private int pageCount=0;//记录一共有多少页
	private int rowCount=0;//记录一共有多少条记录
	private int pageNow=1;//记录现在是第几页
	private int pageSize=20;//记录每一页游多少条记录
	
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public void sumPageCount()
	{
		if(rowCount%pageSize==0)
		{
			pageCount=rowCount/pageSize;
		}
		else
		{
			pageCount=rowCount/pageSize+1;
		}
	}
	

}
