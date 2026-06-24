package workspaces.playground.application.domain;

import workspaces.playground.application.domain.Status;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task{
    private String id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public Task(String description, String id){
        this.description = description;
        this.id = id;
        status = Status.TODO;
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    public String toString(){
        return "ID: " + id
            + "\nStatus: " + status
            + "\nDescription: " + description
            + "\nCreated: " + createdAt
            + "\nUpdated: " + updatedAt
            + "\n";
    }
    
    public void updateTask(String updatedDescription){
        description = updatedDescription;
        updatedAt = LocalDateTime.now();
    }
    
    public boolean changeStatus(String newStatus){
        if(newStatus.equals("mark-in-progress")){
            status = Status.IN_PROGRESS;
            return true;
        }else if(newStatus.equals("mark-done")){
            status = Status.DONE;
            return true;
        }
        
        return false;
    }
    
    public Status getStatus(){
        return status;
    }
    
    public String getID(){
        return id;
    }
    
    public void setID(String id){
        this.id = id;
    }
    
    public boolean equals(Object object){
        if(object == null){
            return false;
        }
        
        if(object == this){
            return true;
        }
        
        if(!(object instanceof Task)){
            return false;
        }
        
        Task compared = (Task) object;
        
        return Objects.equals(id, compared.id);
    }
}