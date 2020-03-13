package com.employee;

public class Employee {
    private int id;
    private String name;
    private float salary;

    public Employee(){

    }

    public Employee(int id, String name, float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}

    /*CREATE TABLE `item` (
        `id` INT(11) NOT NULL,
        `name` VARCHAR(50) NULL DEFAULT NULL,
        `category` VARCHAR(50) NULL DEFAULT NULL,
        PRIMARY KEY (`id`)
        );*/

    /*INSERT INTO `item` (`id`, `name`, `category`) VALUES (1, 'IPhone 6S', 'Mobile');
INSERT INTO `item` (`id`, `name`, `category`) VALUES (2, 'Samsung Galaxy', 'Mobile');
INSERT INTO `item` (`id`, `name`, `category`) VALUES (3, 'Lenovo', 'Laptop');
INSERT INTO `item` (`id`, `name`, `category`) VALUES (4, 'LG', 'Telivision');*/
