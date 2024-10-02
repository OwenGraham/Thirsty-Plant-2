package objects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpeciesData{

//	@JsonProperty("sunlight")
//	private List<Object> sunlight;
//
//	@JsonProperty("watering")
//	private String watering;

	@JsonProperty("scientific_name")
	private List<String> scientificName;

	@JsonProperty("other_name")
	private List<String> otherName;

	@JsonProperty("default_image")
	private DefaultImage defaultImage;

	@JsonProperty("id")
	private int id;

	@JsonProperty("common_name")
	private String commonName;

//	@JsonProperty("cycle")
//	private String cycle;

//	public List<Object> getSunlight(){
//		return sunlight;
//	}
//
//	public String getWatering(){
//		return watering;
//	}

	public List<String> getScientificName(){
		return scientificName;
	}

	public List<String> getOtherName(){
		return otherName;
	}

	public DefaultImage getDefaultImage(){
		return defaultImage;
	}

	public int getId(){
		return id;
	}

	public String getCommonName(){
		return commonName;
	}

//	public String getCycle(){
//		return cycle;
//	}

	@Override
	public String toString() {
		return "SpeciesData{" +
//				"sunlight=" + sunlight +
//				", watering='" + watering + '\'' +
				", scientificName=" + scientificName +
				", otherName=" + otherName +
				", defaultImage=" + defaultImage +
				", id=" + id +
				", commonName='" + commonName + '\'' +
//				", cycle='" + cycle + '\'' +
				'}';
	}
}