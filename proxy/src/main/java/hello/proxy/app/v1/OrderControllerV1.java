package hello.proxy.app.v1;
import org.springframework.web.bind.annotation.*;
//인터페이스와 구현클래스 , 스프링빈으로 수동등록
@RequestMapping
@ResponseBody
public interface OrderControllerV1 {
    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String noLog();
}
/**
 * proxy가 어떻게 호출되는지 모르겠음. --> import? 왜? ---> 빈으로 등록된 객체를 호출
 *
 */