package com.sjf.fenye;

public class TestPage {
	public static void main(String[] args) {
		Page page = PageUtil.createPage(5, 34, 7);
		System.out.println("��ʼ��"+page.getBeginIndex());
		System.out.println("��ǰ�ڼ�ҳ"+page.getCurrentPage());
		System.out.println("ÿҳ��ʾ������"+page.getEveryPage());
		System.out.println("������"+page.getTotalCount());
		System.out.println("��ҳ��"+page.getTotalPage());
		System.out.println("�Ƿ�����һҳ"+page.isHasNextPage());
		System.out.println("�Ƿ�����һҳ"+page.isHasPrePage());
		
	}
}
