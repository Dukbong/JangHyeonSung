#### Method Chaining
<br>
Method Chaining은 메소드를 연결고리 처럼 나열하며 사용하는 것을 말한다. <br>

```
// VO Class 
public class Test{
    private String userId;
    private String userPwd;
    
    public Test(){}
    public Test(String userId, String userPwd){
        this.userId = userId;
        this.userPwd = userPwd;
    }
    
    public void setUserId(String userId){
        this.userId = userId;
    }
    public void setUserPwd(String userPwd){
        this.userPwd = userPwd;
    }
}

//--------------------------------------------
public class Use{
    Test t = new Test();
    t.setUserId("test");
    t.setUserPwd("test");
}
```
<br><br>
일반적인 방법으로 사용할 경우 이렇게 하나하나 작성해줘야 하지만 메소드 체이닝을 이용하면 한줄로 간단하게 작성할 수 있다.
```
// VO Class 
public class Test{
    private String userId;
    private String userPwd;
    
    // ...생략
    
    public Test setUserId(String userId){
        this.userId = userId;
        return this;
    }
    public Test setUserPwd(String userPwd){
        this.userPwd = userPwd;
        return this;
    }
}

//--------------------------------------------
public class Use{
    Test t = new Test();
    t.setUserId("test").setUserPwd("test");
}
```

#### 메소드 체이닝의 장단점
장점 : 코드가 줄어들고 한줄로 간편하게 입력이 가능하다.
단점 : 디버깅시 오류를 찾기가 어려워진다.
