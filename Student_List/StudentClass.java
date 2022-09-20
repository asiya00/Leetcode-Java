import java.util.*;
import java.util.stream.*;
import student.StudentList;
import student.ScoreList;

public class StudentClass {
    public String getQuery(String studentData,String query){
      String[] q = query.split(",");
      String[] students = studentData.split(" ");
      String output = "";
      switch(q[0]){
        case "1":
          StudentList<ArrayList<String>> s1 = new StudentList<>(new ArrayList<String>(Arrays.asList(students)));
          output = s1.beginsWith(q[1]);
          break;
        case "2":
          StudentList<ArrayList<String>> s2 = new StudentList<>(new ArrayList<String>(Arrays.asList(students)));
          String[] bgs = q[1].split(" ");
          output = s2.bloodGroupOf(bgs, q[2]);
          break;
        case "3":
          Integer[] scores = Stream.of(students).map(Integer::valueOf).toArray(Integer[]::new);
          StudentList<ArrayList<Number>> s3 = new StudentList<>(new ArrayList<Number>(Arrays.asList(scores)));
          int ans = s3.thresholdScore(Integer.parseInt(q[1]));
          output = ans + " students scored "+q[1]+" above";
          break;
        case "4":
          scores = Stream.of(students).map(Integer::valueOf).toArray(Integer[]::new);
          ScoreList<ArrayList<Number>> s4 = new ScoreList<>(new ArrayList<Number>(Arrays.asList(scores)));
          output += s4.averageValues();
          break;
        case "5":
          Double[] score = Stream.of(students).map(Double::valueOf).toArray(Double[]::new);
          ScoreList<ArrayList<Number>> s5 = new ScoreList<>(new ArrayList<Number>(Arrays.asList(score)));
          output += s5.averageValues();
          break;
        default:
          output = "";

      }
      return output; 
    }

    public static void main(String[] args) {
      // String studentData = "Raja Ravi Vinay Rahul Arun";
      // String query = "1,r";
      // String studentData = "Raja Ravi Vinay Rahul Arun";
      // String query = "2,B- AB- B+ O+ B+,B+";
      // String studentData = "96 78 93 45 90 42 69";
      // String query = "3,90";
      // String studentData = "96 78 93 45 90 42 69";
      // String query = "4";
      String studentData = "90 78 69 45 90 42 69";
      String query = "4";
      StudentClass s = new StudentClass();
      String answer = s.getQuery(studentData, query);
      System.out.println(answer);
    }

}
