### 개발 환경 : STS(java 1.8) Spring(5.2.24.RELEASE) mybatis JSTL maven 

#### 1. 기본 환경 설정<br>
encoding / pom.xml(java version check) & spring version check

#### 2. <b>[library](https://mvnrepository.com/)</b> (pom.xml - dependencies)<br>
필요한 library를 찾은 후 Maven 형식의 dependency를 복사 후 pom.xml에 있는 dependencies tag안에 넣는다.<br>
  - 만약 해당 library의 아래 Note:this artifact is located at [library_name] repository(library_url)처럼 별도의 경로가 주어 질 경우 <br>
  dependencies tag보다 위쪽에 해당 library의 경로를 불러올 수 있도록 추가 해줘야 한다. <br><br>
&lt;repositories&gt;<br>
&nbsp;&nbsp;&nbsp;&nbsp;&lt;repository&gt;<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;id&gt;"library_name" &lt;/id&gt;<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;url&gt;library_url &lt;/url&gt;<br>
&nbsp;&nbsp;&nbsp;&nbsp;&lt;/repository&gt;<br>
&lt;/repositories&gt;<br><br>
- DB와 mybatis를 Spring에서 사용하기 위해서는 서로를 연결해주는 xxx-spring library가 필요하다.<br>
=> spring-jdbc : 이때 library의 version은 Spring과 맞추는것이 좋을 거 같다. <br>
=> mybatis-spring
<br><br>
- 그 외 Connection pool을 관리 해줄 commons-dbcp library 추가

<br><br>
#### 3. mybatis 설정
처음에는 한개의 xml파일에서 DB의 정보, Setting, mapper의 resource등을 작성했지만 실제로 DB의 정보는 서버가 구동됨과 동시에 설정되어야 하기 때문에 별도의 <b>root-context.xml</b>이라는 파일에서 설정해준다.

1. (Source Folder)src/main/resource/mybatis-config.xml
```
<!-- mybatis 설정 -->
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-config.dtd">
  
<configuration>
    <settings>
        <setting name="jdbcTypeForNull" value="NULL"/>
    </settings>
    
    <!-- 여기서 설정된 mapper들만 사용 가능하다. -->
    <mappers>
        <mapper resource="mapper의 경로" />
        <mapper resource="/mappers/example/example-mapper.xml" />
    </mappers>
</configuration>
```
2. (Folder)src/main/webapp/WEB-INF/spring/root-context.xml
```
<!--
    property : setter
    constructor-arg : 생성자
-->
<!-- 1단계 DB에 사용될 기본 정보 설정 -->
<!-- class: 실제 class Full Name / id : bean에서 불릴 식별자 -->
<bean class="org.apache.commons.dbcp.BasicDataSource" id="dataSource">
    <!-- 여기서 쓰는 name은 개발자가 정하는게 아닌 class에서 정해진 이름이다. -->
    <properties name="driverClassName" value="oracle.jdbc.driver.OracleDriver" />
    <!-- BasicDataSource class를 dataSource라고 칭하며 변수 driverClassName에 oracle.jdbc.driver.OracleDriver를 대입-->
    <properties name="username" value="DB_ID" />
    <properties name="password" value="DB_PWD" />
    <properties name="url" value="jdbc:oracle:thin:@localhost:1521:xe" />
</bean>

<!-- 2단계 Spring에서 mybatis를 통해 SQL 구문 등록을 위한 도구 -->
<bean class="org.mybatis.spring.SqlSessionFactoryBean" id="sqlSessionFactory">
    <!-- classpath:는 (source Folder)src/main/resource를 나타낸다. -->
    <!-- value : "삽입되는 값" / ref : "다른 bean을 참조해서 대입하는 값( 객체 )"-->
    <properties name="configLocation" value="classpath:mybatis-config.xml"/>
    <properties name="dataSource" ref="dataSource">
</bean>
<!--
    SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactroyBean();
    sqlSessionFactory.setConfigLocation("classpath:mybatis-config.xml");
    sqlSessionFactory.setDataDource(dataSource);
-->

<!-- 3단계 SQL구문을 위한 Template을 제공하는 도구 등록 -->
<bean class="org.mybatis.spring.SqlSessionTemplate" id="sqlSession">
    <constructor-arg ref="sqlSessionFactory"/>	 	
</bean>
<!--
    SqlSessionTempate sqlSession = new SqlSessionTemplate(sqlSessionFactoyr);
-->
```
<br><br>
#### 4. 왜 index.jsp가 가장 먼저 열리고 root-context.xml이 가장 먼저 읽히는걸까?
```
우선 서버가 구동되면 Server쪽에 있는 web.xml파일을 가장 먼저 읽게 되는데 이때 welcomePage 및 다양한 기본적인 library가 설정되어 있습니다.
그리고 난 후 Project에 있는 web.xml을 읽게 되고 Project의 web.xml에서는 상단에서 root-context.xml을 읽으라는 명령이 있기 때문이다.
<!-- 다시 작성 할것 -->
```
<br><br>
#### 5. Spring에서는 @(이노테이션)을 통해 Controller 및 MappingRequest등을 할 수 있는 이유

```
<!-- servlet-context.xml파일에 작성되어 있다. -->
<!--
  annotation-driven은 Spring 3.0부터 제공하는 mvc 태그이다.
  Annotation기반의 Controller 호출이나 필요한 bean설정을 편리하게 하기 위해서 만들어졌다.
  Spring MVC @Controller에 요청을 보내기 위해 필요한 HandleMapping과 HandlerAdapter를 Bean에 등록한다.
  - HandleMapping : Http 요청 정보를 이용해서 컨트롤러를 찾아주는 기능
  - HandleAdapter : HandleMapping을 통해 찾은 컨트럴러를 직접 실행하는 기능 수행
-->
<annotation-driven/>

<!--
  context:component-scan은 특정 패키지 내의 클래스를 스캔하고
  1. @Component
  2. @Controller (컨트롤러)
  3. @Service (서비스)
  4. @Repository (Dao)
  이 4가지를 확인하여 Bean인스턴스로 생성한다.
  context:component-scan을 선언했다면 context:annotation-config을 선언할 필요가 없다.
-->
<context:component-scan base-package="기본 패키지 경로"/>

<!--
  annotation-driven과 context:component-scan base-package="기본 패키지 경로"를 통해 어노테이션을 bean에 등록해준다.
  base-package에서 설정한 기본 패키지 경로 이하 패키지를 모두 감시하여 등록 가능한 도구(component)를 찾아 자동등록 해주는 구
-->
```
