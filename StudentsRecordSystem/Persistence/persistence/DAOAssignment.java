package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import Domain.Assignment;
import Domain.Module;
import Domain.ProgramStudents;

public class DAOAssignment implements DAOAssignmentInterface{
	private static Scanner scan = new Scanner(System.in);

	public static String checkState(String moduleID) {
		String result = "ready";
		try {
			BufferedReader br = new BufferedReader(new FileReader("./StorageFiles/assignment.txt"));
			String line = null;
			int total = 0;
			while ((line = br.readLine()) != null) {
				String[] tmp = line.split(","); // split by ","
				for (int i = 0; i < tmp.length; i++) {
					if (tmp[i].indexOf(moduleID) != -1) {
						total += Integer.parseInt(tmp[3]);
					}
				}
			}
			// System.out.println("total:"+total);
			if (total == 100) {
				result = "ready";
			} else if (total < 100) {
				result = "not ready";
			} else {
				System.out.println("over 100");
			}
			br.close();
		} catch (IOException e) {
			System.out.println("select failed");
			result = "over 100";
		}
		// System.out.print(result);
		return result;
	}

	public static Assignment getItem(String item) {
		String line;
		try {
			FileReader f = new FileReader("./StorageFiles/assignment.txt");
			BufferedReader b = new BufferedReader(f);

			while ((line = b.readLine()) != null) {
				String[] parts = line.split(",");
				if (item.equals(parts[0])) {
					b.close();
					return new Assignment(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
				}
			}
			b.close();
		} catch (Exception e) {
			System.out.println("Error in the file reading");
		}
		return null;
	}

	public static boolean createAssignment(Assignment assignment) {
		boolean result = true;
		FileWriter file = null;
		PrintWriter pw = null;
		try {
			file = new FileWriter("./StorageFiles/assignment.txt", true);
			pw = new PrintWriter(file);
			pw.println(assignment.getName() + "," + assignment.getModuleId() + "," + assignment.getDescription() + ","
					+ assignment.getPercentage());

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			try {
				if (null != file)
					file.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public static String checkBeforeAdd(String moduleId, int percentage) {
		String result = "ready";
		try {
			BufferedReader br = new BufferedReader(new FileReader("./StorageFiles/assignment.txt"));
			String line = null;
			int total = 0;
			while ((line = br.readLine()) != null) {
				String[] tmp = line.split(","); // split by ","
				for (int i = 0; i < tmp.length; i++) {
					if (tmp[i].indexOf(moduleId) != -1) {
						total += Integer.parseInt(tmp[3]);
					}
				}
			}

			total = total + percentage;
			System.out.println("total:" + total);
			if (total == 100) {
				result = "ready";
			} else if (total < 100) {
				result = "not ready";
			} else {
				result = "over 100";
				System.out.println("Total percevtage over 100");
			}
			br.close();
		} catch (IOException e) {
			System.out.println("select failed");
			result = "over 100";
		}
		return result;
	}

	public static List<Module> getUserModule(String lecturerID) {
		String line;
		List<Module> moduleList = new ArrayList<Module>();
		try {
			FileReader f = new FileReader("./StorageFiles/modules.txt");
			BufferedReader b = new BufferedReader(f);
			while ((line = b.readLine()) != null) {
				String[] parts = line.split(",");
				for (int i = 0; i < parts.length; i++) {
					if (parts[i].indexOf(lecturerID) != -1) {
						moduleList.add(new Module(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4],
								parts[5]));
						break;
					}
				}
			}
			b.close();
		} catch (Exception e) {
			System.out.println("Error in the file reading");
			moduleList = null;
		}
		return moduleList;
	}

	public static List<Assignment> getModuleAssignment(String moduleID) {
		String line;
		List<Assignment> assList = new ArrayList<Assignment>();
		try {
			FileReader f = new FileReader("./StorageFiles/assignment.txt");
			BufferedReader b = new BufferedReader(f);
			while ((line = b.readLine()) != null) {
				String[] parts = line.split(",");
				for (int i = 0; i < parts.length; i++) {
					if (parts[i].indexOf(moduleID) != -1) {
						assList.add(new Assignment(parts[0], parts[1], parts[2], Integer.parseInt(parts[3])));
						break;
					}
				}
			}
			b.close();
		} catch (Exception e) {
			System.out.println("Error in the file reading");
			assList = null;
		}
		return assList;
	}

	public static int setGrade(String studentID, String moduleID) {
		String line = null;
		int total = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("./StorageFiles/assignment.txt"));
			while ((line = br.readLine()) != null) {
				String[] tmp = line.split(","); // split by ","
				for (int i = 0; i < tmp.length; i++) {
					if (tmp[i].indexOf(moduleID) != -1) {
						System.out.println("Please input grade of " + tmp[2] + " (full mark is 100):");
						int number = scan.nextInt();
						number = number * Integer.parseInt(tmp[3]) / 100;
						total += number;
					}
				}
			}
			System.out.println("Final grade is: " + total);
			br.close();
		} catch (IOException e) {
			System.out.println("select failed");
		} finally {

		}
		return total;
	}

	public static String chekGradeLevel(int total) {
		String grade = null;
		if (total < 100 && total > 80 || total == 80) {
			grade = "A";
		} else if (total < 80 && total > 60 || total == 60) {
			grade = "B";
		} else if (total < 60 && total > 40 || total == 40) {
			grade = "C";
		} else if (total < 40 && total > 30 || total == 30) {
			grade = "D";
		} else {
			System.out.println("Wrong grade,Please input grade again! ");
			grade = null;
		}
		System.out.println("Grade leval is: " + grade);
		return grade;
	}

	public static void update(String studentID, String moduleID, String grade) {
		File file = new File("./StorageFiles/QPV.txt");
		try {
			if (file.isFile() != true) {
				file.createNewFile();
			}
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			Vector newtxt = new Vector();
			String content = null;
			String linecount = null;
			while (line != "" && line != null) {
				String[] tmp = line.split(",");
					if (tmp[1].indexOf(studentID) != -1 && tmp[0].indexOf(moduleID) != -1) {
						content = tmp[2];
						linecount = line;
					}
				if (line == linecount) {
					if (line.split(",")[2].equals(content)) {
						String str1 = line.substring(0, line.indexOf(content));
						String str2 = line.substring(line.indexOf(content) + content.length(), line.length());
						grade=grade+":";
						newtxt.add(str1 + grade + str2);
					} else {
						newtxt.add(line);
					}
				} else {
					newtxt.add(line);
				}
				line = br.readLine();
			}
			br.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < newtxt.size(); i++) {
				writer.write(newtxt.get(i).toString());
				writer.newLine();
			}

			writer.flush();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setQPV(String studentID, String moduleID, double qpv) {
		File file = new File("./StorageFiles/QPV.txt");
		try {
			if (file.isFile() != true) {
				file.createNewFile();
			}
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			Vector newtxt = new Vector();
			String content = null;
			String linecount = null;
			while (line != "" && line != null) {
				String[] tmp = line.split(",");
				for (int i = 0; i < tmp.length; i++) {
					if (tmp[1].indexOf(studentID) != -1 && tmp[0].indexOf(moduleID) != -1) {
						content = tmp[3];
						linecount = line;
					}
				}
				if (line == linecount) {
					if (line.split(",")[3].equals(content)) {
						String str1 = line.substring(0, line.indexOf(content));
						String str2 = line.substring(line.indexOf(content) + content.length(), line.length());
						newtxt.add(str1 + qpv + str2);
					} else {
						newtxt.add(line);
					}
				} else {
					newtxt.add(line);
				}
				line = br.readLine();
			}
			br.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < newtxt.size(); i++) {
				writer.write(newtxt.get(i).toString());
				writer.newLine();
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static double chekQPVLevel(String grade) {
		double qpv = 0.00;
		if (grade=="A") {
			qpv = 4.0;
		} else if (grade=="B") {
			qpv = 3.2;
		} else if (grade=="C") {
			qpv = 2.6;
		} else if (grade=="D") {
			qpv = 1.6;
		} else {
			System.out.println("Wrong grade,Please input grade again! ");
			grade = null;
		}
		System.out.println("QPV leval is: " + qpv);
		return qpv;
	}

	public static int chekPercentage(double checkqpv) {
		int percentage = 0;
		if (checkqpv==4.0) {
			percentage = 90;
		} else if (checkqpv==3.2) {
			percentage = 80;
		} else if (checkqpv==2.6) {
			percentage = 60;
		} else if (checkqpv==1.6) {
			percentage = 30;
		} else {
			System.out.println("Wrong grade,Please input grade again! ");
			percentage = 0;
		}
		System.out.println("Percentage level is: " + percentage+"%");
		return percentage;
	}

	public static void setPercentage(String studentID, String moduleID, int percentage) {
		File file = new File("./StorageFiles/QPV.txt");
		try {
			if (file.isFile() != true) {
				file.createNewFile();
			}
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			Vector newtxt = new Vector();
			String content = null;
			String linecount = null;
			String percentage1 = percentage+":";
			while (line != "" && line != null) {
				String[] tmp = line.split(",");
				//for (int i = 0; i < tmp.length; i++) {
					if (tmp[1].indexOf(studentID) != -1 && tmp[0].indexOf(moduleID) != -1) {
						content = tmp[4];
						linecount = line;
					}
				//}
				if (line == linecount) {
					if (line.split(",")[4].equals(content)) {
						String str1 = line.substring(0, line.indexOf(content));
						String str2 = line.substring(line.indexOf(content) + content.length(), line.length());
						newtxt.add(str1 + percentage1 + str2);
					} else {
						newtxt.add(line);
					}
				} else {
					newtxt.add(line);
				}
				line = br.readLine();
			}
			br.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < newtxt.size(); i++) {
				writer.write(newtxt.get(i).toString());
				writer.newLine();
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static double setQCA(String studentID) {
		String line = null;
		String moduleID = null,qpv=null;
		double total = 0;
		int credit=0,totalcredit=0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("./StorageFiles/QPV.txt"));
			while ((line = br.readLine()) != null) {
				String[] tmp = line.split(","); // split by ","
				//for (int i = 0; i < tmp.length; i++) {
					if (tmp[1].indexOf(studentID) != -1) {
						if(tmp[3]!=" "){
						moduleID = tmp[0];
						qpv = tmp[3];
						credit=getCredit(moduleID);
						total += Double.parseDouble(qpv)*credit;
						totalcredit+=credit;
						}
					//}
				}
			}
			total=total/totalcredit;
			total=((int)(total*100))/100;
			System.out.println("Final QCA is: " + total);
			br.close();
		} catch (IOException e) {
			System.out.println("select failed");
		} finally {

		}
		return total;
	}

	private static int getCredit(String moduleID) {
		int credit=0;
		String line;
		try{
	        FileReader f = new FileReader("./StorageFiles/modules.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	for(int i=0; i<parts.length; i++){
					if(parts[i].indexOf(moduleID)!= -1){
						credit=Integer.parseInt(parts[2]);
						break;
					}
				}
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
		}
		return credit;
	}

	public static void addQCA(String studentID,double qca) {
		File file = new File("./StorageFiles/QCA.txt");
		try {
			if (file.isFile() != true) {
				file.createNewFile();
			}
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			Vector newtxt = new Vector();
			String content = null;
			String linecount = null;
			while (line != "" && line != null) {
				String[] tmp = line.split(",");
				for (int i = 0; i < tmp.length; i++) {
					if (tmp[0].indexOf(studentID) != -1) {
						content = tmp[2];
						linecount = line;
					}
				}
				if (line == linecount) {
					if (line.split(",")[2].equals(content)) {
						String str1 = line.substring(0, line.indexOf(content));
						String str2 = line.substring(line.indexOf(content) + content.length(), line.length());
						newtxt.add(str1 + qca + str2);
					} else {
						newtxt.add(line);
					}
				} else {
					newtxt.add(line);
				}
				line = br.readLine();
			}
			br.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < newtxt.size(); i++) {
				writer.write(newtxt.get(i).toString());
				writer.newLine();
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String checkAwardLevel(double qca) {
		String award = null;
		if (qca< 4.0 && qca > 3.2 || qca == 4.0) {
			award = "A";
		} else if (qca < 3.2 && qca > 2.6 || qca == 3.2) {
			award = "B";
		} else if (qca < 2.6 && qca > 1.6 || qca == 2.6) {
			award = "C";
		} else if (qca < 1.6|| qca == 1.6) {
			award = "D";
		} else {
			System.out.println("Wrong! ");
			award = null;
		}
		System.out.println("Award Classification is: " + award);
		return award;
	}

	public static void addAward(String studentId, String award) {
		File file = new File("./StorageFiles/QCA.txt");
		try {
			if (file.isFile() != true) {
				file.createNewFile();
			}
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			Vector newtxt = new Vector();
			String content = null;
			String linecount = null;
			while (line != "" && line != null) {
				String[] tmp = line.split(",");
				for (int i = 0; i < tmp.length; i++) {
					if (tmp[0].indexOf(studentId) != -1) {
						content = tmp[3];
						linecount = line;
					}
				}
				if (line == linecount) {
					if (line.split(",")[3].equals(content)) {
						String str1 = line.substring(0, line.indexOf(content));
						String str2 = line.substring(line.indexOf(content) + content.length(), line.length());
						newtxt.add(str1 + award + str2);
					} else {
						newtxt.add(line);
					}
				} else {
					newtxt.add(line);
				}
				line = br.readLine();
			}
			br.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < newtxt.size(); i++) {
				writer.write(newtxt.get(i).toString());
				writer.newLine();
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
																																																//this is done because we already used a static method and so we are just demonstrating how to do this
																																																public void addaward(String studentId, String award) {}public String checkawardLevel(double qca) {return null;}public void addqCA(String studentID, double qca) {}public int getcredit(String moduleID) {	return 0;}public double setqCA(String studentID) {return 0;}public String checkstate(String moduleID) {	return null;}public Assignment getitem(String item) {return null;}

	}

	