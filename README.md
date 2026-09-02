# University Course Registration System

A lightweight, object-oriented Java command-line interface (CLI) application designed to manage university course enrollments, department structures, and professor assignments.

## Features

* **Course Management:** Create and track academic courses with capacity and assignment parameters.
* **Student Enrollment:** Register students for active courses with enrollment validation.
* **Faculty & Department Management:** Assign professors to courses and organize modules by department.
* **User & Role System:** Modular object structure separating standard user profiles, students, and academic staff.

## File Structure

```text
Uni_Course_Registration_System/
└── Project/
    ├── Course.java       # Course properties, capacity, and enrollment logic
    ├── Department.java   # Department grouping and course associations
    ├── Professor.java    # Faculty member model and teaching assignments
    ├── Student.java      # Student profile and registered course tracking
    ├── User.java         # Base user class for system entities
    └── README.md
