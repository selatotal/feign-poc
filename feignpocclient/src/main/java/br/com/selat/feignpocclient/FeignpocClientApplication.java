package br.com.selat.feignpocclient;

import br.com.selat.feignpocclient.client.FeignpocServerClient;
import br.com.selat.feignpocclient.contract.DelayResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class FeignpocClientApplication {

	private static final Logger logger = LoggerFactory.getLogger(FeignpocClientApplication.class);

	@Autowired
	FeignpocServerClient feignClient;

	public static void main(String[] args) {
		SpringApplication.run(FeignpocClientApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context){
		return args -> {
			new Thread(new FeignRequests(10000)).start();
			new Thread(new FeignRequests(20000)).start();
			new Thread(new FeignRequests(30000)).start();
		};
	}

	class FeignRequests implements Runnable {

		final int delayTime;

		FeignRequests(int delayTime) {
			this.delayTime = delayTime;
		}

		@Override
		public void run() {
			logger.info("Feign object: {}", feignClient.hashCode());
			DelayResponse response = feignClient.delay(delayTime);
			logger.info("Response: {}", response);
		}
	}
}
