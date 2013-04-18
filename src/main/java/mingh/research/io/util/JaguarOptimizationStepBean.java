package mingh.research.io.util;

import java.util.ArrayList;
import java.util.List;

public class JaguarOptimizationStepBean {
	
	private String relativeFilePath;
	
	private double totalEnergy;
	
	public String getRelativeFilePath() {
		return relativeFilePath;
	}

	public void setRelativeFilePath(String relativeFilePath) {
		this.relativeFilePath = relativeFilePath;
	}

	private double alphaHOMO;
	
	private double alphaLUMO;
	
	private List<Double> alphaOrbital = new ArrayList<Double>();
	


	@Override
	public String toString() {
		return "JaguarOptimizationStepBean [relativeFilePath="
				+ relativeFilePath + ", totalEnergy=" + totalEnergy
				+ ", alphaHOMO=" + alphaHOMO + ", alphaLUMO=" + alphaLUMO
				+ ", alphaOrbital=" + alphaOrbital + ", betaHOMO=" + betaHOMO
				+ ", betaLUMO=" + betaLUMO + ", betaOrbital=" + betaOrbital
				+ ", unrestrictedSpinGuess=" + unrestrictedSpinGuess
				+ ", unrestrictedSpinReal=" + unrestrictedSpinReal
				+ ", forces=" + forces + ", totalForce=" + totalForce
				+ ", xyzs=" + xyzs + "]";
	}

	private double betaHOMO;
	
	private double betaLUMO;
	
	private List<Double> betaOrbital = new ArrayList<Double>();
	
	private double unrestrictedSpinGuess;
	
	private double unrestrictedSpinReal;
	
	private List<Vector3d> forces = new ArrayList<Vector3d>();
	
	private Vector3d totalForce;
	
	private List<Vector3d> xyzs = new ArrayList<Vector3d>();

	public JaguarOptimizationStepBean() {}
	
	public double getTotalEnergy() {
		return totalEnergy;
	}

	public void setTotalEnergy(double totalEnergy) {
		this.totalEnergy = totalEnergy;
	}

	public double getAlphaHOMO() {
		return alphaHOMO;
	}

	public void setAlphaHOMO(double alphaHOMO) {
		this.alphaHOMO = alphaHOMO;
	}

	public double getAlphaLUMO() {
		return alphaLUMO;
	}

	public void setAlphaLUMO(double alphaLUMO) {
		this.alphaLUMO = alphaLUMO;
	}

	public List<Double> getAlphaOrbital() {
		return alphaOrbital;
	}

	public void setAlphaOrbital(List<Double> alphaOrbital) {
		this.alphaOrbital = alphaOrbital;
	}

	public double getBetaHOMO() {
		return betaHOMO;
	}

	public void setBetaHOMO(double betaHOMO) {
		this.betaHOMO = betaHOMO;
	}

	public double getBetaLUMO() {
		return betaLUMO;
	}

	public void setBetaLUMO(double betaLUMO) {
		this.betaLUMO = betaLUMO;
	}

	public List<Double> getBetaOrbital() {
		return betaOrbital;
	}

	public void setBetaOrbital(List<Double> betaOrbital) {
		this.betaOrbital = betaOrbital;
	}

	public double getUnrestrictedSpinGuess() {
		return unrestrictedSpinGuess;
	}

	public void setUnrestrictedSpinGuess(double unrestrictedSpinGuess) {
		this.unrestrictedSpinGuess = unrestrictedSpinGuess;
	}

	public double getUnrestrictedSpinReal() {
		return unrestrictedSpinReal;
	}

	public void setUnrestrictedSpinReal(double unrestrictedSpinReal) {
		this.unrestrictedSpinReal = unrestrictedSpinReal;
	}

	public Vector3d getTotalForce() {
		return totalForce;
	}

	public void setTotalForce(Vector3d totalForce) {
		this.totalForce = totalForce;
	}

	public List<Vector3d> getForces() {
		return forces;
	}

	public void setForces(List<Vector3d> forces) {
		this.forces = forces;
	}

	public List<Vector3d> getXyzs() {
		return xyzs;
	}

	public void setXyzs(List<Vector3d> xyzs) {
		this.xyzs = xyzs;
	}

	public JaguarOptimizationStepBean(String relativeFilePath,
			double totalEnergy, double alphaHOMO, double alphaLUMO,
			List<Double> alphaOrbital, double betaHOMO, double betaLUMO,
			List<Double> betaOrbital, double unrestrictedSpinGuess,
			double unrestrictedSpinReal, List<Vector3d> forces,
			Vector3d totalForce, List<Vector3d> xyzs) {
		super();
		this.relativeFilePath = relativeFilePath;
		this.totalEnergy = totalEnergy;
		this.alphaHOMO = alphaHOMO;
		this.alphaLUMO = alphaLUMO;
		this.alphaOrbital = alphaOrbital;
		this.betaHOMO = betaHOMO;
		this.betaLUMO = betaLUMO;
		this.betaOrbital = betaOrbital;
		this.unrestrictedSpinGuess = unrestrictedSpinGuess;
		this.unrestrictedSpinReal = unrestrictedSpinReal;
		this.forces = forces;
		this.totalForce = totalForce;
		this.xyzs = xyzs;
	}





	
}
