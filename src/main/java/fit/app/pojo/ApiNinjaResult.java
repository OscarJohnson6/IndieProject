package fit.app.pojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Api ninja result.
 */
public class ApiNinjaResult{

	@JsonProperty("ApiNinjaResult")
	private List<ApiNinjaResultItem> apiNinjaResult;

	/**
	 * Set api ninja result.
	 *
	 * @param apiNinjaResult the api ninja result
	 */
	public void setApiNinjaResult(List<ApiNinjaResultItem> apiNinjaResult){
		this.apiNinjaResult = apiNinjaResult;
	}

	/**
	 * Get api ninja result list.
	 *
	 * @return the list
	 */
	public List<ApiNinjaResultItem> getApiNinjaResult(){
		return apiNinjaResult;
	}

	@Override
 	public String toString(){
		return 
			"ApiNinjaResult{" + 
			"apiNinjaResult = '" + apiNinjaResult + '\'' + 
			"}";
		}
}