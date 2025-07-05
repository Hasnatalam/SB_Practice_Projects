
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


