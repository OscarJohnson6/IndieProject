package fit.app.pojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExerciseDbJson {

	@JsonProperty("gifUrl")
	private String gifUrl;

	@JsonProperty("instructions")
	private List<String> instructions;

	@JsonProperty("secondaryMuscles")
	private List<String> secondaryMuscles;

	@JsonProperty("name")
	private String name;

	@JsonProperty("equipment")
	private String equipment;

	@JsonProperty("id")
	private String id;

	@JsonProperty("bodyPart")
	private String bodyPart;

	@JsonProperty("target")
	private String target;

	public void setGifUrl(String gifUrl){
		this.gifUrl = gifUrl;
	}

	public String getGifUrl(){
		return gifUrl;
	}

	public void setInstructions(List<String> instructions){
		this.instructions = instructions;
	}

	public List<String> getInstructions(){
		return instructions;
	}

	public void setSecondaryMuscles(List<String> secondaryMuscles){
		this.secondaryMuscles = secondaryMuscles;
	}

	public List<String> getSecondaryMuscles(){
		return secondaryMuscles;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEquipment(String equipment){
		this.equipment = equipment;
	}

	public String getEquipment(){
		return equipment;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setBodyPart(String bodyPart){
		this.bodyPart = bodyPart;
	}

	public String getBodyPart(){
		return bodyPart;
	}

	public void setTarget(String target){
		this.target = target;
	}

	public String getTarget(){
		return target;
	}

	@Override
 	public String toString(){
		return 
			"ExerciseDbJsonItem{" + 
			"gifUrl = '" + gifUrl + '\'' + 
			",instructions = '" + instructions + '\'' + 
			",secondaryMuscles = '" + secondaryMuscles + '\'' + 
			",name = '" + name + '\'' + 
			",equipment = '" + equipment + '\'' + 
			",id = '" + id + '\'' + 
			",bodyPart = '" + bodyPart + '\'' + 
			",target = '" + target + '\'' + 
			"}";
		}
}