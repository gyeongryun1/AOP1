package hello.proxy;

import hello.proxy.app.v1.OrderControllerV1Impl;
import hello.proxy.config.v1_proxy.ConcreteProxyConfig;
import hello.proxy.config.v1_proxy.InterfaceProxyConfig;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({AppV1Config.class, AppV2Config.class})
@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
@SpringBootApplication(scanBasePackages = "hello.proxy.app") //주의
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace(); }

	}


/**
 * v1 - 인터페이스와구현클래스 - 스프링빈으로수동등록
 * v2 - 인터페이스없는구체클래스 - 스프링빈으로수동등록
 * v3 - 컴포넌트스캔으로스프링빈자동등록
 */

/**
 * public class OrderRepositoryV2 {
 * @Import(AppV1Config.class): 클래스를 스프링빈으로 등록한다.
 * 일반적으로 @Configuration 같은 설정파일을 등록할때 사용하지만, 스프링 빈을등록 할때도사용할수있다.
 * @SpringBootApplication(scanBasePackages = "hello.proxy.app"):
 * @ComponentScan의 기능과같다. 컴포넌트스캔을 시작할위치를지정한다. 이 값을 설정하면 해당 패키지와 그하위패키지를
 * 컴포넌트스캔한다. 이 값을 사용하지 않으면 Proxy Application이 있는 패키지와 그 하위 패키지를 스캔한다. 참고로
 * v3에서 지금 설정한 컴포넌트스캔기능을 사용한다.
 */