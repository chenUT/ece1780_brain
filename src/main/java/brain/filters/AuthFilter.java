package brain.filters;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chen on 3/20/17.
 */
public class AuthFilter implements Filter{

    private static final String MY_TOKEN = "super_secure_token_IaqqmVVNrX2R7zm_IDcgzQPPrgcoFrcKF25l";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(request instanceof HttpServletRequest) {
           String token = ((HttpServletRequest)request).getHeader(HttpHeaders.AUTHORIZATION);
           System.out.println("token: " + token);
           if(!MY_TOKEN.equals(token)){
               if (response instanceof HttpServletResponse){
                   HttpServletResponse resp = (HttpServletResponse) response;
                   resp.reset();
                   resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

               }
               return;
           }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
