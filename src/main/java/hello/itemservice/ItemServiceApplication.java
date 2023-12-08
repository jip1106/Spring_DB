package hello.itemservice;

import hello.itemservice.config.*;
import hello.itemservice.repository.ItemRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;


@Import(MemoryConfig.class)
@SpringBootApplication(scanBasePackages = "hello.itemservice.web")
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	/*
	application.properties => spring.profiles.active=local
	Profile("local") : 특정 프로필의 경우에만 해당 스프링 빈을 등록한다. 여기서는 local 이라는 이름의
	프로필이 사용되는 경우에만 testDataInit 이라는 스프링 빈을 등록한다. 이 빈은 앞서 본 것인데, 편의상 초
	기 데이터를 만들어서 저장하는 빈이다.
	 */
	@Bean
	@Profile("local")
	public TestDataInit testDataInit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}

}
