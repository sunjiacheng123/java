public class Student {
    private String name;
    private String agr;
    private int id;

    public Student(String name,int id) {
        this.name=name;
        this.id=id;
    }

    public Student(String name,String age) {
        this.name=name;
        this.agr=age;
    }

    private Student(String name) {
        this.name=name;
    }

    @Override
    public String toString() {
        return "student"+" "+name+" "+agr+" "+id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgr() {
        return agr;
    }

    public void setAgr(String agr) {
        this.agr = agr;
    }

    private int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
