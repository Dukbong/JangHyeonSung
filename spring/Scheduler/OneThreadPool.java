@Scheduled(fixedDelay=1000) // 1초 간격으로 실행
public void one(){
  System.out.println("Scheduled 1 : " + Thread.currentThread().getName() + "start");
  try{
    Thread.sleep(1000);
  }catch(InterruptedException e){e.printStackTrace();}
  System.out.println("Scheduled 1 End");
}

@Scheduled(fixedDelay=1000) // 1초 간격으로 실행
public void two(){
  System.out.println("Scheduled 2 : " + Thread.currentThread().getName());
}

// Thread.currentThread().getName()을 통해 현재 실행되고 있는 Thread의 이름을 알수 있다.
// 위 코드를 실행하면 알 수 있는 점은 2가지다.
// 1. 우리가 원하는 독립적이고 지속적인 실행이 아닌 순차적으로 실행 된다는 점
// 2. 하나의 Thread만 실행되고 있다는 점
