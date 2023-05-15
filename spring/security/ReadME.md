#### Spring Security
회원가입 진행 시 비밀번호가 노출되는 것을 막기 위해 사용하는 라이브러리(Bcrypt)<br>
(maven - core, web, cofing)
- 이 외에도 java에서 제공하는 SHA-256 + salt을 이용해서 별도로 암호화 처리를 해줘도 된다. (단방향성)

```
// SHA-256 + salt 사용
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

// ... 생략
String pwd = "test";
String salt = "salt";
MessageDigest md = MessageDigest.getInstance("SHA-256");
md.update((pwd+salt).getBytes());
byte[] pwdArr = md.digest();
StringBuffer sb = new StringBuffer();
for(byte b : pwdArr){
    sb.append(String.format("%02x", b));
}
pwd = sb.toString();
```

<hr><br>
spring-security는 외부 라이브러리이기 때문에 bean 등록을 해줘야 사용할 수 있다.
- root-context.xml에 해도 되지만 만약 별도의 xml파일에서 만들어주려면 xml이 아닌 Spring Bean Configuration File로 만들어줘야한다.
- 그 후 Next를 눌러 beans와 외존성 주입으로 생긴 security를 선택하여 만들어 주면 된다.

```
<bean class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder" id="bcryptPasswordEncoder"/>
<!-- 지금부터 이 class file을 bcryptPasswordEncoder라고 부르겠다. -->
```
