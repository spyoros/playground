package workspaces.playground.application.userInterface;

import java.util.Scanner;
import workspaces.playground.application.applicationLogic.TaskManager;
import workspaces.playground.application.applicationLogic.FileManager;

public class userCLI{
    private Scanner scanner;
    private TaskManager taskManager;
    private FileManager fileManager;
    private StringBuilder builtInput;
    
    public userCLI(Scanner scanner, TaskManager taskManager, FileManager fileManager, StringBuilder builtInput){
        this.scanner = scanner;
        this.taskManager = taskManager;
        this.fileManager = fileManager;
        this.builtInput = builtInput;
    }
    
    public void start(){
        while(true){
            System.out.println("----COMMANDS ARE SPECIFIC---"
                + "\n\nadd [task] - adds a task"
                + "\nupdate [task ID] [updated task] - updates the task based on the valid ID"
                + "\ndelete [task ID] - deletes the task based on the valid ID"
                + "\nmark-[done/in-progress] [task ID] - "
                + "\nlist [Optional: done/todo/in-progress] - prints the tasks with or without the optional argument"
                + "\n\n(Enter a empty string to stop or enter cmds to show avaliable commands to execute)\n"
                );
                
                while(true){
                    System.out.print("task-cli ");
                    String userInput = scanner.nextLine();
                    
                    if(userInput.equals("")){
                        break;
                    }
                    
                    String[] input = userInput.split(" ");
                    
                    try{
                        if(input[0].equals("add") && input.length >= 2){
                            taskManager.addTask(this.buildInput(input, 1));
                            builtInput.delete(0, builtInput.length());
                            
                        }else if(input[0].equals("update")){
                            if(!(taskManager.updateTask(input[1], this.buildInput(input, 2))) && input.length < 3){
                                System.out.println("Invalid ID.");
                            }
                            
                            builtInput.delete(0, builtInput.length());
                            
                        }else if(input[0].equals("delete") && input.length == 2){
                            if(!taskManager.deleteTask(input[1])){
                                System.out.println("Invalid input.");
                            }
                            
                        }else if((input[0].equals("mark-in-progress") || input[0].equals("mark-done")) && input.length == 2){
                            if(!(taskManager.changeStatus(input[0], input[1]))){
                                System.out.println("Invalid input.");
                            }
                            
                        }else if(input[0].equals("list") && input.length == 1){
                            taskManager.printTasks();
                            
                        }else if(input[1].equals("done") && input.length == 2){
                            taskManager.printTasksDone();
                            
                        }else if(input[1].equals("todo") && input.length == 2){
                            taskManager.printTasksNotDone();
                            
                        }else if(input[1].equals("in-progress") && input.length == 2){
                            taskManager.printTasksInProgress();
                            
                        }
                        
                    }catch(Exception e){
                        e.printStackTrace();
                        System.out.println("\nInvalid input\n");
                        
                    }
                }
                
            break;
        }
        System.out.println("\nCompleted.\n");
        
    }
    
    public String buildInput(String[] input, int start){
        for(int i = start; i < input.length; i++){
            builtInput.append(input[i]).append(" ");
        }
        
        return builtInput.toString();
    }
}