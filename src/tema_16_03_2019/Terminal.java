package tema_16_03_2019;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;


public class Terminal {
	
	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		new Terminal().help();
	}
			
	public static void start() {
		
	}
	
	public void changeDirectory() { // "cd" command
		Path path1 = Paths.get("C:\\Users\\Ciprian");
		System.out.print(path1 + " ");
		path1 = Paths.get(scan.nextLine().substring(3));
		System.out.println(path1);
	}
	
	public void copyFiles() { // "copy" command
		Path source = Paths.get(scan.nextLine());
		Path target = Paths.get(scan.nextLine());
		try {
			Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("The file was copied.");
		} catch (IOException e) {
			System.out.println("The file is not found!!!");
		}
	}
	
	public void copyFolder() { // "xcopy" command
		Path source = Paths.get(scan.nextLine());
		Path target = Paths.get(scan.nextLine());
		try {
			Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("The folder was copied.");
		} catch (IOException e) {
			System.out.println("The folder is not found!!!");
		}
	}
	
	public void deleteFile() { // "del" command
		try {
			Path path = Paths.get(scan.nextLine());
			Files.delete(path);
			System.out.println("The files was deleted");
		} catch (IOException e) {
			System.out.println("The file is not found!!!");
		}
	}
	
	public void removeDirectory() { // "RD" command
		try {
			Path path = Paths.get(scan.nextLine());
			Files.delete(path);
			System.out.println("The files was deleted");
		} catch (IOException e) {
			System.out.println("The file is not found!!!");
		}
	}
	
	public void showDirectories() { // "dir" command
		Path path = Paths.get(scan.nextLine());
		try {
			Files.walk(path)
				 .map(path1 -> path1.toFile().getName())
				 .sorted()
				 .forEach(file -> System.out.println(file));		
		} catch (UncheckedIOException e) {
			System.out.println("The access to this directory is denied!");
		} catch (IOException e) {
			System.out.println("The directory is not found!!!");
		}	 
	}
	
	public void createDirectory() { // "mkdir" command
		Path path = Paths.get(scan.nextLine());
			try {
				Files.createDirectory(path);
				System.out.println("The directory was created");
			} catch (FileAlreadyExistsException e){
				System.out.println("The directory already exists!!!");
			} catch (IOException e) {
				System.out.println("The directory is not found!!!");
			}
	}
	
	
	public void renameFile() { // "ren" command
		Path path = Paths.get(scan.nextLine());
		File target = Paths.get(scan.nextLine()).toFile();
		boolean isrenamed = path.toFile().renameTo(target);
		if (isrenamed == true) {
			System.out.println("The file was renamed");
		}else {
			System.out.println("The files was no found!!!");
		}
	}
	
	public void renameFolder() { // "rendir" command
		Path path = Paths.get(scan.nextLine());
		File target = Paths.get(scan.nextLine()).toFile();
		boolean isrenamed = path.toFile().renameTo(target);
		if (isrenamed == true) {
			System.out.println("The folder was renamed");
		}else {
			System.out.println("The folder was no found!!!");
		}
	}
	
	public void move() { 
		Path source = Paths.get(scan.nextLine());
		Path target = Paths.get(scan.nextLine());
		try {
			Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("The file was moved.");
		} catch (IOException e) {
			System.out.println("The file cannot be moved!!!");
		}
	}
	
	public void help() {
		Path help = Paths.get("help.txt");
		try {
			Files.readAllLines(help)
				 .forEach(line -> System.out.println(line));
		} catch (IOException e) {
			System.out.println("The folder was no found!!!");
		}
	}
}
