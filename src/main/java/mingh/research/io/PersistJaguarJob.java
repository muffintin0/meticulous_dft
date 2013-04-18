package mingh.research.io;

import mingh.research.io.util.JaguarResultBean;

public interface PersistJaguarJob {

	public void persist(String jobname, JaguarResultBean jaguarResultBean);
}
