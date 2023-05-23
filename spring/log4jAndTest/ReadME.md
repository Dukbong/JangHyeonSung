## Junit
자바와 JVM계열의 언어에서 사용하는 **단위 테스트 프레임워크**를 말한다.

### 사용법
우선 정상적인 진행을 위해 비교적 최근이며 오류가 없는 버전으로 바꿔줘야 한다.<br>
1. Maven repository에서 [apache log4j](https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core)를 복사하여 groupId가 log4j인 곳에 붙여넣어준다.<br>
   - 이 과정은 log4j의 버전을 변경한다.<br>
2. Maven repository에서 [Junit](https://mvnrepository.com/artifact/junit/junit)를 복사하여 groupId가 junit인 곳에 붙여넣어준다.<br>
   - 이 과정은 log4j의 버전을 변경한다.<br>
3. Test 환경을 설정해준다.<br>
```
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>${org.springframework-version}</version>
    <!-- 이때 버전은 상단의 properties에 정의되어있다. -->
  </dependency>
```

### log4j 설정 방법 및 기본 내용
---

#### log4j의 메세지 순서 (1번이 가장 낮은 순위를 가진다.)
 1. TRACE : 너무 프로그램내에서 발생하는 사소한 기록 (**작성 불가**)
 2. DEBUG : 개발할때 필요에 의해서 확인해야하는 부분에 대한 기록
    - 기존에 System.out.println()으로 확인하는 것(휘발성)을 log4j로 할 수 있다.
 3. INFO : 사용자에게 알려줘야 하는 정보에 대한 기록
 4. WARN : 실행은 되지만 문제가 생길 수 있는 경우 기록
    - 노란줄로 알려주는 정도 레벨의 문제
 5. ERROR : 실행이 안되는 경우의 기록
 6. FATAL : 시스템에 치명적인 오류의 기록 (**작성 불가**)

#### log4j의 설정 태그와 역할
1. logger : logging을 수행하기 위한 도구 (Logger) 설정
2. root : 전반적인 logging 설정 (logger에서 설정하고 남은 설정을 말한다.)
3. appender : 로깅의 대상을 설정하는 도구

#### 사용 가능한 appender
1. consoleAppender : console에 출력하는 도구
2. FileAppender : 파일로 저장하는 도구
3. DailyRollingFileAppender : 날짜 별로 파일에 출력하는 도구
4. RollingFileAppender : 용량별로 구분하여 출력하는 도

#### Appender 설정
```
<appender name="name" class="org.apache.log4j.[consoleAppender, FileAppender, DailyRollingFileAppender, RollingFileAppender]>
   <!-- consoleAppender -->
  <param name="paramName" value="System.out">
   <!-- FileAppender -->
   <!-- path 생략시 프로젝트 바로 아래에 생성된다. -->
   <!-- 실제로는 없지만 path에 있는 폴더의 경우 자동으로 생성된다. -->
  <param name="file" value="path/file_name">
   <!-- 기존 파일에 계속 내용을 추가 : true // 기존 파일에 덮어쓰기 : false -->
  <param name="append" value="true">
  
   <!-- 가장 일반적인 형태 -->
  <layout class="org.apache.log4j.PatternLayout">
    <param name="ConversionPattern" value="%-5p: %c - %m (%d)%n"/>
  </layout>
</appender>
```


pom.xml
Junit과 apache Log4j 버전 확인 후 비교적 안정적인 최근 버전으로 설정 바꾸기.

- log4j
<img width="514" alt="image" src="https://github.com/Dukbong/JangHyeonSung/assets/37864182/e7407819-a9dc-4494-b16e-0ed22597abe2">

<br>

- Junit<br>
<img width="346" alt="image" src="https://github.com/Dukbong/JangHyeonSung/assets/37864182/393b6072-53f9-4114-8ffe-f52c33172625">
<br>

- test할 수 있는 환경 추가
<br>
<img width="343" alt="image" src="https://github.com/Dukbong/JangHyeonSung/assets/37864182/ed4d6c2c-23f3-4c1e-a4ac-5a9d931efa59">



<br><br>

