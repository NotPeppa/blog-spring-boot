package online.notpeppa.blog.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringBootConfiguration;

@SpringBootConfiguration
@OpenAPIDefinition(
        info = @Info(
                title = "博客接口文档",
                contact = @Contact(
                        name = "NotPeppa",
                        url = "https://github.com/NotPeppa"
                )
        ),
        servers = @Server(url = "http://127.0.0.1:8888/api/ui")
)
public class SwaggerOpenApiConfig {
}
