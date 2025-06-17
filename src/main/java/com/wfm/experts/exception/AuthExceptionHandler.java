/*
 *
 *  * © 2024-2025 WFM EXPERTS INDIA PVT LTD. All rights reserved.
 *  *
 *  * This software, including all associated files, documentation, and related materials,
 *  * is the proprietary property of WFM EXPERTS INDIA PVT LTD. Unauthorized copying,
 *  * distribution, modification, or any form of use beyond the granted permissions
 *  * without prior written consent is strictly prohibited.
 *  *
 *  * DISCLAIMER:
 *  * This software is provided "as is," without warranty of any kind, express or implied,
 *  * including but not limited to the warranties of merchantability, fitness for a particular
 *  * purpose, and non-infringement.
 *  *
 *  * For inquiries, contact legal@wfmexperts.com.
 *
 */

package com.wfm.experts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * ✅ Global exception handler for authentication-related errors.
 */
@RestControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidEmailException(InvalidEmailException ex) {
        Map<String, Object> response = new HashMap<>();
//        response.put("error", "Unauthorized");
        response.put("message", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidPasswordException(InvalidPasswordException ex) {
        Map<String, Object> response = new HashMap<>();
//        response.put("error", "Unauthorized");
        response.put("message", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}
