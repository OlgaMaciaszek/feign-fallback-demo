package com.example.feignfallbackdemo;

/**
 * @author Olga Maciaszek-Sharma
 */
public class InstallationDataResultResponseDTO {

	private String country;
	private String id;

	InstallationDataResultResponseDTO(String country, String id) {
		this.country = country;
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "InstallationDataResultResponseDTO{" +
				"country='" + country + '\'' +
				", id='" + id + '\'' +
				'}';
	}
}


