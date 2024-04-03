package fit.app.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Api ninja result item.
 */
public class ApiNinjaResult {

	@JsonProperty("difficulty")
	private String difficulty;

	@JsonProperty("instructions")
	private String instructions;

	@JsonProperty("muscle")
	private String muscle;

	@JsonProperty("name")
	private String name;

	@JsonProperty("equipment")
	private String equipment;

	@JsonProperty("type")
	private String type;

	/**
	 * Set difficulty.
	 *
	 * @param difficulty the difficulty
	 */
	public void setDifficulty(String difficulty){
		this.difficulty = difficulty;
	}

	/**
	 * Get difficulty string.
	 *
	 * @return the string
	 */
	public String getDifficulty(){
		return difficulty;
	}

	/**
	 * Set instructions.
	 *
	 * @param instructions the instructions
	 */
	public void setInstructions(String instructions){
		this.instructions = instructions;
	}

	/**
	 * Get instructions string.
	 *
	 * @return the string
	 */
	public String getInstructions(){
		return instructions;
	}

	/**
	 * Set muscle.
	 *
	 * @param muscle the muscle
	 */
	public void setMuscle(String muscle){
		this.muscle = muscle;
	}

	/**
	 * Get muscle string.
	 *
	 * @return the string
	 */
	public String getMuscle(){
		return muscle;
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
	 * Set type.
	 *
	 * @param type the type
	 */
	public void setType(String type){
		this.type = type;
	}

	/**
	 * Get type string.
	 *
	 * @return the string
	 */
	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"ApiNinjaResultItem{" + 
			"difficulty = '" + difficulty + '\'' + 
			",instructions = '" + instructions + '\'' + 
			",muscle = '" + muscle + '\'' + 
			",name = '" + name + '\'' + 
			",equipment = '" + equipment + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}