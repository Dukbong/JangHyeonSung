# Spring-Interceptor
DispatcherServlet과 Controller사이에 있는 요청과 응답에 대해 먼저 확인하는 역할을한다.

## Interceptor의 구현 및 기능
상속과 구현의 차이는 **강제성** 에 있다.
<br>
### 구현 방법
1. 상속을 통한 구현
```
public class InterceptorTest extends HandlerInterceptor{}
```
2. 구현을 통한 구현
```
public class InterceptorTest implements HandlerInterceptor{}
```

### 주요 메서드
기본적으로 메서드들은 HttpServletRequest, HttpServletResponse, Object를 매개변수로 받는다.
1. preHandle : DispatcherServlet -> ***preHandle*** -> Controller
2. postHandle : Controller -> ***postHandle*** -> DispatcherServlet
3. afterHandle : DispatcherServlet -> ***afterHandle*** -> viewResolver
- 반환값
- true : 문제가 없기 때문에 흐름을 유지한다.
- false : 문제가 있기 때문에 별도의 Controller로 흐름을 바꿔줄 수 있다.

<br>

## Interceptor의 등록 시점
기본적으로 DispatcherServlet 이후의 흐름에 대해 확인하는 것이기 때문에 **servlet-context.xml**에서 등록해줘야 한다.

### 등록 방법
```
<interceptors>
    <mapping path:"/*">
    <beans:bean class="Interceptor Class를 상속 및 구현해서 만든 클래스의 위치" id="해당 클래스의 별칭">
</interceptors>
```

### Interceptor 똑똑하게 사용하기
1. mapping path 설정
- Controller의 Mapping주소가 "xx.me" 이런식으로 작성되어있을때는 아래와 같이 작성할 수 있다.
```
<mapping path:"/*.me">
```
2. mapping path를 포괄적으로 잡은 후 exclude-mapping으로 특정 Mapping주소는 제외시킬 수 있다.
```
<mapping path:"/*.me">
<exclude-mapping path:"/enrollForm.me">
```
