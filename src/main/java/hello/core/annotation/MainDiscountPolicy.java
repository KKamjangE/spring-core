package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy") // Qualifier는 문자열이기 때문에 오타가 있을 경우 컴파일단에서 에러를 잡을 수 없다
public @interface MainDiscountPolicy { // 어노테이션으로 만들어 두면 오류가 발생했을 때 컴파일단에서 에러를 잡을 수 있다

}
