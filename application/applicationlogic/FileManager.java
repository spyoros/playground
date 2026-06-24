package applicationlogic;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileManager{
    private File taskFile;
    private Scanner fileReader;
    private FileWriter fileWrite;
    
    public void createFile(String name) throws Exception{
        taskFile = new File(name + ".json");
        if(taskFile.createNewFile()){
            System.out.println(taskFile + " has been created.");
            fileReader = new Scanner(taskFile);
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