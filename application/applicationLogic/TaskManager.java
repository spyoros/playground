package workspaces.playground.application.applicationLogic;

import workspaces.playground.application.domain.Task;
import workspaces.playground.application.Domain.Status;
import java.util.HashMap;

public class TaskManager{
    private HashMap<String,Task> taskMap;
    
    public TaskManager(){
        taskMap = new HashMap<>();
    }
    
    public void addTask(String description){
        taskMap.put(String.valueOf(taskMap.size()), new Task(description, String.valueOf(taskMap.size())));
        System.out.println("Task added successfully (ID: " + (taskMap.size() - 1) + ")");
    }
    
    public boolean updateTask(String id, String updatedTask){
        if(taskMap.containsKey(id)){    
            taskMap.get(id).updateTask(updatedTask);
            return true;
        }
        
        return false;
    }
    
    public boolean deleteTask(String id){
        if(taskMap.containsKey(id)){    
            taskMap.remove(id);
            int limiter = Integer.valueOf(id);
            for(int i = limiter; i < taskMap.size(); i++){
                taskMap.get(String.valueOf(i + 1)).setID(String.valueOf(i));
                taskMap.put(String.valueOf(i), taskMap.get(String.valueOf(i + 1)));
                taskMap.remove(String.valueOf(i+1));
            }
            
            return true;
        }
        
        return false;
    }
    
    public boolean changeStatus(String status, String id){
        if(taskMap.containsKey(id)){    
            return taskMap.get(id).changeStatus(status);
        }
        
        return false;
    }
    
    public void printTasks(){
        for(Task task: taskMap.values()){
            System.out.println(task);
        }
    }
    
    public void printTasksDone(){
        taskMap.entrySet().stream()
            .filter(task -> task.getValue().getStatus() == Status.DONE)
            .forEach(task -> System.out.println(task.getValue()));
    }
    
    public void printTasksNotDone(){
        taskMap.entrySet().stream()
            .filter(task -> task.getValue().getStatus() == Status.TODO)
            .forEach(task -> System.out.println(task.getValue()));
    }
    
    public void printTasksInProgress(){
        taskMap.entrySet().stream()
            .filter(task -> task.getValue().getStatus() == Status.IN_PROGRESS)
            .forEach(task -> System.out.println(task.getValue()));
    }
}