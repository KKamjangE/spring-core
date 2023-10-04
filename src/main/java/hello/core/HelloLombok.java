package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// lombok을 사용해 getter와 setter를 자동 생성
@Getter
@Setter
@ToString // 현재 클래스를 String으로 변환해준다
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdfg"); // setter 어노테이션이 있기 때문에 setName을 사용할 수 있다

        System.out.println("helloLombok = " + helloLombok);
    }
}
