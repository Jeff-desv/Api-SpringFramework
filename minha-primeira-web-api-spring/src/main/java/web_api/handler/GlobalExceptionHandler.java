package web_api.handler;

import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
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
		responseError.setStatus("error");
		responseError.setError(message);
		responseError.setStatusCode(statusCode.value());
		return responseError;
	}
	
	@ExceptionHandler(Exception.class)
	private ResponseEntity<Object> handlerGeneral(Exception e, WebRequest request){
		if(e.getClass().isAssignableFrom(UndeclaredThrowableException.class)) {
			UndeclaredThrowableException exception = (UndeclaredThrowableException) e;
			return handleBusinessException((BusinessException) exception.getUndeclaredThrowable(), request);
		} else {
			String message = messageSource.getMessage("error.server", new Object[] {e.getMessage()}, null);
			ResponseError error = responseError(message, HttpStatus.INTERNAL_SERVER_ERROR);
			return handleExceptionInternal(e, error, headers(), HttpStatus.INTERNAL_SERVER_ERROR, request);
		}
	}

	private ResponseEntity<Object> handleExceptionInternal(Exception e, ResponseError error, HttpHeaders headers,
			HttpStatus internalServerError, WebRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	private ResponseEntity<Object> handleBusinessException(BusinessException undeclaredThrowable, WebRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}
