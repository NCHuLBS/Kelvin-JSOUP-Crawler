package commonViewModels.home;

public class sqlParameterViewModels {

	public String ParameterAttritube;

	public Object ParameterValue;

	public sqlParameterViewModels(String parameterAttritube, Object parameterValue) {
		this.ParameterAttritube = parameterAttritube;
		this.ParameterValue = parameterValue;
	}

	public sqlParameterViewModels(String parameterAttritube, String parameterValue) {
		this.ParameterAttritube = parameterAttritube;
		this.ParameterValue = parameterValue;
	}

	public sqlParameterViewModels(String parameterAttritube, int parameterValue) {
		this.ParameterAttritube = parameterAttritube;
		this.ParameterValue = parameterValue;
	}

	public sqlParameterViewModels(String parameterAttritube, Boolean parameterValue) {
		this.ParameterAttritube = parameterAttritube;
		this.ParameterValue = parameterValue;
	}
}
