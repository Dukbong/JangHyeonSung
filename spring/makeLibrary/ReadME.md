#### 나만의 라이브러리 만들기

필수사항 : Maven 설치




라이브러리 생성 및 jar파일로 만들기
---
1. Maven Project 생성
2. Select ArchetType
   - GropId filter : org.apache.maven.archetypes
   - Artifact Id : maven-archetypes-quickstart (빠른생성)
3. Enter the artifact Id
   - ex) Group Id : com.duk
   - ex) Artifact Id : bong
   - Package : com.duk.bong
4. pom.xml에 <packaging>jar</packaging> 추가
5. maven.complier.source와 maven.complier.target의 버전을 나에게 맞게 변경
6. 필요한 Library를 [Maven Repository](https://mvnrepository.com/)에서 찾아서 pom.xml에 dependency로 의존성을 주입해준다.
7. Package 이하에서 class들을 만들어서 나만의 라이브러리를 만든다.
8. project 우클릭 후 Run As -> Maven install 
   - Maven default(build) : 일반적인 빌드 프로세스를 위한 모델
   - Maven clean : 빌드시 생성되었던 파일들을 삭제하는 단계
   - Maven validate : 프로젝트가 올바른지 확인하고 필요한 모든 정보를 사용할 수 있는지 확인하는 단계
   - Maven complie : 소스 코드를 컴파일해서 클래스 출력 폴더에 클래스를 생성한다.
   - Maven test : 테스트를 실행한다.
   - Maven package : 컴파일 된 코드와 자원 파일들을 jar or war같은 배포 형식으로 패키징한다.
   - Maven verify : 통합 테스트 결과에 대한 검사를 실행하여 품질 기준을 충족한는지 확인하는 단계
   - Maven install : local repository에 패키지를 복사한다.
   - Maven deploy : 원격 repository에 등록하여 다른 프로젝트에 사용할 수 있다.
   - ** test를 하면 test만 하는게 아니라 그 전 단계를 모두 자동으로 수행 후 실행된다.
9. 이때 Maven install된 파일은 user/.m2/repository로 저장된다.

만든 라이브라이를 프로젝트에 dependency로 의존성 주입하기
---
1. Spring Legacy Project 생성
2. Spring MVC Project 생성
3. Package 설정 (ex: com.duk.bong)
4. Window -> Show View -> Maven Repository
5. Maven Repository -> local Repository 우클릭 -> Rebuild Index
6. 해당 Project의 pom.xml에서 하단에 있는 dependencies 클릭
7. Add 클릭 후 라이브러리의 Artifact Id 입력
   - 모르는 경우 저장된 경로를 보면 ex) com.duk.bong에서 bong이 Artifact Id이다.
8. 프로젝트 우클릭 -> Maven -> Update Project 클릭
   - pom.xml에 변경시 생길 경우 꼭 UpdateProject를 해줘야 적용이 된다.
9. Maven Dependencies를 보면 내가 만든 라이브러리가 담겨있는 것을 확인할 수 있다.
   - 궁금한 사항 : 이건 왜 다른 라이브러리랑 다른곳에 저장될까? 같이 저장하고 싶은데...
10. 이제 src/main/java/Package 이하에서 라이브러리를 사용할 수 있다.
