package iuh.fit.ktpm;

/*
 * @description:  This class represent a rectangle
 * @author:  Tuấn, Nguyễn Phong Tuấn
 * @version: 1.0
 * @created: 8/28/2024
 */


public class Course {
    private String id;
    private String title;
    private String department;
    private int credit;

    //Constructors
    public Course() {
        this("", "", "", 0);
    }
    public Course(String id, String title, String department, int credit) {
        this.id = id;
        this.title = title;
        this.department = department;
        this.credit = credit;
    }

    //Properties set/get
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id.length() < 3){
            throw new IllegalArgumentException("ID must be at least 3 characters");
        }
        if(!id.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("ID must contain only letters or digits");
        }
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.isEmpty()){
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        if(credit < 0){
            throw new IllegalArgumentException("Credit must be greater than or equal to 0");
        }
        this.credit = credit;
    }
    @Override
    public String toString() {
        return "Course:  " +
                "id ='" + id + '\'' +
                ", title ='" + title + '\'' +
                ", credit =" + credit +
                ", department ='" + department + '\'';
    }
}
