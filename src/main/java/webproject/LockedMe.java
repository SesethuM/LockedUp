package webproject;

public class LockedMe {

public static void main(String[] args) {
		
		// Create "main" folder if not present in current folder structure
		FileGuidelines.createMainFolderIfNotPresent("main");
		
		MenuGuidelines.printWelcomeScreen("LockedMe", "Sesethu Mqomboti");
		
		HandlingGuidlines.handleWelcomeScreenInput();
	}

	
}
