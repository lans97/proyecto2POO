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
        instance.setValue(0, 34);// Age
        instance.setValue(1, 0);// Sex
        instance.setValue(2, 1);// Chest Pain
        instance.setValue(3, 196);// Resting Blood Pressure
        instance.setValue(4, 210);// Cholesterol
        instance.setValue(5, 0);// Fasting Blood Sugar

        int result = (int) tree.classifyInstance(instance);

        System.out.println("Edad: 34 años");
        System.out.println("Sexo: Mujer");
        System.out.println("Dolor de pecho: Angina típica");
        System.out.println("Presión en reposo: 196 mmHg");
        System.out.println("Colesterol: 210 mg/dl");
        System.out.println("Azucar en sangre > 120 mg/dl: 0");
        System.out.println("Predicción: " + result);

        instance.setValue(0, 68);// Age
        instance.setValue(1, 1);// Sex
        instance.setValue(2, 3);// Chest Pain
        instance.setValue(3, 150);// Resting Blood Pressure
        instance.setValue(4, 160);// Cholesterol
        instance.setValue(5, 1);// Fasting Blood Sugar

        result = (int) tree.classifyInstance(instance);

        System.out.println("Edad: 68 años");
        System.out.println("Sexo: Hombre");
        System.out.println("Dolor de pecho: No angina");
        System.out.println("Presión en reposo: 150 mmHg");
        System.out.println("Colesterol: 160 mg/dl");
        System.out.println("Azucar en sangre > 120 mg/dl: 1");
        System.out.println("Predicción: " + result);

        instance.setValue(0, 37);// Age
        instance.setValue(1, 1);// Sex
        instance.setValue(2, 1);// Chest Pain
        instance.setValue(3, 196);// Resting Blood Pressure
        instance.setValue(4, 170);// Cholesterol
        instance.setValue(5, 0);// Fasting Blood Sugar

        result = (int) tree.classifyInstance(instance);

        System.out.println("Edad: 37 años");
        System.out.println("Sexo: Hombre");
        System.out.println("Dolor de pecho: Angina típica");
        System.out.println("Presión en reposo: 196 mmHg");
        System.out.println("Colesterol: 170 mg/dl");
        System.out.println("Azucar en sangre > 120 mg/dl: 0");
        System.out.println("Predicción: " + result);


    }
}
