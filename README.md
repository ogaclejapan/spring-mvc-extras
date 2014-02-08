## Spring MVC Extras

This library can be processed by the method chain response model.

```java

/** e.g. Using by inheriting BaseController */
@Controller
public class SimplePageController extends WebPageController {

  @RequestMapping(value="/", method=RequestMethod.GET)
  public ModelAndView indexPage() {
    return ok("index").data("message", "hello world!!").data("name", "ogaclejapan");
  }
  
}

/** e.g. Using by static import Utils */
import static com.ogaclejapan.webmvc.util.WebPageUtils.*;

@Controller
public class SimplePageController {

  @RequestMapping(value="/", method=RequestMethod.GET)
  public ModelAndView indexPage() {
    return ok("index").data("message", "hello world!!").data("name", "ogaclejapan");
  }
  
}

```

## Using Maven

Add the following lines to pom.xml.

```xml
<repositories>
    <repository>
      <id>spring-mvc-extras-repo</id>
      <name>This library is an extension of the springmvc.</name>
      <url>http://ogaclejapan.github.com/spring-mvc-extras</url>
    </repository>
 </repositories>

<dependencies>
    <dependency>
        <groupId>com.ogaclejapan</groupId>
        <artifactId>spring-webmvc-extras</artifactId>
        <version>4.0.0.RELEASE</version><!-- The same version of the SpringMVC library -->
    </dependency>
</dependencies>
```

