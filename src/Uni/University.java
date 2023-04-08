package Uni;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {

   private Map<String, List<String>> faculties = new HashMap<>();
   private Map<String, List<String>> departments = new HashMap<>();
   private Map<String, List<String>> courses = new HashMap<>();
   private Map<String, List<String>> students = new HashMap<>();

   public void addFaculty(String name) {
      faculties.put(name, new ArrayList<>());
      System.out.println("Added faculty: " + name);
   }

   public List<String> listFaculties() {
      List<String> facultyList = new ArrayList<>(faculties.keySet());
      System.out.println("List of faculties: " + facultyList);
      return facultyList;
   }

   public void addDepartment(String facultyName, String departmentName) {
      List<String> departmentList = departments.getOrDefault(facultyName, new ArrayList<>());
      departmentList.add(departmentName);
      departments.put(facultyName, departmentList);
      System.out.println("Added department: " + departmentName + " to faculty: " + facultyName);
   }

   public void deleteDepartment(String facultyName, String departmentName) {
      List<String> departmentList = departments.get(facultyName);
      if (departmentList != null) {
         departmentList.remove(departmentName);
         System.out.println("Deleted department: " + departmentName + " from faculty: " + facultyName);
      }
   }

   public List<String> listDepartments(String facultyName) {
      List<String> departmentList = departments.getOrDefault(facultyName, new ArrayList<>());
      System.out.println("List of departments in faculty: " + facultyName + " : " + departmentList);
      return departmentList;
   }

   public void addCourse(String departmentName, String courseName) {
      List<String> courseList = courses.getOrDefault(departmentName, new ArrayList<>());
      courseList.add(courseName);
      courses.put(departmentName, courseList);
      System.out.println("Added course: " + courseName + " to department: " + departmentName);
   }

   public void updateCourse(String departmentName, String oldCourseName, String newCourseName) {
      List<String> courseList = courses.get(departmentName);
      if (courseList != null) {
         int index = courseList.indexOf(oldCourseName);
         if (index != -1) {
            courseList.set(index, newCourseName);
            System.out.println("Updated course: " + oldCourseName + " to: " + newCourseName);
         }
      }
   }

   public void deleteCourse(String departmentName, String courseName) {
      List<String> courseList = courses.get(departmentName);
      if (courseList != null) {
         courseList.remove(courseName);
         System.out.println("Deleted course: " + courseName + " from department: " + departmentName);
      }
   }

   public List<String> listCourses(String departmentName) {
      List<String> courseList = courses.getOrDefault(departmentName, new ArrayList<>());
      System.out.println("List of courses in department: " + departmentName + " : " + courseList);
      return courseList;
   }

   public void addStudent(String courseName, String studentName) {
      List<String> studentList = students.getOrDefault(courseName, new ArrayList<>());
      studentList.add(studentName);
      students.put(courseName, studentList);
      System.out.println("Added student: " + studentName + " to course: " + courseName);
   }

   public void updateStudent(String courseName, String oldStudentName, String newStudentName) {
      List<String> studentList = students.get(courseName);
      if (studentList != null) {
         int index = studentList.indexOf(oldStudentName);
         if (index != -1) {
            studentList.set(index, newStudentName);
            System.out.println("Updated student: " + oldStudentName + " to: " + newStudentName);
         }
      }
   }

   public void deleteStudent(String courseName, String studentName) {
      List<String> studentList = students.get(courseName);
      if (studentList != null) {
         studentList.remove(studentName);
         System.out.println("Deleted student: " + studentName + " from course: " + courseName);
      }
   }

   public List<String> listStudents(String courseName) {
      List<String> studentList = students.getOrDefault(courseName, new ArrayList<>());
      System.out.println("List of students in course: " + courseName + " : " + studentList);
      return studentList;
   }

   public int getTotalEnrollment(String courseName) {
      List<String> studentList = students.getOrDefault(courseName, new ArrayList<>());
      int enrollment = studentList.size();
      System.out.println("Total enrollment in course: " + courseName + " : " + enrollment);
      return enrollment;
   }
}