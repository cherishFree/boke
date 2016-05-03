package com.sjf.fenye;

public class TestPage {
	public static void main(String[] args) {
		Page page = PageUtil.createPage(5, 34, 7);
		System.out.println("起始点"+page.getBeginIndex());
		System.out.println("当前第几页"+page.getCurrentPage());
		System.out.println("每页显示多少条"+page.getEveryPage());
		System.out.println("总条数"+page.getTotalCount());
		System.out.println("总页数"+page.getTotalPage());
		System.out.println("是否有下一页"+page.isHasNextPage());
		System.out.println("是否有上一页"+page.isHasPrePage());
		
	}
}
