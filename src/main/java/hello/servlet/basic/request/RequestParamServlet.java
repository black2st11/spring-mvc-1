package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] 시작");
        request.getParameterNames().asIterator()
                .forEachRemaining(
                        parameterName -> System.out.println(parameterName + ": " + request.getParameter(parameterName))
                );

        System.out.println("[전체 파라미터 조회] 끝");
        System.out.println("[단일 파라미터 조회] 시작");
        System.out.println("username="+request.getParameter("username"));
        System.out.println("age="+request.getParameter("age"));
        System.out.println("[단일 파라미터 조회] 끝");
        System.out.println();
        System.out.println("[이름이 같은 복수 파라미터 조회] 시작");
        String[] usernames = request.getParameterValues("username");
        for (String username: usernames){
            System.out.println("username = " + username);
        }
        System.out.println("age="+request.getParameter("age"));
        System.out.println("[이름이 같은 복수 파라미터 조회] 끝");

        response.getWriter().write("OK");
    }
}
