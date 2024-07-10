/*
 [step1]
	void addEngineer(Engineer e){}
	void insertSalesMan(SalesMan(S){}
	void registerAnalysis(Analysis(A){} 
 [step2]
 	void addEngineer(Engineer e){}
 	void addSalesMan(SalesMan s){}
 	void addAnalysis(Analysis a){}
 [step3]
 	void addEmployee(Engineer e){}//step2 단계에서 "오버로딩"
 	void addEmployee(SalesMan s){}
 	void addEmployee(Analysis a){}
 [step4]
 void addEmployee(Employee e){}//step3에서 개수를 줄이지 못함 ===> "추상화 단계"	
 */
package com.edu.service;

import com.edu.vo.Engineer;
import com.edu.vo.SalesMan;

/*
 * Engineer, SalesMan 각각의 직원들을 핸들링 하는 기능만으로 구성된 서비스 클래스
 */
public class HRService {
	
	Engineer[] engineers;
	int eidx;//인덱스로 필드를 뽑아낼거임, 클래스 안에서 계속 사용할 것
	
	SalesMan[] salesMans;
	int sidx;
	
	public HRService(int size){//기본생성자 지정시 클래스와 접근지정자 맞춰주기
		engineers = new Engineer[size];
		salesMans = new SalesMan[size];
	}//생성자 end//반드시 배열은 필드에서 생성, 로컬변수로 작성하면 안됨. 
	
	//서비스 기능들을 정의.......1)선언부 먼저 작성 + 2) 구현부 작성 + test 해서 하나씩 호출하자
	
	//엔지니어를 추가하는 기능
	public void addEmployee(Engineer e) {
		//engineers[eidx++] = e;
		if(eidx==engineers.length)
			System.out.println("엔지니어 등록이 불가능합니다.");
		else {
			engineers[eidx++] =e;
			System.out.println(e.getName()+"엔지니어 등록 성공");
		}
	}
	//영업사원을 추가하는 기능
	public void addEmployee(SalesMan s) {	
		if(sidx==salesMans.length)
			System.out.println("영업사원 등록이 불가능합니다.");
		else {
			salesMans[sidx++] =s;
			System.out.println(s.getName()+"영업사원 등록 성공");
		}
	}
	//엔지니어의 정보를 수정하는 기능
	public void updateEmployee(Engineer e) {//인자값을 객체로 넣은 이유 : 객체를 모든값으로 넣었기 때문에 추후 모든 항목 수정이 가능을 위해. 
		for(Engineer engineer : engineers) {
			if(engineer==null) continue;//없으면 계속
			if(engineer.getName().equals(e.getName())) {//수정할 대상이 현재 존재한다면
				engineer.changeSalary(e.getSalary());///변경된 급여를 getsalary로 변경
				engineer.developMainSkill(e.getMainSkill());//
			}
		}
	}
	//영업사원의 정보를 수정하는 기능
	public void updateEmployee(SalesMan s) {
		for(SalesMan salesMan : salesMans) {
			if(salesMan==null) continue;//없으면 계속
			if(salesMan.getName().equals(s.getName())) {//수정할 대상이 현재 존재한다면
				salesMan.changeSalary(s.getSalary());///변경된 급여를 getsalary로 변경
				salesMan.setCommition(s.getCommition());//수정하고자 하는 곳에 넣어줌. unique한 값 ex)ssn, birthday
			}
		}
	}
	  //특정한 엔지니어를 검색하는 기능....이름으로 
	public Engineer searchEmployee(String name) {
		Engineer engineer = null;
		for(Engineer e : engineers) {
			if(e==null)continue;
			if(e.getName().equals(name))
				engineer=e;
		}		
		return engineer;
	}
	 
	
	//정보를 출력하는 기능을 추가
	public void printEngineer() {
		for(Engineer e : engineers) {
			if(e==null) break;
			System.out.println(e.getDetails());
		}
	}
	
	public void printSalesMan() {
		for(SalesMan s : salesMans) {
			if(s==null)break;
			System.out.println(s.getDetails());
		}
	}
	
}
