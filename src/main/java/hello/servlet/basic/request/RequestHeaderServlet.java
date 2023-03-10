package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name="requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        extracted(request);
        printHeader(request);
        printHeaderUtils(request);
    }

    private static void extracted(HttpServletRequest request) {
        System.out.println("-------start line---------");
        String method = request.getMethod();
        String protocol = request.getProtocol();
        String scheme = request.getScheme();

        StringBuffer requestURL = request.getRequestURL();
        String requestURI = request.getRequestURI();

        String queryString = request.getQueryString();
        boolean secure = request.isSecure();

        System.out.println("method = " + method);
        System.out.println("protocol = " + protocol);
        System.out.println("scheme = " + scheme);
        System.out.println("requestURL = " + requestURL);
        System.out.println("requestURI = " + requestURI);
        System.out.println("queryString = " + queryString);
        System.out.println("secure = " + secure);

        System.out.println("-------end line---------");
        System.out.println("");
    }

    private void printHeader(HttpServletRequest request) {
        System.out.println("---- Headers - start ----");

        /*
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()){
                String headerName = headerNames.nextElement();

                System.out.println(headerName + ": " + request.getHeader(headerName));
            }
        */
        request.getHeaderNames()
                .asIterator()
                .forEachRemaining(
                        headerName -> System.out.println(headerName + ": " + request.getHeader(headerName))
                );
        System.out.println("---- Headers - end ----");
        System.out.println();
    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("--- Header ?????? ?????? start ---");
        System.out.println("[Host ?????? ??????]");
        System.out.println("request.getServerName() = " + request.getServerName()); //Host ?????? System.out.println("request.getServerPort() = " +
        request.getServerPort(); //Host ?????? System.out.println();
        System.out.println("[Accept-Language ?????? ??????]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));

        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();
        System.out.println("[cookie ?????? ??????]"); if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            } }
        System.out.println();
        System.out.println("[Content ?????? ??????]");
        System.out.println("request.getContentType() = " +
                request.getContentType());
        System.out.println("request.getContentLength() = " +
                request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " +
                request.getCharacterEncoding());
        System.out.println("--- Header ?????? ?????? end ---");
        System.out.println();
    }
}
