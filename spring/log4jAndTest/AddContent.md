## lombok의 Builder
Spring은 프레임워크 이기 때문에 loC(inversion of Control)의 특징을 가지고 있다.<br>
이 특징은 제어(객체의 생명주기 관리 및 제어권)가 개발자가 아닌 프레임 워크라는 뜻이다.<br>
그런 이유로 **new 연산자를 사용하지 않는것이 좋다.**
<br><br>

### Builder Annotataion
lombok 라이브러리에서 제공하는 @Builder를 사용하면 new 연산자를 사용하지 않고 객체를 생성할 수 있다.

```
@Builder
public class Member{
    private String name;
    private int age;
}
```
