package net.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chiangfai
 **/
@Component
public class TokenFilter extends ZuulFilter {
    private Logger log = LoggerFactory.getLogger(getClass());
    /**
     * <p>
     *     过滤器类型
     *     pre：路由之前
     *     routing：路由之时
     *     post：路由之后
     *     error：发送错误调用
     * </p>
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * <p>
     *     是否执行该过滤器
     * </p>
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体逻辑
     * <p></p>
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));

        String token = request.getParameter("token");

        if(StringUtils.isBlank(token)) {
            ctx.setSendZuulResponse(false); //不对其进行路由
            ctx.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess", false);
        }else {
            ctx.setSendZuulResponse(true); //对请求进行路由
            ctx.setResponseStatusCode(HttpStatus.SC_OK);
            ctx.set("isSuccess", true);
        }
        return null;
    }
}
