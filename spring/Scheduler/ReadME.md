## Scheduler
스케줄러는 일정한 시간 간격또는 일정한 시간에 특정 로직을 돌리기 위해서 사용한것이다.<br>
우선 스케줄러를 사용하기 전에 Thread에 대해 알아보자<br><br>

### Thread
Thread는 Process내에서 실제로 작업을 수행하는 주체를 의미한다.<br>
모든 Process에는 1개 이상의 Thread가 존재한다.<br>
이런 Thread가 2개 이상 있는 Process를 Multi Threaded Process라고 부릅니다.<br>
> Process=공장<br>
> Thread=일꾼

#### 생성과 실행 방법
1. Runnable Interface 구현
2. Thread 객체 생성

2가지 방법 모두 Thread를 통해 작업할 방법을 run() Method에 작성하면 된다. <br>
2가지 모두 크게 다르지 않기 때문에 Thread 객체를 생성하는 방법 작성.
```
class ThreadTest1{
    Thread t1 = new Thread(){
        @Override
        public void run(){
            for(int i = 0; i < 10; i++){
                System.out.println("i = " + i);
                try{
                    Thread.sleep(1000); // 1초를 쉬어라.
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }; // Thread를 통해 작업할 내용 : 0~9까지 출력하는데 1초에 한번씩 출력해라.
    
    t1.start(); // t1이라는 Thread를 실행시킨다.
}
```

