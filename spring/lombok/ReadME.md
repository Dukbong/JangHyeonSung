#### lombok
lombok은 VO에서 getter, setter, 생성자, toString등 자동으로 처리해주는 라이브러리이다. <br><br>
- 해당 라이브러리는 의존성 주입뿐만 아니라 별도의 설치(.jar)를 해주어야한다.
<br>
설치 시 경로는 해당 프로그램의 경로를 잡으면 된다.<br>
예시) C:/STS/STS-bundle/STS-1.1.1.RESESSES/STS.exe
<hr>
만약 실행되지 않으면 해당 경로로 가서 아래 명령어를 실행해서 열면 된다. 

```
java -jar lombok-[version].jar
```

<br>

#### lombok 어노테이션의 기본 종류

1. @Setter (setter를 만들어준다.)<br>
2. @getter (getter를 만들어준다.)<br>
3. @ToString (toString을 만들어준다.)<br>
4. @NoArgsConstructor (기본 생성자)<br>
5. @AllArgsConstructor (모든 필드값을 매개변수로 하는 생성자)<br>
6. @EqualsAndHashCode (equals와 hashCode 메서드)<br>
7. @Data (getter setter argsConstructor toString equlasAndHashCode 를 한번에) <br><br>

