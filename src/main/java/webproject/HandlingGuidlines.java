package webproject;

import java.util.List;
import java.util.Scanner;


public class HandlingGuidlines {

	public static void handleWelcomeScreenInput() {
		boolean continuous = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				MenuGuidelines.displayMenu();
				int input = sc.nextInt();

				switch (input) {
				case 1:
					FileGuidelines.displayAllFiles("main");
					break;
				case 2:
					HandlingGuidlines.handleFileMenuOptions();
					break;
				case 3:
					System.out.println("Program exited successfully.");
					continuous = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleWelcomeScreenInput();
			} 
		} while (continuous == true);
	}
	
	public static void handleFileMenuOptions() {
		boolean continuous = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				MenuGuidelines.displayFileMenuOptions();
				FileGuidelines.createMainFolderIfNotPresent("main");
				
				int input = sc.nextInt();
				switch (input) {
				case 1:
					// File Add
					System.out.println("Enter the name of the file to be added to the \"main\" folder");
					String fileToAdd = sc.next();
					
					FileGuidelines.createFile(fileToAdd, sc);
					
					break;
				case 2:
					// File/Folder delete
					System.out.println("Enter the name of the file to be deleted from \"main\" folder");
					String fileToDelete = sc.next();
					
					FileGuidelines.createMainFolderIfNotPresent("main");
					List<String> filesToDelete = FileGuidelines.displayFileLocations(fileToDelete, "main");
					
					String deletionPrompt = "\nSelect index of which file to delete?"
							+ "\n(Enter 0 if you want to delete all elements)";
					System.out.println(deletionPrompt);
				
					int idx = sc.nextInt();
					
					if (idx != 0) {
						FileGuidelines.deleteFileRecursively(filesToDelete.get(idx - 1));
					} else {
						
						// If idx == 0, delete all files displayed for the name
						for (String path : filesToDelete) {
							FileGuidelines.deleteFileRecursively(path);
						}
					}
					

					break;
				case 3:
					// File/Folder Search
					System.out.println("Enter the name of the file to be searched from \"main\" folder");
					String fileName = sc.next();
					
					FileGuidelines.createMainFolderIfNotPresent("main");
					FileGuidelines.displayFileLocations(fileName, "main");

					
					break;
				case 4:
					// Go to Previous menu
					return;
				case 5:
					// Exit
					System.out.println("Program exited successfully.");
					continuous = false;
					sc.close();
					System.exit(0);
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleFileMenuOptions();
			}
		} while (continuous == true);
	} }

	
