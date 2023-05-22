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
Log4의 설정 파일
1. log4j의 메세지 체계
  1. TRACE : 너무 프로그램내에서 발생하는 사소한 기록 (작성 불가)
  2. DEBUG : 개발할때 필요에 의해서 확인해야하는 부분에 대한 기록
    - 기존에 System.out.println()으로 확인하는 것을 log4j로 할 수 있다.
  4. INFO : 사용자에게 알려줘야 하는 정보에 대한 기록
  5. WARN : 실행은 되지만 문제가 생길 수 있는 경우 기록
    - 노란줄로 알려주는 정도 레벨의 문제
  7. ERROR : 실행이 안되는 경우의 기록
  8. FATAL : 시스템에 치명적인 오류의 기록 (작성 불가)
