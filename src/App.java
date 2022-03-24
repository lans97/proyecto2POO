import java.io.File;
import java.util.ArrayList;

import weka.classifiers.trees.RandomTree;
import weka.core.Instances;

public class App {
    public static void main(String[] args) throws Exception {
        FileUtils fileUtils = new FileUtils();
        ArrayList<Float> data;
        data = fileUtils.fileGetFloatArray("heart.csv");
        for (int i = 0; i < 10; i++) {
            System.out.println(data.get(i));
        }
        fileUtils.writeToWekaFile(data, "cardio.arff");
        data = null;

        File file =  fileUtils.getFile("cardio.arff");
        
        DataSourceUtils dataSourceUtils = new DataSourceUtils();
        Instances instances = dataSourceUtils.newWekaInstances(file);

        RandomTree tree = new RandomTree();
        String[] options = new String [1];
        options[0] = "-U";

        tree.setOptions(options);

        tree.buildClassifier(instances);

        System.out.println(tree);

    }
}
