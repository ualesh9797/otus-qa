import java.sql.*;

public class HomeWorkKarina {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "root");
        createCuratorTable(connection);
        insertCuratorTable(connection);
        createGroupTable(connection);
        insertGrouppTable(connection);
        createStudentTable(connection);
        insertStudentTable(connection);
        printStudents(connection);
        printStudentsCount(connection);
        printStudentWoman(connection);
        updateGroupp(connection);
        printGrouppCurator(connection);


    }

    private static void createCuratorTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE if not exists Curator (id int AUTO_INCREMENT PRIMARY KEY, fio varchar(50) )");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertCuratorTable(Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Curator(fio) VALUES(?), (?), (?), (?)")) {
            statement.setString(1, "Ivan Fedorov");
            statement.setString(2, "Sergey Popov");
            statement.setString(3, "Anna Fedorova");
            statement.setString(4, "Irina Smirnova");
            int insertedRowsNumber = statement.executeUpdate();
            System.out.println("Inserted rows number: " + insertedRowsNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void createGroupTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE if not exists Groupp (id int AUTO_INCREMENT PRIMARY KEY, name varchar(50), id_curator int, FOREIGN KEY(id_curator) REFERENCES Curator(id))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void insertGrouppTable(Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Groupp (name, id_curator) VALUES(?,?), (?,?), (?,?)")) {
            statement.setString(1, "A");
            statement.setInt(2, 1);
            statement.setString(3, "B");
            statement.setInt(4, 2);
            statement.setString(5, "C");
            statement.setInt(6, 3);
            int insertedRowsNumber = statement.executeUpdate();
            System.out.println("Inserted rows number: " + insertedRowsNumber);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void createStudentTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE if not exists Student (id int AUTO_INCREMENT PRIMARY KEY, fio varchar(50), sex varchar(50), id_group int, FOREIGN KEY(id_group) REFERENCES Groupp(id))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertStudentTable(Connection connection) {
        Student[] students = new Student[]{
                new Student("Jony Jim", "M", 1),
                new Student("Katy Parry", "W", 2),
                new Student("Orazbay Ualesh", "M", 3),
                new Student("Misha Marwin", "M", 1),
                new Student("Santa Claus", "M", 2),
                new Student("Nelly Fornication", "W", 3),
                new Student("Marina Petrova", "W", 1),
                new Student("Tom Hardi", "M", 2),
                new Student("Vanessa Paradi", "W", 3),
                new Student("Spider man", "W", 1),
                new Student("Sam Smith", "M", 2),
                new Student("Cat Woman", "W", 3),
                new Student("Karina Ualesh", "W", 1),
                new Student("Sasha Belyi", "M", 2),
                new Student("Vasya Popov", "M", 3),


        };


        for (int i = 0; i < students.length; i++) {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Student (fio, sex, id_group) VALUES(?,?,?)")) {
                statement.setString(1, students[i].getFio());
                statement.setString(2, students[i].getSex());
                statement.setInt(3, students[i].getGroupId());
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }
    }

    private static void printStudents(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT s.id, s.fio, s.sex, g.name, c.fio FROM student s INNER JOIN groupp g on s.id_group=g.id INNER JOIN curator c on g.id_curator=c.id ")) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fio = resultSet.getString(2);
                String sex = resultSet.getString(3);
                String groupName = resultSet.getNString(4);
                String curatorFio = resultSet.getString(5);

                String row = String.format("ID: %d, SEX: %s, FIO: %s, GROUPNAME: %s, CURATORFIO: %s", id, sex, fio, groupName, curatorFio);
                System.out.println(row);
            }
        }


    }

    private static void printStudentsCount(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(id) FROM student");
            resultSet.next();
            System.out.printf("Students count: %d", resultSet.getInt(1));
        }
    }

    private static void printStudentWoman(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student WHERE sex='W'");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fio = resultSet.getString(2);
                String sex = resultSet.getString(3);
                String stroke = String.format("ID: %d, SEX: %s, FIO: %s", id, sex, fio);
                System.out.println(stroke);
            }
        }
    }

    private static void updateGroupp(Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(" UPDATE groupp SET id_curator=2 WHERE id=3 ")) {
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void printGrouppCurator(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM groupp INNER JOIN curator ON groupp.id_curator = curator.id")) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String groupName = resultSet.getString(2);
                int curator_id = resultSet.getInt(3);
                String curatorFio = resultSet.getString(4);

                String karinathebest = String.format("ID: %d, GROUPNAME: %s, CURATOR_ID: %d, CURATORFIO: %s", id, groupName, curator_id, curatorFio);
                System.out.println(karinathebest);
            }
        }

    }
}

