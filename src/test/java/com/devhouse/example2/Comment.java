package com.devhouse.example2;

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
 * 주소구조
 * - 메인주소/컨트롤러맵핑주소/함수맵핑주소
 * - 메인주소 : 로컬에서 키면 localhost:내가 설정한 포트
 *
 * - application.properties 에 있고, port 라는 녀석임
 * - localhost : 16030
 *
 * - localhost : 16830/cmm/test.api
 *
 * */

@RestController
@RequestMapping("/cmm")
public class Comment {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    /*
    * 컨트롤러 생성시 규칙
    * - 앞에 대문자
    * - 뒤에 소문자고, 특이점 있을 때 대문자 변경
    * - TestController
    *
    * 함수
    * - 소문자로 시작
    *
    *
    * 함수 만드는 방법
    * - 앞에 타입 붙임 : public / private - 오픈되어 있는지, 함수가 클래스 안에 갇혀 있는지 표시
    * - 뒤에 리턴 타입 : String, Int, Void 등
    * - 이름
    * */

    // 함수 생성 예제
    public void test() {
        String test = "1";
        String test2 = "test";

        int testNum = 1;
        int testNum2 = 10;

        boolean test22 = false; // true ? false

        Double db1 = 1.0; // 소수점

        // 사칙연산
        int cnt1 = 1;
        int cnt2 = 10;

        // 덧샘
        int sum = cnt1 + cnt2;
        int sum1 = cnt1 - cnt2;
        int sum2 = cnt1 * cnt2;
        int sum3 = cnt1 / cnt2;
        int sum4 = cnt1 % cnt2;

        // for 문
        ArrayList<Integer> intArray = new ArrayList<>();
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        intArray.add(4);
        intArray.add(5);

        for(int cnt : intArray) {
            logger.info("test" + cnt);
        }

        // while
        while (cnt1 < 10) {
            cnt1 += 1;
        }

        // switch
        switch (cnt1) {
            case 0:
                logger.info("is Test");
                break;
            default:
                break;
        }
    }


    @GetMapping("/jang.api") // 꼬리 url
    public Map<String, Object> showMap() {
        int jangCnt = 0;
        while(jangCnt < 10) {
            jangCnt = jangCnt + 1;
        }

        Map<String, Object> jang = new HashMap<>();
        jang.put("jang", "test");

        return jang;
    }

    @PostMapping("/jang2.api")
    public Map<String, Object> showMap2() {
        int jang2Cnt = 0;
        while (jang2Cnt < 10) {
            jang2Cnt = jang2Cnt + 1;
        }

        Map<String, Object> jang2 = new HashMap<>();
        jang2.put("jang2", "test");

        return jang2;
    }
}

/*
    1. mybatis : 데이터 베이스와 스프링 서버간에 데이터를 주고 받기 위해 필요한 일종의 도구이다. (점원)

    * CRUD ( Create Read Update Delete)
    * 2. Mapper [xml] : mybatis 에게 CRUD xml 문서 (주문서)
    * 3. @mapper => xml 에서 받은 데이터를 자바의 객체로 만들어준다.
    * 4. @service => 데이터를 처리하거나 가공하는 곳, 데이터 형태를 변경하기도 하고, 외부와 통신이 필요할 때도 여기서 함.
    * 5. @Controller / @RestController => 프론트 파라미터를 받는 부분, 그리고 가공 된 데이터를 리턴하는 부분
    * - 얘넨 그래서 호출 주소를 가지고 있음, GET / POST 메소드 여부도 가지고 있음
    * - RestController : 객체를 리턴하거나 Map리턴함, 이거를 자동으로 JSON 바꿔서 보여줌.
    * - Controller : 템플릿을 쓰는 웹에서 사용을 하고, 템플릿 주소를 반환해서, 해당 템플릿의 html표현하는데 씀.

    * #흐름도 (구글에 검색 시 어노테이션 컨트롤러 하나씩 검색해보기)
    * 기본 : @Controller OR @RestController (주소를 호출함, 해당 메소드에게 맞게) -> 컨트롤러에 있는 전처리단 로직을 탐 -> Service에 잇는 함수를 호춯함, 즉 서비스 함수 로직을 탐
    * -> mapper 한테 데이터를 요청함 -> mapper xml에 있는대로 mybatis에 데이터를 요청함 -> 이거를 다시 반환을 받아서 mapper가 service로 던져즘 -> Service 는 나머지 가공처리 -> Controller에 넘김 -> 이걸 컨트롤러는 반환함. (JSON)
 */
