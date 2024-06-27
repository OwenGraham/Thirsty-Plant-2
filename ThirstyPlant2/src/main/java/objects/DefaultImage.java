package objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultImage{

	@JsonProperty("license")
	private int license;

	@JsonProperty("regular_url")
	private String regularUrl;

	@JsonProperty("license_name")
	private String licenseName;

	@JsonProperty("thumbnail")
	private String thumbnail;

	@JsonProperty("small_url")
	private String smallUrl;

	@JsonProperty("original_url")
	private String originalUrl;

	@JsonProperty("medium_url")
	private String mediumUrl;

	@JsonProperty("image_id")
	private int imageId;

	@JsonProperty("license_url")
	private String licenseUrl;

	public int getLicense(){
		return license;
	}

	public String getRegularUrl(){
		return regularUrl;
	}

	public String getLicenseName(){
		return licenseName;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public String getSmallUrl(){
		return smallUrl;
	}

	public String getOriginalUrl(){
		return originalUrl;
	}

	public String getMediumUrl(){
		return mediumUrl;
	}

	public int getImageId(){
		return imageId;
	}

	public String getLicenseUrl(){
		return licenseUrl;
	}
}