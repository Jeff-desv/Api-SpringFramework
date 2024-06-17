package web_api.handler;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.annotation.Resource;





@RestControllerAdvice
public class GlobalExceptionHandler {

	@Resource
	private MessageSource messageSource;
	private HttpHeaders headers() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
	
	private ResponseError responseError(String message, HttpStatus statusCode) {
		ResponseError responseError = new ResponseError();
		return responseError;
	}
}
