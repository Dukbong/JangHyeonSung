Error Message : <br>
java.util.concurrent.ExecutionException: org.apache.catalina.LifecycleException:<br>
구성요소 [StandardEngine[Catalina].StandardHost[localhost].StandardContext[/sc]]을(를) 시작하지 못했습니다.

---

Error Alert : <br>
<img width="300" alt="image" src="https://github.com/Dukbong/JangHyeonSung/assets/37864182/e2427b6a-2d5e-4fc2-abac-28c57c151102">

---
<br><br>
해결 방법
1. Spring과 연결하는 도구를 의존성 주입할때 Spring버전과 같은 버전으로 설정해줘야한다.

```
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>${org.springframework-version}</version>
</dependency>
```
