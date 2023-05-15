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

<hr>
spring-security는 외부 라이브러리이기 때문에 bean 등록을 해줘야 사용할 수 있다.
