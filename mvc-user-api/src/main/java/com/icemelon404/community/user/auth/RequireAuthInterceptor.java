package com.icemelon404.community.user.auth;

import com.icemelon404.community.user.UserInfo;
import com.icemelon404.community.user.UserInfoExtractor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Slf4j
public class RequireAuthInterceptor implements HandlerInterceptor {

    private final UserInfoExtractor extractor;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod method = (HandlerMethod) handler;
        if (method.getMethodAnnotation(RequireAuth.class) == null)
            return true;
        try {
            UserInfo info = extractor.extractUserInfo(request);
            if (info == null)
                throw new NullPointerException();
            return true;
        } catch (Exception e) {
            log.debug("금지된 요청 발생", e);
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return false;
        }
    }
}
