#### spring filter

기본적으로 Client | filter | Server 이런 진행 방향을 가진다. <br>
요청(request)과 응답(response) 양방향으로 filter를 거쳐서 이동한다. <br>
<hr>

```
<!-- 기본적인 구조 -->
<filter>
  <filter-name>Filter_Name</filter-name>
  <filter-class>org.springFramwork.web.filter.CharacterEncodingFilter</filter-class>
  <!-- 위에 있는 class는 Spring에서 기본적으로 제공하고 있는 클래스이며 이걸 사용하겠다는 말이다. -->
  
  <init-param>
    <param-name>encoding</param-name>
    <param-value>UTF-8</param-value>
  </init-param>
  <!-- 해당 class 파일을 열어보면 encoding이라는 매개변수가 있고 이 매개변수에 UTF-8을 넣겠다는 말이다. -->
  
  <init-param>
    <param-name>forceEncoding</param-name>
    <param-value>true</param-value>
  </init-param>
  <!-- 해당 class 파일을 열어보면 forceEncoding이라는 매개변수가 있으며 타입은 Boolean이고 true를 넣겠다. -->
  <!-- true로 할 경우 인코딩 충돌문제가 발생하면 강제로 위에서 지정한 UTF-8로 하겠다는 의미다. -->
</filter>
```
