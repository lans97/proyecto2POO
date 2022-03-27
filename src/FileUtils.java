import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {

    public File getFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        return new File(resource.getFile());
    }

    public void printfileHead(String fileName) throws Exception{
        URL url = getClass().getResource(fileName);
        File file = new File(url.getPath());
        Scanner reader = new Scanner(file);

        for (int i = 0; i < 10; i++) {
            System.out.println(reader.nextLine());
        }

        reader.close();
    }

    public ArrayList<Float> fileGetFloatArray(String fileName) throws Exception{
        ArrayList<Float> output = new ArrayList<>();
        URL url = getClass().getResource(fileName);
        File file = new File(url.getPath());
        Scanner reader = new Scanner(file);
        reader.nextLine();
        while(reader.hasNextLine()){
            for (String element : reader.nextLine().split(",")) {
                output.add(Float.parseFloat(element));
            }
        }

        reader.close();

        return output;
    }

    public void writeToWekaFile(ArrayList<Float> data, String fileName) throws Exception{
        File wekaFile = new File("src/" + fileName);
        if(wekaFile.createNewFile()){
            System.out.println("Empty file created: " + wekaFile.getName());
        } else{
            System.out.println("File already exists.");
            return;
        }
        
        FileWriter fw = new FileWriter("src/" + fileName);
        fw.write("@relation equipo3\n");
        fw.write("\n");
        fw.write("@attribute age REAL\n");
        fw.write("@attribute sex REAL\n");
        fw.write("@attribute cpain REAL\n");
        fw.write("@attribute restbp REAL\n");
        fw.write("@attribute chol REAL\n");
        fw.write("@attribute fbs REAL\n");
        fw.write("\n");
        fw.write("@data\n");

        int i = 0;

        for (Float valor : data) {
            switch (i) {
                case 0:
                    fw.write(valor.toString() + ", ");
                    i++;
                    break;
            
                case 1:
                    fw.write(valor.toString() + ", ");
                    i++;
                    break;

                case 2:
                    fw.write(valor.toString() + ", ");
                    i++;
                    break;
            
                case 3:
                    fw.write(valor.toString() + ", ");
                    i++;
                    break;

                case 4:
                    fw.write(valor.toString() + ", ");
                    i++;
                    break;
            
                case 5:
                    fw.write(valor.toString() + "\n");
                    i++;
                    break;

                case 6:
                    i++;
                    break;
            
                case 7:
                    i++;
                    break;
                
                case 8:
                    i++;
                    break;

                case 9:
                    i++;
                    break;
            
                case 10:
                    i++;
                    break;

                case 11:
                    i++;
                    break;
            
                case 12:
                    i++;
                    break;

                case 13:
                    i = 0;
                    break;
                default:
                    System.out.println("oops!");
                    break;
            }
        }

        fw.close();

    }

}
