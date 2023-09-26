package hello.core.order;

public interface OrderService { // 주문 서비스 인터페이스
    Order createOrder(Long memberId, String itemName, int itemPrice); // 주문 생성
}
