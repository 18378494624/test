package edu.glg.stumgr;

import java.util.Scanner;

public class StuMgr {
	
	/** 数组容量（最大可以存放的学生数量）*/
	private static int len = 10;
	/** 学生的数量*/
	private static int stulength = 0;
	
	/** 学生学号(6位)*/
	private static String[] nos = new String[len];	
	/** 学生姓名*/
	private static String[] names = new String[len];	
	/** 学生身份证号（18位）*/
	private static String[] idCards = new String[len];	
	/** 学生性别（男/女）*/
	private static String[] sexs = new String[len];
	/** 学生年龄*/
	private static int[] ages = new int[len];
	
	
	static int userSel;
	
	static Scanner input = new Scanner(System.in);
	/** main*/
	public static void main(String[] args) {
		while(true){
			userSel = showMenu();
			if(userSel < 0 || userSel > 5){
				System.out.println("选择有误，请重新选择（0-5）");
			}else{
				switch(userSel){
				case 1:
					addStu();
					break;
				case 2:
					delestStu();
					break;
				case 3:
					updateStu();
					break;
				case 4:
					selectStu();
					break;
				case 5:
					listAll();
					break;
				case 0:
					exitStuMgrSys();
					break;
			}
			
			}
		
		}
	}
	
	/**
	 * 方法菜单
	 */
	public static int showMenu(){
		System.out.println("-----------------------------------------");
		System.out.println("|		1.增加一个学生		|");
		System.out.println("|		2.删除一个学生		|");
		System.out.println("|		3.修改一个学生的信息		|");
		System.out.println("|		4.查询一个学生的信息		|");
		System.out.println("|		5.查询所有学生信息		|");
		System.out.println("|		0.退出系统		|");
		System.out.println("-----------------------------------------");
		System.out.print("请输入您的选择：");
		userSel = input.nextInt();
		return userSel;
	}

	/**
	 * 增加一个学生信息
	 * 
	 */
	public static void addStu() {
		String no;
		String name;
		String idCard;
		String sex;
		int age;
		
		System.out.println("您选择增加一个学生的信息。"); //姓名
		while(true){					
			System.out.print("请输入6位学号：");
			no = input.next();
			if(6 != no.length()){
				System.out.println("学号有误!");
			}else if(getIndexByStuNo(no) != -1){
				System.out.println("该学生已经存在");
			}else{
				break;
			}
		}
		
		System.out.print("请输入姓名：");	//姓名
		name = input.next();
		
		while(true){					//身份证
			System.out.print("请输入18位身份证号：");
			idCard = input.next();
			if(18 != idCard.length()){
				System.out.println("身份证号有误！");
			}else{
				break;
			}
		}
		
		
		System.out.print("请输入性别：");	//性别
		sex = input.next();
		
		while(true){					//年龄
			System.out.print("请输入年龄：");
			age = input.nextInt();
			if(age >100 || age < 0){
				System.out.println("年龄有误!");
			}else{
				break;
			}
		}
		
		nos[stulength] = no;			//录入数组
		names[stulength] = name;
		idCards[stulength] = idCard;
		sexs[stulength] = sex;
		ages[stulength] = age;
		
		stulength++;		//学生数量加一
		
		System.out.println("录入完成！");
	}
	
	/**
	 * 删除一个学生信息
	 */
	public static void delestStu() {
		System.out.println("请输入待删除学生学号：");
		String stuNo = input.next();
		int index = getIndexByStuNo(stuNo);
		if(index == -1){
			System.out.println("学号有误，该学生不存在！");
		}else{
			nos[index] = nos[stulength - 1];
			names[index] = names[stulength - 1];
			idCards[index] = idCards[stulength - 1];
			sexs[index] = sexs[stulength - 1];
			ages[index] = ages[stulength - 1];
			System.out.println("删除完成！");
			
			stulength--;
		}
	}
	
	/**
	 * 修改一个学生信息
	 * 
	 */
	public static void updateStu() {
		int index;
		while(true){
			System.out.println("请输入待修改学生的6位学号：");
			String stuNo = input.next();
			index = getIndexByStuNo(stuNo);
			if(6 != stuNo.length()){
				System.out.println("学号有误!");
			}else if(index == -1){
				System.out.println("学号有误，该学生不存在！");
			}else{
				break;
			}
		}
		

		System.out.println("姓名："+names[index]);
		System.out.print("请输入新的姓名：");
		names[index] = input.next();
		
		while(true){
			System.out.print("请输入新的18位身份证号：");
			String a = input.next();
			if(18 != a.length()){
				System.out.println("身份证号有误!");
			}else{
				idCards[index] = a;
				break;
			}
		}
		
		System.out.print("请输入新的性别：");
		sexs[index] = input.next();
		
		System.out.print("请输入新的年龄：");
		ages[index] = input.nextInt();
		
	}
	
	/**
	 * 查询一个学生信息
	 * 
	 */
	public static void selectStu() {
		int index;
		while(true){
			System.out.print("请输入学号：");
			String stuNo = input.next();
			index = getIndexByStuNo(stuNo);
			if(index == -1){
				System.out.println("学号有误，该学生不存在！");
			} else{
				break;
			}
		}
		System.out.println("学号：" + nos[index]);
		System.out.println("姓名：" + names[index]);
		System.out.println("身份证:" + idCards[index]);
		System.out.println("性别：" + sexs[index]);
		System.out.println("年龄：" + ages[index]);
	}
	
	/**
	 * 查询全部学生信息
	 * 
	 */
	public static void listAll() {
		for(int i = 0;i < stulength;i++){
			System.out.print("学号：" + nos[i]);
			System.out.print("  姓名：" + names[i]);
			System.out.println("  身份证:" + idCards[i]);
			System.out.print("  性别：" + sexs[i]);
			System.out.println("  年龄：" + ages[i]);	
		}
		
	}
	
	/**
	 * 退出系统
	 * 
	 */
	public static void exitStuMgrSys() {
		System.out.println("成功退出系统。");
		System.exit(1);
	}
	
	/**
	 * 学号查询
	 */
	public static int getIndexByStuNo(String no){
		for(int i = 0;i < stulength;i++){
			if(no.equals(nos[i])){
				return i;
			}
		}
		return -1;
	}
		
}

