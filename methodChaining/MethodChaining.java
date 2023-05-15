public class MethodChaining{
  private num; // 전역 변수이기 때문에 0으로 초기화 된다.
  
  MethodChaining(){}
  
  public MethodChaining add(int num){
    this.num += num;
    return this; // 자기 자신을 반환한다.
  }
  
  public void showTerminal(){
    System.out.println("총합은 : " + num);
  }
}


// Q. 메서드를 이용해서 1부터 5까지 더해서 터미널에 출력하여라.


public class MainClass{
  public static void main(String[] args){
    MethodChaining mc1 = new MethodChaining();
    MethodChaining mc2 = new MethodChaining();
    mc1.add(1).add(2).add(3).add(4).add(5).showTerminal(); // Method Chaining을 이용한 방법 
    
    // 일반 Method 사용방법
    mc2.add(1);
    mc2.add(2);
    mc2.add(3);
    mc2.add(4);
    mc2.add(5);
    mc2.showTerminal();
  }
}
