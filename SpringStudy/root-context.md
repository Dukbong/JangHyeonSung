## 프레임워크의 이해
프레임워크는 프로그램이 실행되는 기본 구조이며 프로그램 전체적인 흐름과 공통적으로 적용할 로직을 미리 만들어둔 것이다.<br>
이러한 특성 중 **IOC(제어의 역전)** 에 집중하기로 했다.<br>
※IOC : 개발자가 아닌 프레임워크가 라이프 사이클을 관리하게 만든다. <br><br>

- 이러한 이유로 평소에 mybatis-config에서 mapper를 찾던 행위를 SqlSessionFactoryBean을 Bean등록할때 mapper를 찾게 만든다.