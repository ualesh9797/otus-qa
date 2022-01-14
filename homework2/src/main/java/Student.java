public class Student {

    private final String fio;
    private final String sex;
    private final int groupId;


    public Student(String fio, String sex, int groupId) {
        this.fio = fio;
        this.sex = sex;
        this.groupId = groupId;
    }

    public String getFio() {
        return fio;
    }

    public String getSex() {
        return sex;
    }

    public int getGroupId() {
        return groupId;
    }
}
