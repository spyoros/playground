import workspaces.playground.application.applicationLogic.TaskManager;
import workspaces.playground.application.applicationLogic.FileManager;
import workspaces.playground.application.userInterface.userCLI;
import java.util.Scanner;

public class TaskTracker{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        FileManager fileManager = new FileManager();
        userCLI ui = new userCLI(scanner, taskManager, fileManager, new StringBuilder(""));
        
        ui.start();
    }
}
