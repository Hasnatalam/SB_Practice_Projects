To create a spring MVC project process need to follow

---

**1. Create Spring Boot MVC Project**

* **File → New → Spring Starter Project**
* Fill details:

  * **Name**: Your project name
  * **Type**: Maven
  * **Packaging**: Jar
  * **Java Version**: (choose your version)
* Click **Next**.

---

**2. Add Dependencies**

* Select:

  * **Spring Web** (for MVC)
  * **Thymeleaf** (for views, optional)
  * **Spring Boot DevTools** (optional for auto-reload)
* Finish.

---

**3. Project Structure Auto-Created**

* `src/main/java` → Application, Controller, Model, Service classes.
* `src/main/resources/templates` → HTML views.
* `src/main/resources/static` → CSS, JS, images.

---

**4. Create Controller**

```java
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("msg", "Hello from Spring Boot MVC");
        return "index";
    }
}
```

---

**5. Create View** (`templates/index.html`)

```html
<!DOCTYPE html>
<html>
<body>
<h1 th:text="${msg}"></h1>
</body>
</html>
```

---

**6. Run Project**

* **Right-click Project → Run As → Spring Boot App**
* Visit `http://localhost:8080/`
