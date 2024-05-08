package fit.app.pojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Exercise db json.
 */
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

	/**
	 * Set gif url.
	 *
	 * @param gifUrl the gif url
	 */
	public void setGifUrl(String gifUrl){
		this.gifUrl = gifUrl;
	}

	/**
	 * Get gif url string.
	 *
	 * @return the string
	 */
	public String getGifUrl(){
		return gifUrl;
	}

	/**
	 * Set instructions.
	 *
	 * @param instructions the instructions
	 */
	public void setInstructions(List<String> instructions){
		this.instructions = instructions;
	}

	/**
	 * Get instructions list.
	 *
	 * @return the list
	 */
	public List<String> getInstructions(){
		return instructions;
	}

	/**
	 * Set secondary muscles.
	 *
	 * @param secondaryMuscles the secondary muscles
	 */
	public void setSecondaryMuscles(List<String> secondaryMuscles){
		this.secondaryMuscles = secondaryMuscles;
	}

	/**
	 * Get secondary muscles list.
	 *
	 * @return the list
	 */
	public List<String> getSecondaryMuscles(){
		return secondaryMuscles;
	}

	/**
	 * Set name.
	 *
	 * @param name the name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * Get name string.
	 *
	 * @return the string
	 */
	public String getName(){
		return name;
	}

	/**
	 * Set equipment.
	 *
	 * @param equipment the equipment
	 */
	public void setEquipment(String equipment){
		this.equipment = equipment;
	}

	/**
	 * Get equipment string.
	 *
	 * @return the string
	 */
	public String getEquipment(){
		return equipment;
	}

	/**
	 * Set id.
	 *
	 * @param id the id
	 */
	public void setId(String id){
		this.id = id;
	}

	/**
	 * Get id string.
	 *
	 * @return the string
	 */
	public String getId(){
		return id;
	}

	/**
	 * Set body part.
	 *
	 * @param bodyPart the body part
	 */
	public void setBodyPart(String bodyPart){
		this.bodyPart = bodyPart;
	}

	/**
	 * Get body part string.
	 *
	 * @return the string
	 */
	public String getBodyPart(){
		return bodyPart;
	}

	/**
	 * Set target.
	 *
	 * @param target the target
	 */
	public void setTarget(String target){
		this.target = target;
	}

	/**
	 * Get target string.
	 *
	 * @return the string
	 */
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