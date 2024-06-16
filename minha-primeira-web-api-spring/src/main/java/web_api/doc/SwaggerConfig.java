package web_api.doc;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private Contact contato() {
		return new Contact(
				"Seu nome",
				"http://www.teste.com.br",
				"teste@teste.com.br"
				);
	}
	
	private ApiInfoBuilder informacoesApi() {
		
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		
		apiInfoBuilder.title("Title - Rest API");
		apiInfoBuilder.description("API exemplo de uso com SpringBoot REST API");
		apiInfoBuilder.version("3.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de Uso: Open Source");
		apiInfoBuilder.license("Licença - Teste");
		apiInfoBuilder.licenseUrl("http://www.teste.com.br");
		apiInfoBuilder.contact(this.contato());
		
		return apiInfoBuilder;
	}
}
