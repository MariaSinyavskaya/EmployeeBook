package pro.sky.employee.skyproemployeebook.constants;

import com.google.common.collect.Maps;
import pro.sky.employee.skyproemployeebook.model.Employee;

import java.util.Map;

public class TestConstant {
    public final static Employee EMPLOYEE_IVAN = new Employee(
            "Иван", "Иванов", 5, 55000);
    public final static Employee EMPLOYEE_MARIA = new Employee(
            "Мария", "Синявская", 4, 40789);
    public final static Employee EMPLOYEE_PETER = new Employee(
            "Петр", "Петров", 3, 44000);
    public final static Employee EMPLOYEE_ALEX = new Employee(
            "Александр", "Сергеев", 4, 70888);
    public final static int DEPARTMENT = 3;
    public final static int SALARY = 35000;
    public final static Map<String, Employee> EMPLOYEES = Maps.newHashMap(Map.of(
            "ЕкатеринаСарафанова",
            new Employee("Екатерина", "Сарафанова", 1, 68550),
            "НикитаБратченко",
            new Employee("Никита", "Братченко", 5, 25327),
            "ДарьяВасильева",
            new Employee("Дарья", "Васильева", 3, 33088),
            "ДарьяЮдина",
            new Employee("Дарья", "Юдина", 2, 55457),
            "МарияСинявская",
            new Employee("Мария", "Синявская", 4, 40789),
            "ВикторияОрлова",
            new Employee("Виктория", "Орлова", 1, 37440),
            "МарияЛарионова",
            new Employee("Мария", "Ларионова", 3, 27890),
            "СофьяСиротина",
            new Employee("Софья", "Сиротина", 2, 42220),
            "НикитаТихонов",
            new Employee("Никита", "Тихонов", 5, 38990),
            "АлександрСергеев",
            new Employee("Александр", "Сергеев", 4, 70888)
    ));

    private TestConstant() {
    }
}
