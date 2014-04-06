package com.liuyu.web;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
	
	//一个字符串数组{"用户1，商品1，200","用户2，商品2，100","用户3，商品1，300","用户4，商品3，50"，"用户5，商品3，50"}，
	//写的方法需要返回的是{"用户2，商品2","用户3，商品1","用户4，商品3"}也就是说比较下每种商品的最高价格是谁，并返回谁买了
	//，如果价格相同取最先买的人。
	
	
	public List<Number> convertToNumbers(String[] str){
		//将字符串转换成Number类的对象集合
		List<Number> numbers = new ArrayList<Number>();
		for(int i=0;i<str.length;i++){
			//每循环一次，转换成一个子字符串
			Number number = new Number();
			String subString = str[i];
			//拆分
			String [] elements = subString.split(",");
			number.username = elements[0];
			number.pname = elements[1];
			number.value = elements[2];
			numbers.add(number);
		}
		return numbers;
	}
	
	//找到每种商品对应的最高价格
	public List<Number> findTheMax(List<Number> nums){
		//在nums类集合里面找到标识为商标2，商品1，商品3的记录
		Number A = new Number();
		Number B = new Number();
		Number C = new Number();
		List<Number> abc = new ArrayList<Number>();
		int maxA = 0;
		int maxB = 0;
		int maxC = 0;
		List<Number> ABC = new ArrayList<Number>();
		for(int i =0;i<nums.size();i++){
			if(nums.get(i).pname.equals("商品2")){
				int val = Integer.parseInt(nums.get(i).value);
				if(maxA<val){
					maxA = val;
					A = nums.get(i);
					
				}
			}else if (nums.get(i).pname.equals("商品1")){
				int val = Integer.parseInt(nums.get(i).value);
				if(maxB<val){
					maxB = val;
					B= nums.get(i);
					
				}
			}else{
				int val = Integer.parseInt(nums.get(i).value);
				if(maxC<val){
					maxC = val;
					C=nums.get(i);
				}
			}
		}
		ABC.add(A);
		ABC.add(B);
		ABC.add(C);
		return ABC;
	}
	
	//返回结果
	public String getRes(String [] str){
		List<Number> nums = this.convertToNumbers(str);
		List<Number> abc = this.findTheMax(nums);
		StringBuffer  s = new StringBuffer("{");
		for(int i=0;i<abc.size();i++){
			s.append(abc.get(i).toString()+",");
		}
		String s1 = s.substring(0, s.length()-1);
		s1 += "}";
		
		return s1.toString();
	}
	
	public static void main(String[] args) {
		
		String [] str = {"用户1,商品1,200","用户2,商品2,100","用户3,商品1,300","用户4,商品3,50","用户5,商品3,50"};
		Test1 test = new Test1();
		System.out.println(test.getRes(str));
	}
	
}

class Number{//将每个子字符串看成一个类，有三个属性
	public String username;
	public String pname;
	public String value;
	
	public String toString(){
		return "\""+username+","+pname+"\"";
	}
}
