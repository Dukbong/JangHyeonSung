아직 정리 안되 내용
---

1. @RequestParam(value="name", requried="true|false", defaultValue="default_value") int test
   - 이 어노테이션은 int test로 줄여수 쓸 수 있다.
   - requried가 true이면서 값이 null이 나온다면 클라이언트 에러 (400)
   - requried가 false이면서 값이 null이 나온다면 서버 에러 (500)


2. cmd로 폴더을 생성할때 있다면 건너뛰고 없다면 만들는 방법
   - mkdir folder_name\folder_name ...
   - 이때 만약 해당 folder_name이 있다면 그 안에 들어가서 다음 폴더를 만든다.
