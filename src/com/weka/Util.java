package com.weka;

import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.Logistic;
import weka.classifiers.lazy.IBk;
import weka.classifiers.lazy.LWL;
import weka.classifiers.meta.RegressionByDiscretization;
import weka.classifiers.rules.OneR;
import weka.classifiers.rules.PART;
import weka.classifiers.trees.DecisionStump;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.M5P;
import weka.core.SerializationHelper;
import weka.core.Utils;

public class Util {
	public static Classifier getClassifier(String classFileName) {
		Object classifier = null;

		try {
			switch (classFileName.hashCode()) {
				case -1815359824 :
					if (classFileName.equals("RegressionByDiscretization")) {
						RegressionByDiscretization c13 = new RegressionByDiscretization();
						classifier = c13;
					}
					break;
				case -50641562 :
					if (classFileName.equals("LinearRegression")) {
						LinearRegression c10 = new LinearRegression();
						classifier = c10;
					}
					break;
				case 72306 :
					if (classFileName.equals("IBk")) {
						IBk c3 = new IBk();
						classifier = c3;
					}
					break;
				case 72782 :
					if (classFileName.equals("J48")) {
						J48 c2 = new J48();
						classifier = c2;
					}
					break;
				case 75815 :
					if (classFileName.equals("LWR")) {
						LWL c12 = new LWL();
						classifier = c12;
					}
					break;
				case 82506 :
					if (classFileName.equals("SVM")) {
						LibSVM c1 = new LibSVM();
						String[] options = Utils.splitOptions("-K 0 -D 3");
						c1.setOptions(options);
						classifier = c1;
					}
					break;
				case 2448371 :
					if (classFileName.equals("PART")) {
						PART c5 = new PART();
						classifier = c5;
					}
					break;
				case 2462412 :
					if (classFileName.equals("OneR")) {
						OneR c6 = new OneR();
						classifier = c6;
					}
					break;
				case 283027515 :
					if (classFileName.equals("DecisionStump")) {
						DecisionStump c9 = new DecisionStump();
						classifier = c9;
					}
					break;
				case 1084441035 :
					if (!classFileName.equals("KernelDensity")) {
						;
					}
					break;
				case 1213033943 :
					if (classFileName.equals("M5Prime")) {
						M5P c11 = new M5P();
						classifier = c11;
					}
					break;
				case 1240641315 :
					if (classFileName.equals("NaiveBayes")) {
						NaiveBayes c4 = new NaiveBayes();
						classifier = c4;
					}
					break;
				case 2087573120 :
					if (classFileName.equals("Logistic")) {
						Logistic c8 = new Logistic();
						classifier = c8;
					}
			}
		} catch (Exception e) {
			System.out.println("Classifiers create Excption : " + classFileName);
			e.printStackTrace();
		}
		return (Classifier) classifier;
	}
	public static Classifier readModel(String classFileName, String modelPath) {
		Object classifier = null;
		try {
			switch (classFileName.hashCode()) {
				case -1815359824 :
					if (classFileName.equals("RegressionByDiscretization")) {
						classifier = (RegressionByDiscretization) SerializationHelper.read(modelPath);
					}
					break;
				case -50641562 :
					if (classFileName.equals("LinearRegression")) {
						classifier = (LinearRegression) SerializationHelper.read(modelPath);
					}
					break;
				case 72306 :
					if (classFileName.equals("IBk")) {
						classifier = (IBk) SerializationHelper.read(modelPath);
					}
					break;
				case 72782 :
					if (classFileName.equals("J48")) {
						classifier = (J48) SerializationHelper.read(modelPath);
					}
					break;
				case 75815 :
					if (classFileName.equals("LWR")) {
						classifier = (LWL) SerializationHelper.read(modelPath);
					}
					break;
				case 82506 :
					if (classFileName.equals("SVM")) {
						classifier = (LibSVM) SerializationHelper.read(modelPath);
					}
					break;
				case 2448371 :
					if (classFileName.equals("PART")) {
						classifier = (PART) SerializationHelper.read(modelPath);
					}
					break;
				case 2462412 :
					if (classFileName.equals("OneR")) {
						classifier = (OneR) SerializationHelper.read(modelPath);
					}
					break;
				case 283027515 :
					if (classFileName.equals("DecisionStump")) {
						classifier = (DecisionStump) SerializationHelper.read(modelPath);
					}
					break;
				case 1084441035 :
					if (!classFileName.equals("KernelDensity")) {
						;
					}
					break;
				case 1213033943 :
					if (classFileName.equals("M5Prime")) {
						classifier = (M5P) SerializationHelper.read(modelPath);
					}
					break;
				case 1240641315 :
					if (classFileName.equals("NaiveBayes")) {
						classifier = (NaiveBayes) SerializationHelper.read(modelPath);
					}
					break;
				case 2087573120 :
					if (classFileName.equals("Logistic")) {
						classifier = (Logistic) SerializationHelper.read(modelPath);
					}
			}
		} catch (Exception e) {
			System.out.println("Model read Excption : " + classFileName + " p : " + modelPath);
			e.printStackTrace();
		}

		return (Classifier) classifier;
	}
}