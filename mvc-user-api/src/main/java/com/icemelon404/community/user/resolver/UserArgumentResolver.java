package com.icemelon404.community.user.resolver;

import com.icemelon404.community.user.UserInfo;
import com.icemelon404.community.user.UserInfoExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    private final UserInfoExtractor extractor;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(RequestUser.class) != null && parameter.getParameterType().equals(UserInfo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        if (!(webRequest.getNativeRequest() instanceof HttpServletRequest))
            throw new IllegalStateException("요청이 HttpServletRequest 가 아닙니다");
        return extractor.extractUserInfo((HttpServletRequest) webRequest.getNativeRequest());
    }
}
