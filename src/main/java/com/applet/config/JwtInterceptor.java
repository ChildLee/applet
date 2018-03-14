package com.applet.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Value("${application.token.secret}")
    private String secret;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println(request.getMethod());
        //获取完整请求路径
        System.out.println(request.getRequestURL());
        //获取除了域名外的请求数据
        System.out.println(request.getRequestURI());
        //获取请求参数
        System.out.println(request.getQueryString());
        //验证token是否有效
        Boolean result = verifyToken(request, response);

        if (!result) {
            response.setStatus(403);
            return false;
        }
        return result;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("2.请求处理之后，视图被渲染之前调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("3.视图被渲染之后");
    }

    /**
     * 验证token
     */
    private Boolean verifyToken(HttpServletRequest request, HttpServletResponse response) {
        Boolean result = true;
        try {
            Enumeration<String> authorization = request.getHeaders("Authorization");
            String token = authorization.nextElement();
//            DecodedJWT jwt = JWT.decode(token);
//            Map<String, Claim> claims = jwt.getClaims();
//            Claim name = claims.get("name");
//            System.out.println(name.asString());
            //签名密钥
            JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
        } catch (NullPointerException | JWTVerificationException | UnsupportedEncodingException e) {
            result = false;
        }
        return result;
    }
}