import applcationlogic.FileManager;
import applicationlogic.TaskManager;
import java.util.Scanner;
import userinterface.userCLI;

public class TaskTracker{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        FileManager fileManager = new FileManager();
        userCLI ui = new userCLI(scanner, taskManager, fileManager, new StringBuilder(""));
        
        ui.start();
    }
}

/*

*/