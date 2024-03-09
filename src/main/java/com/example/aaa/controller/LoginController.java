package com.example.aaa.controller;
import com.example.aaa.controller.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/login")


    public Result login(@RequestBody LoginRequest loginRequest) {
        // 在这里处理登录逻辑，您可以验证用户名和密码等
        if (isValidUser(loginRequest)) {
            // 登录成功，返回响应给Vue前端
//        return ResponseEntity.ok("Login successful");
//            return ResponseEntity.ok(new LoginResponse(200, "Login successful"));
           return new Result(200);
        } else {
            // 登录失败，返回错误响应给Vue前端
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
            //return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(401, "Login failed"));
            return new Result(404);
        }
    }

    // 示例验证方法，您需要根据实际需求实现
    private boolean isValidUser(LoginRequest loginRequest) {
        // 这里可以根据传递的登录请求验证用户的用户名和密码
        // 例如，可以查询数据库或使用其他身份验证方法
        // 在示例中，只简单判断用户名和密码是否为"admin"和"password"
        return "a".equals(loginRequest.getUsername()) && "z".equals(loginRequest.getPassword());

//        if ("1".equals(loginRequest.getUsername()) && "1".equals(loginRequest.getPassword())) {
//            return true;
//        } else {
//            return false;
//        }
    }

    // 登录请求的数据模型
    private static class LoginRequest {
        private String username;
        private String password;

        // getter和setter方法
        // ...

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
    private static class LoginResponse {
        private int code;
        private String message;

        public LoginResponse(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}

