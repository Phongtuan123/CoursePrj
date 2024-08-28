package iuh.fit.ktpm;

/*
 * @description:  This class represent a rectangle
 * @author:  Tuấn, Nguyễn Phong Tuấn
 * @version: 1.0
 * @created: 8/28/2024
 */


public class TestCode {
    public static void main(String[] args) {
        Course course1 = new Course("CSC101", "Computer Science", "Computer Science", 3);
        Course course2 = new Course("CSC102", "Data Structures", "Computer Science", 3);
        Course course3 = new Course("MAT101", "Calculus I", "Mathematics", 2);


        CourseList courseList = new CourseList(10);
        courseList.addCourse(course1);
        courseList.addCourse(course2);
        courseList.addCourse(course3);

        System.out.println("Department with the most courses: " + courseList.findDepartmentWithMostCourses());
        System.out.println("Find max credit: " + courseList.findMaxCreditCourse());
        System.out.println("Remove course: " + courseList.RemoveCourse("CSC101"));
        System.out.println("Search course: " + courseList.SearchCourse("Calculus I"));
        System.out.println("Search course by department: " + courseList.SearchCourseByDepartment("Computer Science"));
        System.out.println("Search course by id: " + courseList.SearchCourseByID("CSC102"));
        System.out.println("Sort course: " + courseList.SortCourse());

    }
}
