package com.lwcd.rating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler {

   public ResponseEntity<Map<String, Object>> notFoundHandler(ResourceNotFoundException ex){
       Map map= new HashMap();
       map.put("message", ex.getMessage());


       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
   }
}
