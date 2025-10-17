package com.example.AuthService.service;

import com.example.AuthService.dto.request.CreateRequest;
import com.example.AuthService.dto.response.CreateResponse;
import com.example.AuthService.entity.User;
import com.example.AuthService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public CreateResponse register(CreateRequest createRequest) {
        // Kiểm tra xem người dùng đã tồn tại chưa
        if (userRepository.findByUsername(createRequest.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // Tạo người dùng mới với mật khẩu đã mã hóa
        User user = User.builder()
                .username(createRequest.getUsername())
                .password(passwordEncoder.encode(createRequest.getPassword()))
                .role("ROLE_USER") // Mặc định là ROLE_USER, có thể thay đổi theo yêu cầu
                .build();
        userRepository.save(user);

        return CreateResponse.builder()
                .username(user.getUsername())
                .build();
    }
}
