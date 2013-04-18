package mingh.research.io.util;

import java.util.List;

public class IRPropertyBean extends JaguarPropertyBean{

	private List<Double> frequencyNumbers;
	
	private List<Double> intensities;
	
	private List< List<Vector3d> > normalModes;
	
	private double temperature;
	
	//All unit is kcal/mol
	
	private double ZPE; 
	
	private double U;
	
	private double Cv;
	
	private double S;
	
	private double H;
	
	private double G;
	
	// All unit is Hatree
	
	private double internalEnergy;
	
	private double enthalpy;
	
	private double gibbsEnergy;

	public List<Double> getFrequencyNumbers() {
		return frequencyNumbers;
	}

	public void setFrequencyNumbers(List<Double> frequencyNumbers) {
		this.frequencyNumbers = frequencyNumbers;
	}

	public List<Double> getIntensities() {
		return intensities;
	}

	public void setIntensities(List<Double> intensities) {
		this.intensities = intensities;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getZPE() {
		return ZPE;
	}

	public void setZPE(double zPE) {
		ZPE = zPE;
	}

	public double getU() {
		return U;
	}

	public void setU(double u) {
		U = u;
	}

	public double getCv() {
		return Cv;
	}

	public void setCv(double cv) {
		Cv = cv;
	}

	public double getS() {
		return S;
	}

	public void setS(double s) {
		S = s;
	}

	public double getH() {
		return H;
	}

	public void setH(double h) {
		H = h;
	}

	public double getG() {
		return G;
	}

	public void setG(double g) {
		G = g;
	}

	public double getInternalEnergy() {
		return internalEnergy;
	}

	public void setInternalEnergy(double internalEnergy) {
		this.internalEnergy = internalEnergy;
	}

	public double getEnthalpy() {
		return enthalpy;
	}

	public void setEnthalpy(double enthalpy) {
		this.enthalpy = enthalpy;
	}

	public double getGibbsEnergy() {
		return gibbsEnergy;
	}

	public void setGibbsEnergy(double gibbsEnergy) {
		this.gibbsEnergy = gibbsEnergy;
	}

	@Override
	public String toString() {
		return "IRPropertyBean [frequencyNumbers=" + frequencyNumbers
				+ ", intensities=" + intensities + ", normalModes="
				+ normalModes + ", temperature=" + temperature + ", ZPE=" + ZPE
				+ ", U=" + U + ", Cv=" + Cv + ", S=" + S + ", H=" + H + ", G="
				+ G + ", internalEnergy=" + internalEnergy + ", enthalpy="
				+ enthalpy + ", gibbsEnergy=" + gibbsEnergy + "]";
	}

	public IRPropertyBean() {
		super("IR");
	}
	
	public IRPropertyBean(List<Double> frequencyNumbers,
			List<Double> intensities, List< List<Vector3d> > normalModes,
			double temperature, double zPE, double u, double cv, double s,
			double h, double g, double internalEnergy, double enthalpy,
			double gibbsEnergy) {
		super("IR");
		this.frequencyNumbers = frequencyNumbers;
		this.intensities = intensities;
		this.normalModes = normalModes;
		this.temperature = temperature;
		ZPE = zPE;
		U = u;
		Cv = cv;
		S = s;
		H = h;
		G = g;
		this.internalEnergy = internalEnergy;
		this.enthalpy = enthalpy;
		this.gibbsEnergy = gibbsEnergy;
	}

	public List<List<Vector3d>> getNormalModes() {
		return normalModes;
	}

	public void setNormalModes(List<List<Vector3d>> normalModes) {
		this.normalModes = normalModes;
	}
		
}
