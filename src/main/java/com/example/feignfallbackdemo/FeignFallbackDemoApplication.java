package com.example.feignfallbackdemo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients(clients = InstallationDataClient.class)
@RestController
@SpringBootApplication
public class FeignFallbackDemoApplication {

	@Autowired
	private InstallationDataClient client;

	public static void main(String[] args) {
		SpringApplication.run(FeignFallbackDemoApplication.class, args);
	}

	@GetMapping("/test")
	String test() {
		return client.getInstallationFullData("PL", "2")
				.orElse(new InstallationDataResultResponseDTO("Fallback", "Fallback"))
				.toString();
	}

	@GetMapping("/getInstallationData")
	Optional<InstallationDataResultResponseDTO> getInstallationFullData(
			@RequestParam String country,
			@RequestParam String id) {
//		return Optional.of(new InstallationDataResultResponseDTO(country, id));
		throw new RuntimeException("Test!");
	}

}
