package com.edu.condition.test3;

import java.util.Scanner;

public class Pattern369Test2 {

    public static void solv(int number) {
        // 십의 자리와 일의 자리 숫자 추출
        int tensDigit = number / 10; // 십의 자리 숫자
        int onesDigit = number % 10; // 일의 자리 숫자
        
        // 숫자가 3의 배수인지 판별하여 결과 문자열 생성
        String result = "";
        
        if (tensDigit % 3 == 0) {
            result += "@";
        }
        
        if (onesDigit % 3 == 0) {
            result += "@";
        }
        
        // 결과 출력
        if (result.isEmpty()) {
            System.out.println(number); // 3의 배수가 없는 경우 숫자 출력
        } else {
            System.out.println(result); // 결과 문자열(@ or @@) 출력
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("2자리 숫자 입력 >> ");
        int n = sc.nextInt();
        
        solv(n); // solv 메소드 호출
        
        sc.close();
    }

}