package net.javaguides.springboot.controller;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public ResponseEntity<Map<String, Object>> handleError(WebRequest webRequest) {
        // Get error attributes
        Map<String, Object> errors = errorAttributes.getErrorAttributes(webRequest,
                ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE, ErrorAttributeOptions.Include.BINDING_ERRORS));

        // Extract status code if present
        Integer status = (Integer) errors.get("status");
        HttpStatus httpStatus = (status != null) ? HttpStatus.valueOf(status) : HttpStatus.INTERNAL_SERVER_ERROR;

        return new ResponseEntity<>(errors, httpStatus);
    }

}
