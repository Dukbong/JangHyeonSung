아직 정리 안되 내용
---

1. @RequestParam(value="name", requried="true|false", defaultValue="default_value") int test
   - 이 어노테이션은 int test로 줄여수 쓸 수 있다.
   - requried가 true이면서 값이 null이 나온다면 클라이언트 에러 (400)
   - requried가 false이면서 값이 null이 나온다면 서버 에러 (500)


2. cmd로 폴더을 생성할때 있다면 건너뛰고 없다면 만들는 방법
   - mkdir folder_name\folder_name ...
   - 이때 만약 해당 folder_name이 있다면 그 안에 들어가서 다음 폴더를 만든다.


3. sqlSession 과 sqlSessionTemplate 차이
- sqlSession은 SqlSeSsionFactory를 통해 단순하게 만들 수 있다.
- 닫거나 이런거 직접 해줘야한다.
- 단순하게 SqlSessionFactory를 통해 단순하게 생성된 아이여서 Thread-Safe를 지원하지 않아 요청마다 객체 생성과 close를 해주어야 한다.

sqlSessionTemplate은 mybatis spring module의 핵심이다.
sqlSessionTemplate은 sqlSesion을 구현한거라서 sqlSession을 대체할 수 있다.
여러개의 Dao나 매퍼에서 공유할 수 있다.

쉽게 sqlSession 인터페이스를 구현했다 스레드에 안전하다., 트랙잭션 관리용 이라고 보면 된다.
이건 자동으로 닫고 해준다.
