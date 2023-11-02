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
    private final MyLogger myLogger; // myLogger를 찾을 수 있는 DL

    @RequestMapping("log-demo") // request 요청 URL
    @ResponseBody // 반환하는 문자를 그대로 보낸다
    public String logDemo(HttpServletRequest request) throws InterruptedException { // http request 정보를 받는다
        String requestURL = request.getRequestURL().toString(); // requestURL을 가져온다

        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequsetURL(requestURL);

        myLogger.log("controller test"); // 로그 출력
        Thread.sleep(1000);
        logDemoService.logic("testId");
        return "OK";
    }
}
