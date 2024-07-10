/**
 * @author Heejulee
 * @version 2.0
 */
package com.self.service;

import com.self.parent.Employee;
import com.self.test.EmployeeServiceTest;
import com.self.vo.Engineer;
import com.self.vo.Manager;
import com.self.vo.Secretary;

public class EmployeeService {

	Employee[] emps;
	int idx = 0;
	
	public EmployeeService(int size){
		emps = new Employee[size];
	}
	/**
	 * @param Manager 직원을 추가하는 기능
	 * @return 추가된 결과
	 */
	public void addEmployee(Employee e) {	
		if(idx<emps.length)
		emps[idx++]= e;
		System.out.println(">>>>"+e.getName()+"님 정보가 성공적으로 저장되었습니다.");
	}
	/**
	 * @param 각 파트별 정보를 출력하는 기능
	 * @return 파트별 정보
	 */
	public void printEmployee(String part) {
		for(Employee e : emps) {
			if(part.equals("Manager")) {
				if(e instanceof Manager) {
					System.out.println(((Manager) e).toString());
				}
			}
			if(part.equals("Engineer")) {
				if(e instanceof Engineer) {
					System.out.println(((Engineer) e).toString());
				}
			}
			if(part.equals("Secretary")) {
				if(e instanceof Secretary) {
					System.out.println(((Secretary) e).toString());
				}
			}
			if(part.equals("All")) {
				if(e!=null)
					System.out.println(e.toString());
			}
		}
	}
	/**
	 * @param 해당하는 사원명을 입력해 정보를 삭제하는 기능
	 * @return 정보를 삭제
	 */
	public void deleteEmployee(String name) {	
		boolean result = false;
	    int index = 0;

	    for (int i = 0; i < emps.length; i++) {
	        if (emps[i] != null && emps[i].getName().equals(name)) {
	            index = i;
	            result = true;//찾으면 true -> 멈춤
	            break;
	        }
	    }
	    if (result) {
	        for (int i = index; i < emps.length - 1; i++) {
	            emps[i] = emps[i + 1];
	        }
	        emps[emps.length - 1] = null;
	        System.out.println(">>>>" + name + "님의 정보가 삭제되었습니다.");
	    } else {
	        System.out.println(">>>>" + name + "님을 찾을 수 없습니다.");
	    }
	}
	/**
	 * @param 입력된 정보를 수정하는 기능
	 * @return 정보를 수정
	 */
	public void updateEmployee(Employee e) {
		boolean updated = false;
			
	    for (int i = 0; i < emps.length; i++) {
	        if (emps[i] != null && emps[i].getName().equals(e.getName())) {
	            emps[i] = e;
	            updated = true;
	            break;
	        }
	    }
	    if (updated) {
	        System.out.println(">>>>" + e.getName() + "님의 정보가 업데이트되었습니다.");
	    } else {
	        System.out.println("업데이트할 직원을 찾지 못했습니다.");
	    }
	}
	/**
	 * @param 이름으로 입력된 정보를 검색하는 기능
	 * @return 검색한 정보를 출력
	 */
	public Employee findEmployee(String name) {
		System.out.println(">>>>검색하신 "+name+"님의 정보입니다.");
		for(Employee e : emps) {
			if(e==null) continue;
			if(e.getName().equals(name)) { 
				System.out.println(e.toString()); //찾으면 반환
				return e;
			}
		}return null;//못찾으면 반환X
	}
	/**
	 * @param 부서번호로 입력된 정보를 검색하는 기능
	 * @return 검색한 정보를 출력
	 */
	public Employee findEmployee(int deptno) {
		Employee[ ] temp = new Employee[emps.length];
		int midx = 0;
		
		for(Employee e : emps) {
			if(e==null) continue;//
			if(e instanceof Manager)
			if(((Manager)e).getDeptno()== deptno) { 
				temp[midx++] =e;
				System.out.println(e.toString()); //찾으면 반환
			}
		}
		return null;
	}
	/**
	 * @param 총 연봉, 평균 연봉 산출하는 기능
	 * @return 총 연봉, 평균 연봉 산출
	 */
	public void salaryInfoEmployee(String part) {
		double AnnualSalary = 0;	
		double averageAnnualSalary = 0;
		double managerBonus =0;
		int count = 0;
		
		for (Employee e : emps) {
	        if(part.equals("Manager")) {
	        	if(e instanceof Manager) {
	        		AnnualSalary += ((Manager) e).getSalary()*12;
	        		count++;
	        	}
	        }
	        if(part.equals("Engineer")) {
	        	if(e instanceof Engineer) {
	        		AnnualSalary += ((Engineer) e).getSalary()*12+((Engineer) e).getBonus();
	        		count++;
	        	}
	        }
	        if(part.equals("Secretary")) {
	        	if(e instanceof Secretary) {
	        		AnnualSalary += ((Secretary) e).getSalary()*12;
	        		count++;
	        	}
	        }
    		if(count>0) averageAnnualSalary = AnnualSalary/count;
    		
		}
		System.out.println(part+"> 총 연봉 : "+AnnualSalary);
		System.out.println(part+"> 평균 연봉 : "+Math.round(averageAnnualSalary* 10.0) / 10.0);
	}
	/**
	 * @param 총 인원수 산출하는 기능
	 * @return 총 인원수 산출
	 */
	public void countEmployee(String part) {
		int count = 0;
		
		for (Employee e : emps) {
	        if(part.equals("Manager")) {
	        	if(e instanceof Manager) {
	        		count++;
	        	}
	        }
	        if(part.equals("Engineer")) {
	        	if(e instanceof Engineer) {
	        		count++;
	        	}
	        }
	        if(part.equals("Secretary")) {
	        	if(e instanceof Secretary) {
	        		count++;
	        	}
	        }
	        if(part.equals("All")) {
	        	if(e != null)
	        		count++;
	        }
		}
		System.out.println(part+"> 총 인원수 : "+count);
	}
	//singleton 
	private static EmployeeService esvc = new EmployeeService();
	private EmployeeService() {}
	public static EmployeeService getInstance() {
		return esvc;
	}	
	//직원 등록 여부 확인(싱글톤 활용하기)
	public void register(String name) {
		System.out.println(name+"님의 그룹웨어 가입이 완료되었습니다.");
	}
}




