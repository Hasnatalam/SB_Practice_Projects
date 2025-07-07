📘 One-to-Many Mapping in JPA (with Table Structure)

---

## 🔹 What is One-to-Many Mapping?

One-to-Many means that **one record in one table is associated with many records in another table**.

🧠 Example:

- One `Student` can have many `Courses`.
- One `Department` can have many `Employees`.

---

## ✅ 1. Unidirectional One-to-Many Mapping

> Only one entity is aware of the relationship (typically the "one" side).
> 

### 🧾 Example: `Department` → `Employee`

### 🔸 Entity Classes

```java
@Entity
public class Department {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id") // foreign key in employee table
    private List<Employee> employees = new ArrayList<>();
}

```

```java
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String position;
}

```

### 🗃️ Table Structure

### `department` table:

| id | name |
| --- | --- |
| 1 | HR |

### `employee` table:

| id | name | position | department_id (FK) |
| --- | --- | --- | --- |
| 1 | Alice | Manager | 1 |
| 2 | Bob | Clerk | 1 |

### 💡 Key Points:

- `department_id` is a **foreign key** in the `employee` table.
- Only `Department` has the list of `Employee`.

---

## ✅ 2. Bidirectional One-to-Many Mapping

> Both entities are aware of the relationship.
> 

### 🧾 Example: `Department` ↔ `Employee`

### 🔸 Entity Classes

```java
@Entity
public class Department {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();
}

```

```java
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String position;

    @ManyToOne
    @JoinColumn(name = "department_id") // foreign key
    private Department department;
}

```

### 🗃️ Table Structure

### `department` table:

| id | name |
| --- | --- |
| 1 | HR |

### `employee` table:

| id | name | position | department_id (FK) |
| --- | --- | --- | --- |
| 1 | Alice | Manager | 1 |
| 2 | Bob | Clerk | 1 |

### 💡 Key Points:

- Foreign key (`department_id`) is in the `employee` table.
- `mappedBy = "department"` tells JPA that `Employee` owns the relationship.

---

## 🔁 Summary Table: Uni vs Bi

| Feature | Unidirectional | Bidirectional |
| --- | --- | --- |
| Navigation | One-way (`Department → Employees`) | Two-way (`Department ↔ Employee`) |
| `@JoinColumn` | On `@OneToMany` side | On `@ManyToOne` side |
| `mappedBy` | Not used | Used on `@OneToMany` side |
| Foreign Key Location | Child table (`employee`) | Child table (`employee`) |
| Use case | Simple read-only | Needed for full CRUD relationship |

---

## 📍 Real-World Examples

| Entity A | Entity B | Relationship |
| --- | --- | --- |
| Department | Employee | One-to-Many |
| Author | Book | One-to-Many |
| School | Student | One-to-Many |

---

Let me know if you want:

- ER diagram 📊
- Working Spring Boot + MySQL example 💻
- Reverse (Many-to-One) notes too 🔁