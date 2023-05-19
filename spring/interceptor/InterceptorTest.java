// 로그인한 상태에서만 페이지에 접근할 수 있는 권한 설정

// 1. 상속 (강제성 X)
public class InterceptorTest1 extends HandlerInterceptor{
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception{
    Object obj = request.getSession().getAttribute("loginUser");
    // Login을 하면 Session영역에 유저의 정보를 저장했다는 가정
    if(obj == null){
      response.sendRedirect("login.page");
      // Controller에 Mapping주소가 login.page인것으로 넘긴다.
      return false;
      // 정상적인 흐름을 제어한다.
    }
    return true;
  }
}

// 2. 구현 (강제성 O)
public class InterceptorTest2 implements HandlerInterceptor{
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception{
     Object obj = request.getSession().getAttribute("loginUser");
    // Login을 하면 Session영역에 유저의 정보를 저장했다는 가정
    if(obj == null){
      response.sendRedirect("login.page");
      // Controller에 Mapping주소가 login.page인것으로 넘긴다.
      return false;
      // 정상적인 흐름을 제어한다.
    }
    return true;
   } 
  
  // 그외에는 모두 정상적으로 두겠다.
   public boolean postHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception{
     return true;
   }  
   public boolean afterHandle(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex) throws Exception{
     return true;
   }  
}
