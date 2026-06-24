package workspaces.playground.application.applicationLogic;

import java.util.Scanner;
import java.util.FileWriter;
import java.nio.File;
import java.nio.Path;
import java.nio.file.Paths;

public class FileManager{
    private File taskFile;
    private Scanner fileReader;
    private FileWriter fileWrite;
    
    public void createFile(String name) throws Exception{
        taskFile = new taskFile(name + ".json");
        if(taskFile.createNewFile()){
            System.out.println(taskFile + " has been created.");
            fileReader = new Scanner(Paths.get(taskFile.getName()));
            fileWrite = new FileWriter(taskFile);
            
        }else{
            System.out.println("The file already exists.");
            
        }
        
    }
    
    public void writeToFile(){
        
    }
    
    public void readFromFile(){
        
    }
}