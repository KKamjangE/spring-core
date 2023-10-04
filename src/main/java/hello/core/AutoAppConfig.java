package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @Component가 붙은 클래스를 모두 찾아서 빈으로 등록한다
@ComponentScan(
        basePackages = "hello.core.member", // 탐색할 패키지의 시작 위치 지정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // Configuration 이라는 어노테이션이 붙은 클래스는 제외한다
)
public class AutoAppConfig {

}
