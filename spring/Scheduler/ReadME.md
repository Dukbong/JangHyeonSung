## Scheduler
스케줄러는 일정한 시간 간격또는 일정한 시간에 특정 로직을 돌리기 위해서 사용한것이다.<br>
우선 스케줄러를 사용하기 전에 Thread에 대해 알아보자<br><br>

### Thread
Thread는 Process내에서 실제로 작업을 수행하는 주체를 의미한다.<br>
모든 Process에는 1개 이상의 Thread가 존재한다.(main Method가 바로 Thread이다.)<br>
이런 Thread가 2개 이상 있는 Process를 Multi Threaded Process라고 부릅니다.<br>
> Process=공장<br>
> Thread=일꾼

#### 생성과 실행 방법
1. Thread 객체 생성

Thread는 Runnable Interface를 구현한 객체이며 Runnable에 있는 run()를 구현하면서 작업할 내용을 작성한다.
```
class ThreadTest1{
    public static void main(String[] args){
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
    
        System.out.println("END");
    }
}
```
원래는 main Method가 종료하면 Process도 함께 종료되는게 일반적이지만 위와 같은 상황에서는 main Method의 종료와는 별개로 t1 Thread가 종료되지 않았기 때문에 Process가 종료되지 않는다.<br><br>

이제 main Method가 종료될때 Thread를 강제로 종료시켜서 Process가 종료되게 만들어보자
```
class ThreadTest1{
    public static void main(String[] args){
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
        
        t1.setDaemon(true); // t1이라는 Thread를 main에 종속시키겠다.
        t1.start(); // t1이라는 Thread를 실행시킨다.
    
        System.out.println("END");
    }
}
```
setDaemon(true)라는 Method를 통해 Thread t1을 주 스레드(main)를 돕는 데몬 스레드로 만들어준다.<br><br>
데몬 스레드란?
1. Main Thread의 작업을 돕는 보조적인 역할을 수행하는 Thread
2. Main Thread가 종료되면 Daemon Thread는 강제 종료된다.

### Synchroized
위에서 알아본 Thread를 여러개 만들어서 한번에 많은 일을 동시에 처리하면 좋겠지만 과연 안정성이 보장될까?<br>
예를 들어 ATM기기에 3명이 동시에 이용하려고 한다면 이건 말이 되는걸까요?<br>
이런 경우는 줄을 세워서 각자의 차례를 기다려야 정상적인 업무를 볼 수 있게 됩니다.<br>
이걸 스레드에 적용시키면 Thread간에 동기화를 시켜서 하나의 Thread가 Method엥 접근하면 다른 Thread의 접근을 block(막는)시켜서 수행 결과가 올바르게 나올 수(Thread-safe) 있게 만듭니다.<br><br>

좀더 공부가 필요하다.
Synchroized는 어디에 쓰는 걸까?
1. Instance Method : Method에만 block이 생긴다.
2. Static Method : Class자체에 block이 생긴다.
3. Instance Method CodeBlock
4. Static Method CodeBlock

```
// Instance Method에 적용
public synchroized void time(){
    String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    System.out.println(now);
}
// Static Method에 적용
public static synchroized void time(){
    String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    System.out.println(now);
}
// Instance Method CodeBlock
public synchronized void test1(){
    System.out.println("test1");
}
public void test2(){
    synchronized(this){
        System.out.println("test2");
    }
}
// static Method CodeBlcok
public static synchronized void test1(){
    System.out.println("test1");
}
public static void test2(){
    synchronized(MyClass.class){
        System.out.println("test2");
    }
}
```
<br>
[Instance Method에 Synchronized를 적용한 예시](https://github.com/Dukbong/JangHyeonSung/blob/main/spring/Scheduler/InstanceMethod_Synchronized.java)

