package com.example.feignfallbackdemo;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Olga Maciaszek-Sharma
 */
@FeignClient(url = "http://localhost:8080", name = "InstallationDataClient", fallback = Fallback.class)
public interface InstallationDataClient {

	@GetMapping("/getInstallationData")
	Optional<InstallationDataResultResponseDTO> getInstallationFullData(
			@RequestParam String country,
			@RequestParam String id);
}


@Component
class Fallback implements InstallationDataClient {

	@Override
	public Optional<InstallationDataResultResponseDTO> getInstallationFullData(String country, String id) {
		return Optional.empty();
	}
}