package mingh.research.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import mingh.research.io.util.JaguarResultBean;

public class ReadJaguarIn {
	
	private JaguarResultBean jaguarResultBean;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReadJaguarIn testRead = new ReadJaguarIn("/media/muffintin0/Elements/Research/DOE/Bimetallic/Store/Bimetallic/13/CoCu/CH/13-cocu-ch-b3-gs-fc.in");
		System.out.print(testRead);

	}
	
	@Override
	public String toString() {
		return jaguarResultBean.toString();
	}
	
	// for test
	public ReadJaguarIn(String inFilePath){
		this.jaguarResultBean = new JaguarResultBean();
		try {
			Path inFile = Paths.get(inFilePath);
			List<String> lines = Files.readAllLines(inFile, StandardCharsets.UTF_8);
			parseLines(lines);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public ReadJaguarIn(Path inFile, JaguarResultBean jaguarResultBean){
		this.jaguarResultBean = jaguarResultBean;
		try {
			List<String> lines = Files.readAllLines(inFile, StandardCharsets.UTF_8);
			parseLines(lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void parseLines(List<String> lines) {
		int i = 0;
		while ( i<lines.size() ){
			if ( lines.get(i).contains("&gen") ){
				i+=1;
				continue; //the next line is the input params
			} else if ( lines.get(i).trim().contains("&") ){ //end of a section
				break; //just read input parameters currently
			}
			
			if (lines.get(i).contains("=")){
				String[] fragments = lines.get(i).trim().split("=");
				this.jaguarResultBean.addJaguarInput(fragments[0], fragments[1]);
			}
			i+=1;
		}
	}

}
