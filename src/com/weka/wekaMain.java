package com.weka;

import com.weka.Util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;

public class wekaMain {
	public static Classifier cl;
	public static String classFileName;
	Instances iris = null;
	String file;
	String fileDir;
	String fileName;

	public void loadArff() {
		DataSource source = null;

		try {
			source = new DataSource(this.file + this.fileName + ".arff");
			this.iris = source.getDataSet();
			if (this.iris.classIndex() == -1) {
				this.iris.setClassIndex(this.iris.numAttributes() - 1);
			}
		} catch (Exception arg2) {
			arg2.printStackTrace();
		}

	}

	public void generalteModel() {
		try {
			cl.buildClassifier(this.iris);
		} catch (Exception arg1) {
			arg1.printStackTrace();
		}

	}

	public void saveModel() {
		try {
			SerializationHelper.write(this.fileDir + this.fileName + ".model", cl);
		} catch (Exception arg1) {
			arg1.printStackTrace();
		}

	}

	public void crossValidate() {
		Evaluation eval = null;
		String dir = this.fileDir + this.fileName;

		try {
			eval = new Evaluation(this.iris);
			eval.crossValidateModel(cl, this.iris, 10, new Random(1L), new Object[0]);
			cl = Util.readModel(classFileName, dir + ".model");
			String e = "-------result--------------\n" + eval.toSummaryString() + "\n" + eval.toClassDetailsString()
					+ "\n" + eval.toMatrixString() + "\n" + cl;
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dir + ".txt"), "UTF-8"));
			bw.write(e);
			bw.flush();
			bw.close();
		} catch (Exception arg4) {
			arg4.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		wekaMain test = new wekaMain();
		if (args.length > 0) {
			classFileName = args[0];
			if (args.length == 2) {
				test.fileName = args[1];
				cl = Util.getClassifier(classFileName);
				test.file = "./arff/";
				test.fileDir = "./result/" + classFileName + "/" + test.fileName + "/";
				System.out.println("*\n Classifier : " + classFileName + "\n ARFF DIR :" + test.file + test.fileName + "\n File Name : " + test.fileName + "\n Result DIR : " + test.fileDir + "\n*");
				File Folder = new File(test.fileDir);
				if (!Folder.exists()) {
					try {
						Folder.mkdirs();
					} catch (Exception arg6) {
						arg6.printStackTrace();
					}
				}

				test.loadArff();
				test.generalteModel();
				test.saveModel();
				test.crossValidate();
				long end = System.currentTimeMillis() - start;
				System.out.println("Run Time : " + end / 1000L + " second");
			} else {
				System.out.println("not found ARFF File \n ex) java -jar <<jar name>> <<Classififer Name>> <<ARFF File Name>>");
			}
		} else {
			System.out.println("not found Classifier\n ex) java -jar <<jar name>> <<Classififer Name>> <<ARFF File Name>>");
		}
	}
}