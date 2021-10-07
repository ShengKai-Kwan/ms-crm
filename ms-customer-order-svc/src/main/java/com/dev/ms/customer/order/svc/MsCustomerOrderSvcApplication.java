package com.dev.ms.customer.order.svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({
		"com.dev.ms.customer.order",
		"com.dev.core.lib.utility"
})
@EnableJpaRepositories({"com.dev.ms.customer.order.core.repository"})
@EntityScan({"com.dev.ms.customer.order.core.entity"})
public class MsCustomerOrderSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCustomerOrderSvcApplication.class, args);
	}

}
