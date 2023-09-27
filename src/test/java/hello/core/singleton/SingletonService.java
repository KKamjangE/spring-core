package hello.core.singleton;

public class SingletonService {
    // 자기 자신을 참조해서 인스턴스를 생성한다
    // static 영역에 객체 인스턴스를 미리 하나 생성해서 올려둔다
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() { // SingletonService를 호출하면 위에서 생성한 인스턴스를 반환한다
        return instance;
    }

    private SingletonService() { // 외부에서 참조하여 생성하지 못하게 막는다

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
