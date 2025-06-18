import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8),
            new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2),
            new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3),
            new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80),
            new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70),
            new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70),
            new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70),
            new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80),
            new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85),
            new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82),
            new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83),
            new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4),
            new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6),
            new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8),
            new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4),
            new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4),
            new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5)
        );

        // 1. Print the name of all departments in the college
        System.out.println("\n1. Departments:");
        students.stream()
                .map(Student::getEngDepartment)
                .distinct()
                .forEach(System.out::println);

        // 2. Get the names of all students who have enrolled after 2018
        System.out.println("\n2. Students enrolled after 2018:");
        students.stream()
                .filter(s -> s.getYearOfEnrollment() > 2018)
                .map(Student::getName)
                .forEach(System.out::println);

        // 3. Get the details of all male students in the computer sci department
        System.out.println("\n3. Male students in Computer Science:");
        students.stream()
                .filter(s -> s.getGender().equalsIgnoreCase("Male") && s.getEngDepartment().equalsIgnoreCase("Computer Science"))
                .forEach(System.out::println);

        // 4. How many male and female students are there?
        System.out.println("\n4. Count by gender:");
        Map<String, Long> genderCount = students.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        genderCount.forEach((gender, count) -> System.out.println(gender + ": " + count));

        // 5. What is the average age of male and female students?
        System.out.println("\n5. Average age by gender:");
        Map<String, Double> avgAgeByGender = students.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        avgAgeByGender.forEach((gender, avgAge) -> System.out.println(gender + ": " + avgAge));

        // 6. Get the details of student having highest percentage
        System.out.println("\n6. Student with highest percentage:");
        students.stream()
                .max(Comparator.comparingDouble(Student::getPerTillDate))
                .ifPresent(System.out::println);

        // 7. Count the number of students in each department
        System.out.println("\n7. Student count by department:");
        Map<String, Long> countByDept = students.stream()
                .collect(Collectors.groupingBy(Student::getEngDepartment, Collectors.counting()));
        countByDept.forEach((dept, count) -> System.out.println(dept + ": " + count));

        // 8. What is the average percentage achieved in each department?
        System.out.println("\n8. Average percentage by department:");
        Map<String, Double> avgPercentByDept = students.stream()
                .collect(Collectors.groupingBy(Student::getEngDepartment, Collectors.averagingDouble(Student::getPerTillDate)));
        avgPercentByDept.forEach((dept, avg) -> System.out.println(dept + ": " + avg));

        // 9. Get the details of youngest male student in the Electronic department
        System.out.println("\n9. Youngest male student in Electronic department:");
        students.stream()
                .filter(s -> s.getGender().equalsIgnoreCase("Male") && s.getEngDepartment().equalsIgnoreCase("Electronic"))
                .min(Comparator.comparingInt(Student::getAge))
                .ifPresent(System.out::println);

        // 10. How many male and female students are there in the computer science department?
        System.out.println("\n10. Gender count in Computer Science department:");
        Map<String, Long> genderCountCS = students.stream()
                .filter(s -> s.getEngDepartment().equalsIgnoreCase("Computer Science"))
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        genderCountCS.forEach((gender, count) -> System.out.println(gender + ": " + count));
    }
}