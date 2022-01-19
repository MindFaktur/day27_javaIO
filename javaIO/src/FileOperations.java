import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FileOperations {

    public static void fileChecker(String path)
    {
        File file = new File(path);
        System.out.println("Does File Exist : " + file.exists());
    }

    public static void fileDeleter(String path)
    {
        File file = new File(path);
        if( file.exists() ){
            System.out.println(" File deleted : " + file.delete());
            return;
        }
        System.out.println("file Does not exist");
    }

    public static void createDirectory(Path pathValue)
    {
        try {
            Files.createDirectory(pathValue);
        }
        catch (IOException e){
            if ( e.toString().contains("FileAlreadyExistsException") ) {
                System.out.println("File is already present");
            }
            else{
                System.out.println(e);
            }
        }
    }

    public static void createEmptyFile(String path)
    {
        File file = new File(path);
        try {
            System.out.println(file.createNewFile());
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public static void listEverythingInGivenDirectory(Path path)
    {
        try (DirectoryStream<Path> files = Files.newDirectoryStream(path)){
            for ( Path pathName : files ) {
                System.out.println(pathName.getFileName());
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }

}

//