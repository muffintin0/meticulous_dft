package mingh.research.io.util;

public class JobResourceBean {

	private int cpus;
	
	private int memory; // in mb
	
	private double runtime; //in s

	public int getCpus() {
		return cpus;
	}

	public void setCpus(int cpus) {
		this.cpus = cpus;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		if (memory > this.memory) {
			this.memory = memory;
		}
	}

	public double getRuntime() {
		return runtime;
	}

	public void setRuntime(double runtime) {
		this.runtime = runtime;
	}
	
	public void addToRuntime(double time) {
		this.runtime += time;
	}
	
	@Override
	public String toString() {
		return "Resource used [ # of cpus " + cpus + ", memory=" + memory
				+ " MB, runtime=" + runtime/60/60 + " hr ]";
	}

	public JobResourceBean() {}
	
	public JobResourceBean(int cpus, int memory, int runtime) {
		super();
		this.cpus = cpus;
		this.memory = memory;
		this.runtime = runtime;
	}
	
	
}
