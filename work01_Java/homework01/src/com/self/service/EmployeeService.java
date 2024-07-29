/**
 * @author Heejulee
 * @version 1.0
 */
package com.self.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.self.vo.Engineer;
import com.self.vo.Manager;

public class EmployeeService {
	
	//singleton 
	private static EmployeeService esvc = new EmployeeService();
	private EmployeeService() {}
	public static EmployeeService getInstance() {
		return esvc;
	}	
	
	Manager[ ] ms;
	int midx;
	
	Engineer[ ] egs;
	int egidx;	

	public EmployeeService(int size){
		ms = new Manager[size];
		egs = new Engineer[size];
	}
	
	//메소드 오버로딩(인자값만 다름)
	/**
	 * @param Manager 직원을 추가하는 기능
	 * @return 추가된 결과
	 */
	public void addEmployee(Manager m) {	
		ms[midx++] = m;			
		System.out.println(">>>>"+m.getName()+"님 정보가 성공적으로 저장되었습니다.");
	}
	
	public void addEmployee(Engineer eg) {	
		egs[egidx++] = eg;
		System.out.println(">>>>"+eg.getName()+"님 정보가 성공적으로 저장되었습니다.");
	}
	
	public void deleteManager(String name) {	
		for(int i = 0; i<ms.length; i++) {
			if(ms[i] !=null && ms[i].getName().equals(name)) {
				for(int j = i; j<ms.length -1; j++) {
					ms[j] = ms[j+1];//한칸 당겨 덮어쓰기
				}
				ms[ms.length-1]= null;
				break;
			};
		}System.out.println(">>>>"+name+"님의 정보가 삭제되었습니다.");
	}
	public void deleteEngineer(String name) {
		for(int i = 0; i<egs.length; i++) {
			if(egs[i] !=null && egs[i].getName().equals(name)) {
				for(int j = i; j<egs.length -1; j++) {
					egs[j] = egs[j+1];//한칸 당겨 덮어쓰기
				}
				egs[egs.length-1]= null;
				break;
			};
		}System.out.println(">>>>"+name+"님의 정보가 삭제되었습니다.");
	}
	
	//이름 제외 모든 정보 수정가능
	public void updateManager(String name, double changeSalary, String changeDept, int changeDeptno) {
		boolean updated = false;
		for(Manager manager : ms) {
			if(manager==null) continue;
			if(manager.getName().equals(name)) {
				manager.changeSalary(changeSalary);
				manager.changeDept(changeDept);
				manager.changeDeptno(changeDeptno);
				updated = true;
				
				if (updated) {
				System.out.println(">>>>"+name+"님의 정보가 업데이트되었습니다.");
				}
				else {System.out.println("업데이트할 관리자를 찾지 못했습니다.");
				}//else
	        }
		}
	}
	//이름 제외 모든 정보 수정가능
	public void updateEngineer(String name, double changeSalary, String changeTech, int changeBonus) {	
		boolean updated = false;
		for(Engineer engineer : egs) {
			if(engineer==null) continue;
			if(engineer.getName().equals(name)) {
				engineer.changeSalary(changeSalary);
				engineer.changeTech(changeTech);
				engineer.changeBonus(changeBonus);
				updated = true;
				
				if (updated) {
				System.out.println(">>>>"+name+"님의 정보가 업데이트되었습니다.");
				}
				else {System.out.println("업데이트할 관리자를 찾지 못했습니다.");
				}//else
	        }
		}
	}
	public Manager findManager(String name) {
		System.out.println(">>>>검색하신 "+name+"님의 정보입니다.");
		for(Manager manager : ms) {
			if(manager==null) continue;//
			if(manager.getName().equals(name)) { 
				System.out.println(manager.getDetails()); //찾으면 반환
				return manager;
			}
		}return null;//못찾으면 반환X
	}
	public Manager[ ] findManager(int deptno) {
		Manager[ ] temp = new Manager[ms.length];
		int midx = 0;
		
		for(Manager manager : ms) {
			if(manager==null) continue;//
			if(manager.getDeptno()== deptno) { 
				temp[midx++] =manager;
				System.out.println(manager.getDetails()); //찾으면 반환
				}
			}
		return null;
	}
	
	public Engineer findEngineer(String name) {
		System.out.println(">>>>검색하신 "+name+"님의 정보입니다.");
		for(Engineer engineer : egs) {
			if(engineer==null) continue;//
			if(engineer.getName().equals(name)) { 
				System.out.println(engineer.getDetails()); //찾으면 반환
				return engineer;
			}
		}return null;//못찾으면 반환X
	}
	//매니저 정보확인 메소드
	public void printManagers() {
		for(Manager managers : ms) {
			if(managers==null) continue;		
			else {
				System.out.println(managers.getDetails());
			}
		}
	}
	//엔지니어 정보확인 메소드
	public void printEngineers() {
		for(Engineer engineers : egs) {
			if(engineers==null) continue;		
			else {
				System.out.println(engineers.getDetails());
			}
		}
	}
	
	//관리직원 총 평균 급여 산출
	public void salaryInfoManagers() {
		double totalSalary = 0;	
		double averageSalary = 0;
		int midx = 0;
		
		 for (Manager manager : ms) {
	        	midx++;//반복되면 +1
		        if (manager != null) {
		            totalSalary += manager.getSalary();
		            averageSalary = totalSalary/midx;
		        }
		 }
		 System.out.println(">>>>Manager 총 급여 : "+totalSalary);
		 System.out.println(">>>>Manager 평균 급여 : "+Math.round(averageSalary* 10.0) / 10.0);//소수점 첫째자리까지
	}
	
	//엔지니어 총 평균 급여 산출
	public void salaryInfoEngineers() {
		double totalSalary = 0;	
		double averageSalary = 0;
		int eidx = 0;
		
		 for (Engineer engineer : egs) {
	        	eidx++;//반복되면 +1
		        if (engineer != null) {
		            totalSalary += engineer.getSalary();
		            averageSalary = totalSalary/eidx;
		        }
		 }
		 System.out.println(">>>>Engineer 총 급여 : "+totalSalary);
		 System.out.println(">>>>Engineer 평균 급여 : "+Math.round(averageSalary* 10.0) / 10.0);
	}
	
	//직원 등록 여부 확인(싱글톤 활용하기)
	public void register(String name) {
		System.out.println(name+"님의 그룹웨어 가입이 완료되었습니다.");
	}
}




