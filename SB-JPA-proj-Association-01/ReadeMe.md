# ModelMapper

## What is ModelMapper?

**ModelMapper** is a Java library used to **automatically map one object to another**, usually from:

* DTO ➡️ Entity
* Entity ➡️ DTO

It reduces the need for manual getter-setter copying.

---

## ✅ Maven Dependency

```xml
<dependency>
    <groupId>org.modelmapper</groupId>
    <artifactId>modelmapper</artifactId>
    <version>3.1.1</version>
</dependency>
```

---

## ✅ Spring Configuration

```java
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
```

---

## ✅ Example Usage

### 🔸 DTO class

```java
public class StudentDto {
    private Long id;
    private String name;
}
```

### 🔸 Entity class

```java
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
```

### 🔸 Mapping Example

```java
@Autowired
private ModelMapper modelMapper;

public StudentDto convertToDto(Student student) {
    return modelMapper.map(student, StudentDto.class);
}

public Student convertToEntity(StudentDto dto) {
    return modelMapper.map(dto, Student.class);
}
```

---

## 🎯 Benefits

* No need to manually set fields.
* Clean and reusable mapping logic.
* Supports nested mapping.




advance concept of ModelMpper

Mapping with nested objects

Custom field mapping

List mapping example

---

# @Builder

---

## 📘 What is the Builder Pattern?

The **Builder Pattern** is a **creational design pattern** used to **create complex objects step by step**, especially when the constructor has **many parameters**.

---


## ✅ Why use Builder?

* Makes code **readable and maintainable**
* Avoids **constructor telescoping** (many overloaded constructors)
* Helps in creating **immutable objects**

---

## ✅ Example

### 🔸 Without Builder (Hard to read)

```java
Student s = new Student(1L, "John", "Java", 25);
```

### 🔸 With Builder

```java
Student student = Student.builder()
    .id(1L)
    .name("John")
    .course("Java")
    .age(25)
    .build();
```

### 🔸 Entity Class with Builder

```java
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long id;
    private String name;
    private String course;
    private int age;
}
```

> 🛠️ `@Builder` is from **Lombok**, which auto-generates the builder methods.

---

## 📦 Maven for Lombok (if using builder)

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.28</version>
    <scope>provided</scope>
</dependency>
```

---

## ✅ Benefits

* Improves **clarity** when setting multiple fields
* Supports **optional fields**
* Helps in creating **immutable objects** in a clean way




# Swageer



---

## 📘 Swagger with `@Configuration` Class (SpringDoc OpenAPI)

**Swagger (OpenAPI)** is used to **generate interactive API documentation** for REST APIs.
Instead of annotations or YAML, you can configure it **programmatically** using a Java class.

---

## ✅ Setup

### 🔹 Maven Dependency

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.3.0</version>
</dependency>
```

---

### 🔹 Swagger Configuration Class

```java
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Student API")
                .version("1.0")
                .description("API documentation for managing students")
                .contact(new Contact()
                    .name("Hasnat Alam")
                    .email("hasnat@example.com"))
                .license(new License()
                    .name("Apache 2.0")
                    .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}
```

---

## ✅ Access Swagger UI

Once the app runs, open:

```
http://localhost:8080/swagger-ui.html
```

or

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🎯 Benefits of Java Config

* Full control in code
* Add dynamic values if needed
* No need for YAML or annotations

---

Advance concepts of swagger

* JWT support
* API grouping by tags
* Hiding specific endpoints



# 📘 One-to-One Mapping in JPA (with Table Structure)

---

## 🔹 What is One-to-One Mapping?

One-to-One mapping means **one record in one table is associated with one record in another table**.

🧠 Example:

- One `Student` has one `Address`.
- One `Person` has one `Passport`.

---

## ✅ 1. Unidirectional One-to-One Mapping

> Only one entity is aware of the relationship.
> 

### 🧾 Example: `Student` → `Address`

### 🔸 Entity Classes

```java
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id") // Foreign key
    private Address address;
}

```

```java
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String state;
}

```

### 🗃️ Table Structure

### `student` table:

| id | name | address_id (FK) |
| --- | --- | --- |
| 1 | Ram | 101 |

### `address` table:

| id | city | state |
| --- | --- | --- |
| 101 | Delhi | DL |

### 💡 Key Points:

- `address_id` is a **foreign key** in the `student` table.
- `Address` doesn't know about `Student`.

---

## ✅ 2. Bidirectional One-to-One Mapping

> Both entities are aware of the relationship.
> 

### 🧾 Example: `Student` ↔ `Address`

### 🔸 Entity Classes

```java
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
}

```

```java
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String state;

    @OneToOne(mappedBy = "address") // refers to 'address' field in Student
    private Student student;
}

```

### 🗃️ Table Structure

### `student` table:

| id | name | address_id (FK) |
| --- | --- | --- |
| 1 | Ram | 101 |

### `address` table:

| id | city | state | student (no FK column) |
| --- | --- | --- | --- |
| 101 | Delhi | DL | - |

### 💡 Key Points:

- `student` table has foreign key `address_id`.
- `mappedBy = "address"` tells JPA this is the **inverse side**.
- `Address` table does **not** have a new column.

---

## 🔁 Summary Table: Uni vs Bi

| Feature | Unidirectional | Bidirectional |
| --- | --- | --- |
| Navigation | One-way (`Student → Address`) | Two-way (`Student ↔ Address`) |
| `@JoinColumn` | Present | Present in the owning side (`Student`) |
| `mappedBy` | Not used | Used on inverse side (`Address`) |
| Foreign Key | Exists in owning side | Exists only in owning side |
| Simplicity | Simple | Slightly complex |

---

## 📍 Real-World Examples

| Entity A | Entity B | Relationship |
| --- | --- | --- |
| Person | Passport | One-to-One |
| Student | Address | One-to-One |
| User | Profile | One-to-One |

---
