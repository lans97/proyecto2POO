import java.io.File;
import java.util.ArrayList;

import weka.classifiers.trees.RandomTree;
import weka.core.Instances;

import weka.core.DenseInstance;
import weka.core.Instance;

public class App {
    public static void main(String[] args) throws Exception {
        FileUtils fileUtils = new FileUtils();
        ArrayList<Float> data;
        data = fileUtils.fileGetFloatArray("heart.csv");

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

        Instance instance = new DenseInstance(6);
        instance.setDataset(instances);
        instance.setValue(0, 58);// Age
        instance.setValue(1, 0);// Sex
        instance.setValue(2, 3);// Chest Pain [intensity]
        instance.setValue(3, 140);// Resting Blood Pressure [mm Hg]
        instance.setValue(4, 210);// Cholesterol
        instance.setValue(5, 1);// Fasting Blood Sugar [bool]

        int result = (int) tree.classifyInstance(instance);

        System.out.println(result);


    }
}
