package mingh.research.io.util;

import java.util.ArrayList;
import java.util.List;


public class JaguarResultBean {

	private List<JaguarOptimizationStepBean> optimizationSteps;
	
	private JobResourceBean jobResource;
	
	private JaguarPropertyBean jaguarPropertyBean;
	
	private JaguarInputBean jaguarInputBean;
	
	private List<JaguarFileBean> jaguarFiles;


	public List<JaguarFileBean> getJaguarFiles() {
		return jaguarFiles;
	}

	public void setJaguarFiles(List<JaguarFileBean> jaguarFiles) {
		this.jaguarFiles = jaguarFiles;
	}

	public JaguarInputBean getJaguarInputBean() {
		return jaguarInputBean;
	}

	public void setJaguarInputBean(JaguarInputBean jaguarInputBean) {
		this.jaguarInputBean = jaguarInputBean;
	}

	public void addJaguarInput(String key, String value) {
		this.jaguarInputBean.setInputParam(key, value);
	}
	
	public List<JaguarOptimizationStepBean> getOptimizationSteps() {
		return optimizationSteps;
	}

	public void setOptimizationSteps(
			List<JaguarOptimizationStepBean> optimizationSteps) {
		this.optimizationSteps = optimizationSteps;
	}

	public JobResourceBean getJobResource() {
		return jobResource;
	}

	public void setJobResource(JobResourceBean jobResource) {
		this.jobResource = jobResource;
	}
	
	public void addToJobRunTime(double time) {
		this.jobResource.addToRuntime(time);
	}

	public void setJobMemory(int memory) {
		this.jobResource.setMemory(memory);
	}
	
	public void setJobCpus(int cpus) {
		this.jobResource.setCpus(cpus);
	}
	
	public JaguarPropertyBean getJaguarPropertyBean() {
		return jaguarPropertyBean;
	}

	public void setJaguarPropertyBean(JaguarPropertyBean jaguarPropertyBean) {
		this.jaguarPropertyBean = jaguarPropertyBean;
	}

	public JaguarResultBean(){
		this.optimizationSteps = new ArrayList<JaguarOptimizationStepBean>();
		this.jobResource = new JobResourceBean();
		this.jaguarPropertyBean = new JaguarPropertyBean();
		this.jaguarInputBean = new JaguarInputBean();
		this.jaguarFiles = new ArrayList<JaguarFileBean>();
	}
	
	public JaguarResultBean(List<JaguarOptimizationStepBean> optimizationSteps,
			JobResourceBean jobResource, JaguarPropertyBean jaguarPropertyBean,
			JaguarInputBean jaguarInputBean, List<JaguarFileBean> jaguarFiles) {
		super();
		this.optimizationSteps = optimizationSteps;
		this.jobResource = jobResource;
		this.jaguarPropertyBean = jaguarPropertyBean;
		this.jaguarInputBean = jaguarInputBean;
		this.jaguarFiles = jaguarFiles;
	}

	@Override
	public String toString() {
		String str = "Find "+optimizationSteps.size()+" optimization steps.\n";
		if ( !optimizationSteps.isEmpty() ){
			str += "The first step --- " + optimizationSteps.get(0);
			if (optimizationSteps.size()>1){
				str += "\nThe last step --- " + optimizationSteps.get(optimizationSteps.size()-1);
			}
		}
		str += "\n";
		str += this.jobResource.toString();
		str += "\n";
		str += this.jaguarPropertyBean.toString();
		str += "\n";
		str += this.jaguarInputBean.toString();
		
		for(JaguarFileBean jaguarFile : this.jaguarFiles){
			str += jaguarFile.toString();
		}
		
		return str;
	}
	
	
}
