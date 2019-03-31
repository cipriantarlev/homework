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
		new Terminal().start();
	}
			
	public void start() {
		System.out.print("C:\\Temp ");
		boolean mark = true;
		while(mark) {
			switch (scan.next()) {
			case "cd":
				changeDirectory();
				break;
			case "copy":
				copyFiles();
				break;
			case "xcopy":
				copyFolder();
				break;
			case "del":
				deleteFile();
				break;
			case "rd":
				removeDirectory();
				break;
			case "dir":
				showDirectories();
				break;
			case "mkdir":
				createDirectory();
				break;
			case "ren":
				renameFile();
				break;
			case "rendir":
				renameFolder();
				break;
			case "move":
				move();
				break;
			case "help":
				help();
				break;
			case "exit":
				mark = false;
				break;
			default:
				System.out.println("Please enter a valid command!");
			}
		}
	}
	
	public void changeDirectory() { // "cd" command
		System.out.println(Paths.get(scan.next()));
	}
	
	public void copyFiles() { // "copy" command
		try {
			Files.copy(Paths.get(scan.next()), Paths.get(scan.next()), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("The file was copied.");
		} catch (IOException e) {
			System.out.println("The file is not found!!!");
		}
	}
	
	public void copyFolder() { // "xcopy" command
		try {
			Files.copy(Paths.get(scan.next()), Paths.get(scan.next()), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("The folder was copied.");
		} catch (IOException e) {
			System.out.println("The folder is not found!!!");
		}
	}
	
	public void deleteFile() { // "del" command
		try {
			Files.delete(Paths.get(scan.next()));
			System.out.println("The files was deleted");
		} catch (IOException e) {
			System.out.println("The file is not found!!!");
		}
	}
	
	public void removeDirectory() { // "RD" command
		try {
			Files.delete(Paths.get(scan.next()));
			System.out.println("The files was deleted");
		} catch (IOException e) {
			System.out.println("The file is not found!!!");
		}
	}
	
	public void showDirectories() { // "dir" command
		try {
			Files.walk(Paths.get(scan.next()))
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
			try {
				Files.createDirectory(Paths.get(scan.next()));
				System.out.println("The directory was created");
			} catch (FileAlreadyExistsException e){
				System.out.println("The directory already exists!!!");
			} catch (IOException e) {
				System.out.println("The directory is not found!!!");
			}
	}
	
	
	public void renameFile() { // "ren" command
		Path source = Paths.get(scan.nextLine());
		File target = Paths.get(scan.nextLine()).toFile();
		boolean isrenamed = source.toFile().renameTo(target);
		if (isrenamed == true) {
			System.out.println("The file was renamed");
		}else {
			System.out.println("The files was no found!!!");
		}
	}
	
	public void renameFolder() { // "rendir" command
		Path source = Paths.get(scan.next());
		File target = Paths.get(scan.next()).toFile();
		boolean isrenamed = source.toFile().renameTo(target);
		if (isrenamed == true) {
			System.out.println("The folder was renamed");
		}else {
			System.out.println("The folder was no found!!!");
		}
	}
	
	public void move() { 
		try {
			Files.move(Paths.get(scan.next()), Paths.get(scan.next()), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("The file was moved.");
		} catch (IOException e) {
			System.out.println("The file cannot be moved!!!");
		}
	}
	
	public void help() {
		try {
			Files.readAllLines(Paths.get("help.txt"))
				 .forEach(line -> System.out.println(line));
		} catch (IOException e) {
			System.out.println("The folder was no found!!!");
		}
	}
}
