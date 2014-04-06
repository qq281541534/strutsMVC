package com.liuyu.web;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Test {

	//一个字符串数组{"用户1，商品1，200","用户2，商品2，100","用户3，商品1，300","用户4，商品3，50"，"用户5，商品3，50"}，
	//写的方法需要返回的是{"用户2，商品2","用户3，商品1","用户4，商品3"}也就是说比较下每种商品的最高价格是谁，并返回谁买了
	//，如果价格相同取最先买的人。
	
	private static String[] getRes(){
		String []str = {"用户1,商品1,200","用户2,商品2,100","用户3,商品1,300","用户4,商品3,50","用户5,商品3,50"};
		
		String [] array1 = new String[str.length];
		String [] array2 = new String[str.length];
		String [] array3 = new String[str.length];
		
		String temp = "";
		String temp1 = "";
		for(int i = 0;i<str.length;i++){
			temp = str[i];
			String[] ary = temp.split(",");
			array1[i] = ary[0];//用户
			array2[i] = ary[1];//商品
			array3[i] = ary[2];//价格
		}
		
		Set index = new HashSet();
		//循环比较
		for(int i=0;i<array2.length;i++){
			//用于标记下标是否重复
			boolean flag = false;
			for(int j=i+1;j<array2.length;j++){
				if(array2[i].equals(array2[j])){
					int one = Integer.parseInt(array3[i]);
					int two = Integer.parseInt(array3[j]);
					//比较钱数
					if(one>=two){//如果前一个大于或等于后一个，那么继续循环比较
						index.add(i);
						continue;
					}else if(one<two){//如果前一个小于后一个，哪儿结束里层循环
						index.add(j);
						if(flag){
							index.remove(i);
						}
						break;
					}
				}else{
					index.add(i);
					flag = true;
				}
				
			}
		}
		Iterator<Integer> it = index.iterator();
		String [] newAry = new String[]{};
		while (it.hasNext()) {
			int num = it.next();
			
		}
		return str;
	}
	
	public static void main(String[] args) {
		getRes();
	}

}
