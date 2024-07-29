package com.edu.condition.test3;

import java.util.Scanner;


public class Pattern369Test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("2자리 숫자 입력 >> ");
        int n = sc.nextInt();
        
        // solv 메소드 호출 및 결과 출력
        solv(n);
        
        sc.close();
    }
    
    public static void solv(int number) {
        if (number % 3 == 0) {
            System.out.println("3의 배수입니다.");
        } else {
            System.out.println("3의 배수가 아닙니다.");
        }
    }

}
