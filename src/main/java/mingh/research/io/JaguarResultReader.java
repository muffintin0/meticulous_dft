package mingh.research.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.springframework.context.support.GenericXmlApplicationContext;

import mingh.research.io.util.JaguarFileBean;
import mingh.research.io.util.JaguarResultBean;

public class JaguarResultReader {
	
	public static void main(String[] args) throws IOException{
		//create Jaguar jobs
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath*:META-INF/spring/applicationContext*.xml");
		ctx.refresh();
		
		Path startingDir = Paths.get("/media/muffintin0/Elements/Research/DOE/Bimetallic/Store/Bimetallic/13/CoCuTSSP");
		PersistJaguarJob persistJaguarJob = new PersistJaguarTSNCJob();
		
		JaguarResultReader reader = new JaguarResultReader(startingDir, persistJaguarJob);
		//Files.walkFileTree(startingDir, reader.new FindJavaVisitor());
		System.out.print(reader);
	}

	private final static Path ROOT_PATH  = Paths.get("/media/muffintin0/Elements/Research/DOE/Bimetallic/Store");
	
	private Path dirPath; //go through directory to read jobs
	
	private Map<String,JaguarResultBean> result;
	
	private Map<String,Map<String,List<Path>>> jobFiles;
	
	public Path getDirPath() {
		return dirPath;
	}

	public void setDirPath(Path dirPath) {
		this.dirPath = dirPath;
	}

	public Map<String, JaguarResultBean> getResult() {
		return result;
	}

	public void setResult(Map<String, JaguarResultBean> result) {
		this.result = result;
	}
	
	public JaguarResultReader(Path dirPath, PersistJaguarJob persistJaguarJob) throws IOException{
		Path logFile = Paths.get(dirPath.toString()+"/ResearchDataRead.log");
		Set<PosixFilePermission> perms =
				PosixFilePermissions.fromString("rw-rw-rw-");
		FileAttribute<Set<PosixFilePermission>> attr =
				PosixFilePermissions.asFileAttribute(perms);
		Files.deleteIfExists(logFile);
		Files.createFile(logFile, attr);
		BufferedWriter writer =
				Files.newBufferedWriter(logFile, StandardCharsets.UTF_8,StandardOpenOption.WRITE);
		
		this.dirPath = dirPath;
		this.result = new HashMap<String, JaguarResultBean>();
		this.jobFiles = new HashMap<String,Map<String,List<Path>>>();
		FindJavaVisitor visitor = new FindJavaVisitor();
		Files.walkFileTree(dirPath, visitor);	
		this.jobFiles = visitor.getJobFiles();	
		for ( String jobname : jobFiles.keySet()){
			
			System.out.println(jobname);
			
			JaguarResultBean resultBean = new JaguarResultBean();
			
			this.setJaguarFilePath(jobname, resultBean); //generate all the relative paths from the jobFiles
			
			if ( !jobFiles.get(jobname).containsKey("out")) continue;
			
			for ( Path filePath : jobFiles.get(jobname).get("out") ){ //read the out file
				new ReadJaguarOut(filePath,resultBean, ROOT_PATH);
			}
			
			if ( jobFiles.get(jobname).containsKey("in")){
				Path inFilePath = jobFiles.get(jobname).get("in").get(0); //read the first input file
				new ReadJaguarIn(inFilePath, resultBean);
			}

			System.out.println(resultBean.toString());
			
			writer.write(jobname+"\n");
			writer.write(resultBean.toString()+"\n\n");
			persistJaguarJob.persist(jobname, resultBean); //persist the job
			
			this.result.put(jobname, resultBean);

		}
		System.out.println("Total job numbers "+ this.result.size());
	}
	
	//set the relative paths for a jaguar job from the jobFiles , put in result bean
	public void setJaguarFilePath(String jobname, JaguarResultBean resultBean) throws IOException{
		List<JaguarFileBean> jaguarFiles = new ArrayList<JaguarFileBean>();
		for(String type : this.jobFiles.get(jobname).keySet()){
			for(Path filePath : this.jobFiles.get(jobname).get(type)){
				String relativeFile = ROOT_PATH.relativize(filePath).toString();
				long size = Files.size(filePath);
				jaguarFiles.add(new JaguarFileBean(relativeFile, size, type));
			}
		}
		resultBean.setJaguarFiles(jaguarFiles);
	}
	
	public JaguarResultReader(Path dirPath, Map<String, JaguarResultBean> result) {
		super();
		this.dirPath = dirPath;
		this.result = result;
	}
	
	public Map<String,Map<String,List<Path>>> getJobFiles() {
		return jobFiles;
	}

	public void setJobFiles(Map<String,Map<String,List<Path>>> jobFiles) {
		this.jobFiles = jobFiles;
	}
	
	@Override
	public String toString() {
		String str = "Dir is "+ dirPath;
		str += "\n assembled files for each job\n";
		for ( String jobname : jobFiles.keySet()){
			str += ("job name is "+ jobname + "\n");
			for ( String fileType : jobFiles.get(jobname).keySet() ) {
				str += ("file type is "+ fileType + "\n");
				for ( Path filePath : jobFiles.get(jobname).get(fileType) ){
					str += (filePath.toString()+"\n");
				}
			}
			if (result.containsKey(jobname)){
				str += result.get(jobname).toString();
			}
		}
		
		return str;
	}

	private static class FindJavaVisitor extends SimpleFileVisitor<Path>
	{
		private Map<String,Map<String,List<Path>>> jobFiles;
		
		public Map<String,Map<String,List<Path>>> getJobFiles(){
			return jobFiles;
		}
		
		public FindJavaVisitor(){
			jobFiles = new HashMap<String,Map<String,List<Path>>>();
		}
		
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){		
			String fileBaseName = FilenameUtils.getBaseName(file.toString());
			String suffix = FilenameUtils.getExtension(file.toString());
			
			if ( fileBaseName.contains(".") ) { //this is at least the second run
				String jobBaseName = fileBaseName.split("\\.")[0];
				if ( !jobFiles.containsKey(jobBaseName) ) {
					Map<String, List<Path>> relatedFiles = new HashMap<String,List<Path>>();
					jobFiles.put(jobBaseName, relatedFiles);
				} 
				if ( ! jobFiles.get(jobBaseName).containsKey(suffix) ) {
					jobFiles.get(jobBaseName).put(suffix, new ArrayList<Path>()); 
				}
				jobFiles.get(jobBaseName).get(suffix).add(file); //following the natural reading order
			} else { //this is the first run
				String jobBaseName = fileBaseName;
				if ( !jobFiles.containsKey(jobBaseName) ) {
					Map<String, List<Path>> relatedFiles = new HashMap<String,List<Path>>();
					jobFiles.put(jobBaseName, relatedFiles);
				} 
				if ( ! jobFiles.get(jobBaseName).containsKey(suffix) ) {
					jobFiles.get(jobBaseName).put(suffix, new ArrayList<Path>()); 
				}
				jobFiles.get(jobBaseName).get(suffix).add(0, file) ; //add to the first position				
			}

			return FileVisitResult.CONTINUE;
		}
	}

}
