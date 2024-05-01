package com.devhouse.example2.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * 주소 구조
 * - 메인주소/ 컨트롤러맵핑주소/함수맵핑주소
 * 메인주소 : 로컬에서 키면 localhost : 내가 설정한 포트
 *
 * - application.properties 에 있고, port 라는 녀석이다.
 * - localhost : 16830/cmm/test.api
 * portNumber/mappingUrl/꼬리url
 * */

@RestController
@RequestMapping("/cmm")
public class testController2 {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    /*
    * 컨트롤러 생성시 규칙
    * 앞에 대문자
    * 뒤에 소문자
    * testController2
    *
    * 함수
    * 앞에 소문자
    * 특이점 있을 때 대문자를 쓴다.
    * - testFunction
    *
    * 변수명
    * - 소문자로 시작한다.
    *
    * 함수 만드는 방법
    * - 앞에 타입 붙임 : public / private - 오픈되어 있는지, 함수안에 갇혀 있는지
    * - 뒤에 리턴 타입 : String, Int, Void 등
    * - 이름
    *
    **/

    /* 함수 예제 생성 */
    public void test() {
        String test = "1";
        String test2 = "10";

        int testNum = 1;
        int testNum2 = 2;

        boolean test22 = false; // true : false

        Double db1 = 1.0; // 소수점

        // 사칙연산
        int cnt1 = 1;
        int cnt2 = 5;

        // 덧샘
        int sum = cnt1 + cnt2;

        // 뺄셈
        int sum2 = cnt1 - cnt2;

        // 곱셈
        int sum3 = cnt1 * cnt2;

        // 나누기
        int sum4 = cnt1 / cnt2;

        // 나머지
        int sum5 = cnt1 % cnt2;

        //-----------------------------
        /* 배열 만드는 방법 */
        ArrayList<Integer> intArray = new ArrayList<>();
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        intArray.add(4);
        intArray.add(5);

        for(int cnt : intArray) {
            logger.info("cnt" + cnt);
        }

        // while 문
        while (cnt1 < 10) {
            cnt1 += 1;
        }


        // switch
        switch (cnt1) {
            case 0:
                logger.info("is Test");
            default:
                break;
        }

    }

    @GetMapping("/jangTest.api")
    public Map<String, Object> showMap() {
        int jangTestCnt = 0;
        while(jangTestCnt < 10) {
            jangTestCnt += 1;
        }

        Map<String, Object> jangTest = new HashMap<>();
        jangTest.put("test","test");

        return jangTest;
    }

    @PostMapping("/jangTest2.api")
    public Map<String, Object> shopMap2() {
        int jangTestCnt2 = 0;
        while(jangTestCnt2 < 10) {
            jangTestCnt2 += 1;
        }

        Map<String, Object> jangTest2 = new HashMap<>();
        jangTest2.put("jangTest2", jangTestCnt2);

        return jangTest2;
    }

}
