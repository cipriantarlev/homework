package tema_16_03_2019;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Terminal {

	public static void main(String[] args) {
	}
	
	public static void start() {
		
	}
	
	public static void cd(String newPath) {
		
		Path path1 = Paths.get("C:\\Users\\Ciprian");
		System.out.println(path1);
		path1 = Paths.get(newPath);
		System.out.println(path1);
	}
	
	public static void copy() {
		//Files.copy(source, target, options)
		//"copy location\filename.extension newlocation\newname.extension"
	}
	
	public static void del(Path path) {
		try {
			Files.delete(path);
		} catch (IOException e) {
			System.out.println("The file is not found!!!");;
		}
	}
	
	public static void dir() {
		
	}
	
	public static void mkdir() {
		
	}
	
	public static void path() {
		
	}
	
	public static void ren() {
		
	}
	
	public static void print() {
		
	}
	
	public static void help() {
		
	}
}
