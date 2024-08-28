package iuh.fit.ktpm;

/*
 * @description:  This class represent a rectangle
 * @author:  Tuấn, Nguyễn Phong Tuấn
 * @version: 1.0
 * @created: 8/28/2024
 */


public class CourseList {
    private Course[] courses;
    private int count  = 0;

    public CourseList(int n) {
        courses = new Course[n];
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    // Add course
    public boolean addCourse(Course course){
        if (courses== null) return false;

        if(isExists(course)) {
            return false;
        }
        // Check if the array is full
        if (count < courses.length) {
            courses[count++] = course;
            return true;
        }
        return false;
    }
    private boolean isExists(Course course){
        int len =  courses.length;
        for(int i = 0; i < len; i++) {
            Course temp = courses[i];
            if(temp != null && temp.getId().equals(course.getId())) {
                return true;
            }
        }
        return false;
    }
    // Find department with the most courses
    public String findDepartmentWithMostCourses(){
        if(courses == null) return null;
        String[] departments = new String[count];
        int[] counts = new int[count];
        int index = 0;
        for(int i = 0; i < count; i++) {
            Course course = courses[i];
            String department = course.getDepartment();
            int pos = findDepartment(departments, department, index);
            if(pos == -1) {
                departments[index] = department;
                counts[index] = 1;
                index++;
            } else {
                counts[pos]++;
            }
        }
        int max = counts[0];
        int pos = 0;
        for(int i = 1; i < index; i++) {
            if(counts[i] > max) {
                max = counts[i];
                pos = i;
            }
        }
        return departments[pos];
    }
    private int findDepartment(String[] departments, String department, int index) {
        for(int i = 0; i < index; i++) {
            if(departments[i].equals(department)) {
                return i;
            }
        }
        return -1;
    }
    // Find the course with the maximum credit
    public Course findMaxCreditCourse(){
        if(courses == null) return null;
        Course maxCreditCourse = courses[0];
        for(int i = 1; i < count; i++) {
            if(courses[i].getCredit() > maxCreditCourse.getCredit()) {
                maxCreditCourse = courses[i];
            }
        }
        return maxCreditCourse;
    }
    // Remove course
    public boolean RemoveCourse(String id){
        if(courses == null) return false;
        for(int i = 0; i < count; i++) {
            if(courses[i].getId().equals(id)) {
                courses[i] = courses[count - 1];
                count--;
                return true;
            }
        }
        return false;
    }
    // Search course by name
    public Course SearchCourse(String title){
        if(courses == null) return null;
        for(int i = 0; i < count; i++) {
            if(courses[i].getTitle().equals(title)) {
                return courses[i];
            }
        }
        return null;
    }

    // Search course by department
    public Course SearchCourseByDepartment(String department){
        if(courses == null) return null;
        for(int i = 0; i < count; i++) {
            if(courses[i].getDepartment().equals(department)) {
                return courses[i];
            }
        }
        return null;
    }
    // Search course by ID
    public Course SearchCourseByID(String id){
        if(courses == null) return null;
        for(int i = 0; i < count; i++) {
            if(courses[i].getId().equals(id)) {
                return courses[i];
            }
        }
        return null;
    }
    // Sort the courses
    public Course SortCourse(){
        if(courses == null) return null;
        for(int i = 0; i < count - 1; i++) {
            for(int j = i + 1; j < count; j++) {
                if(courses[i].getCredit() > courses[j].getCredit()) {
                    Course temp = courses[i];
                    courses[i] = courses[j];
                    courses[j] = temp;
                }
            }
        }
        return courses[0];
    }
}
