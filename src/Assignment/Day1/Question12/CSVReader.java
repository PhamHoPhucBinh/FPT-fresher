package Assignment.Day1.Question12;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "D:\\Git-Repo\\FPT\\untitled\\src\\Assignment\\Day1\\Question12\\students.csv";
        String errorFile = "D:\\Git-Repo\\FPT\\untitled\\src\\Assignment\\Day1\\Question12\\errors.txt";

        List<Student> students = readCSV(csvFile, errorFile);

        // show all student
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> readCSV(String csvFile, String errorFile) {
        List<Student> students = new ArrayList<>();
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile)); BufferedWriter errorWriter = new BufferedWriter(new FileWriter(errorFile))) {

            // doc file csv
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                // validate
                boolean isValid = true;

                // Kiểm tra định dạng của các trường dữ liệu
                if (data.length != 5) {
                    errorWriter.write("Invalid data length: " + line);
                    errorWriter.newLine();
                    isValid = false;
                }

                if (!isValidPhone(data[2])) {
                    errorWriter.write("Invalid phone number: " + line);
                    errorWriter.newLine();
                    isValid = false;
                }

                if (!isValidEmail(data[3])) {
                    errorWriter.write("Invalid email format: " + line);
                    errorWriter.newLine();
                    isValid = false;
                }

                if (isValid) {
                    try {
                        Student student = new Student(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]));
                        students.add(student);
                    } catch (NumberFormatException e) {
                        errorWriter.write("Invalid grade point: " + line);
                        errorWriter.newLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static boolean isValidPhone(String phone) {
        // Check sdt
        String phoneRegex = "\\d{10}"; // sdt yeu cau 10 so
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean isValidEmail(String email) {
        // Check email
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


}

