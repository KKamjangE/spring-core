package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor // lombok에서 final이 붙은 객체를 참고해서 생성자를 자동으로 만들어준다
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final ObjectProvider<MyLogger> myLoggerProvider; // myLogger를 찾을 수 있는 DL

    @RequestMapping("log-demo") // request 요청 URL
    @ResponseBody // 반환하는 문자를 그대로 보낸다
    public String logDemo(HttpServletRequest request) throws InterruptedException { // http request 정보를 받는다
        String requestURL = request.getRequestURL().toString(); // requestURL을 가져온다
        MyLogger myLogger = myLoggerProvider.getObject(); // myLogger를 찾아온다 이 시점에서 myLogger 빈이 최초로 생성된다
        myLogger.setRequsetURL(requestURL);

        myLogger.log("controller test"); // 로그 출력
        Thread.sleep(1000);
        logDemoService.logic("testId");
        return "OK";
    }
}
