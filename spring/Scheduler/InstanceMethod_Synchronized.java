public class ATM{
  public synchronized void withdrawal(){
    System.out.println("WithDraw Start...");
    try{
      Thread.sleep(3000); // 3초 대기
    }catch(InterruptedException e){
      e.printStackTrace();
    }
    System.out.println("WithDraw End...");
  } 
}


// ----------------------------------------------


public class SynchronizedTest(){
  public static void main(String[] args){
    ATM atm = new ATM();
    Thread t1 = new Thread(){
      @Override
      public void run(){
        atm.withdrawal();
      }
    } // t1 끝
    
    Thread t2 = new Thread(){
      @Override
      public void run(){
        atm.withdrawal();
      }
    } // t2 끝
    
    t1.start();
    t2.start();
  }
}

/*
  결과를 보면 이제 순차적으로 접근하는 것을 확인할 수 있다.
*/
