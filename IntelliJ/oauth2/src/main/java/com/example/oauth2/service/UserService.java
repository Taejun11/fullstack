package com.example.oauth2.service;

import com.example.oauth2.dto.*;
import com.example.oauth2.entity.Users;
import com.example.oauth2.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final SendService sendService;
    private final PasswordEncoder passwordEncoder;

//    spring security가 로그인 시 호출하는 메서드, 반드시 override 해야 함
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("회원을 찾을 수 없습니다 : " + username));
        return User.builder()
                .username(user.getUserId())
                .password(user.getUserPw())
                .roles(user.getRole().toString())
                .build();
    }

/*    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Member member = memberRepository.findByEmail(email);

        if(member == null){
            throw new UsernameNotFoundException(email);
        }
        //사용자 정보를 조회, 스프링 시큐리가 이해하는 형태로 변경
        return User.builder()
                .username(member.getEmail()) //로그인으로 사용할 필드
                .password(member.getPassword()) //DB에 암호화된 비밀번호
                .roles(member.getRole().toString()) //Role 접두사가 자동으로 등록
                .build();
    }*/

    @Transactional
    public void save(AddUserRequest dto){
        userRepository.save(Users.builder()
                .email(dto.getEmail())
                .userPw(passwordEncoder.encode(dto.getPassword()))
                .build());
    }

    @Transactional
    public void joinUser(UserDto userDto){
        Optional<Users> existingUser = userRepository.findById(userDto.getUserId());
        if (existingUser.isPresent()){
            throw new IllegalStateException("해당 아이디가 이미 존재합니다.");
        }

        Users user = Users.createMember(userDto, passwordEncoder);
        userRepository.save(user);
    }

    public boolean checkUserIdExists(String userId) {
        return userRepository.findById(userId).isPresent();
    }

    public Users getUserByEmailAndPhoneNumber(String email, String phone) {
        return userRepository.findByEmailAndPhone(email, phone).orElseThrow(EntityNotFoundException::new);
    }
//    비밀번호 찾기
    public void userCheck(UserPwRequestDto requestDto) {
        Users user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 회원을 찾을 수 없습니다."));

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("사용자의 이메일이 설정되지 않았습니다.");
        }
//        requestDto에 있는 아이디 조회 후
//        해당 회원의 이메일에 비밀번호 재설정 메일 전송
        requestDto.setUserEmail(user.getEmail());
        sendEmail(requestDto);
    }

    public void sendEmail(UserPwRequestDto requestDto) {
        if (requestDto.getUserEmail() == null || requestDto.getUserEmail().isEmpty()) {
            throw new IllegalArgumentException("Recipient email address cannot be null or empty.");
        }

        MailDto dto = sendService.createMailAndChargePassword(requestDto);
        sendService.mailSend(dto);
    }

    public UserEditDto getUserById(String userId) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserEditDto(user);
    }
    
//    수정한 정보를 저장
    @Transactional
    public boolean updateUser(UserEditDto userEditDto) {
        try {
            log.info("수정한값 : {} ", userEditDto);
            Users user = userRepository.findById(userEditDto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            if (userEditDto.getUserPw() != null && !userEditDto.getUserPw().isEmpty()) {
                user.setUserPw(passwordEncoder.encode(userEditDto.getUserPw()));
            }
            user.setPCode(userEditDto.getPCode());
            user.setLoadAddr(userEditDto.getLoadAddr());
            user.setLotAddr(userEditDto.getLotAddr());
            user.setDetailAddr(userEditDto.getDetailAddr());
            user.setExtraAddr(userEditDto.getExtraAddr());
            user.setPhone(userEditDto.getPhone());
            user.setEmail(userEditDto.getEmail());
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            log.error("Error updating user: ", e);
            return false;
        }
    }


    // 소셜 로그인 시도시 회원정보가 비어있는지 없는지 체크
    public boolean isProfileComplete(String userid) {
        Users user = userRepository.findById(userid)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 검사 항목들
        String pCode = user.getPCode();
        String loadAddr = user.getLoadAddr();
        String lotAddr = user.getLotAddr();
        String detailAddr = user.getDetailAddr();

        List<String> fieldCheckList = Arrays.asList(pCode, loadAddr, lotAddr, detailAddr);

        return fieldCheckList.stream().allMatch(this::isFieldValid);
    }
    // 각 필드 검사
    private boolean isFieldValid(String field) {
        return field != null && !field.isEmpty();
    }

    // 탈퇴
    public void deleteUserById(String userId) {
        Users users = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("찾는 유저가 없습니다"));

        userRepository.delete(users);
    }

}
//Users: 직접 만든 엔티티
//db저장용, 회원 정보 관리, db 조회 후 User로 변환

//User: security에서 제공
//인증용 spring security 로그인 처리 -> 인증 시스템 전달용
//principal.getName();으로 시큐리티 로그인한 사용자 불러오기 가능
/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
Object principal = auth.getPrincipal();

if (principal instanceof UserDetails userDetails) {
        System.out.println("일반 로그인 ID: " + userDetails.getUsername());
        System.out.println("getName: " + auth.getName()); // 동일함
        } else if (principal instanceof OAuth2User oauthUser) {
        System.out.println("소셜 로그인 ID: " + oauthUser.getAttribute("userId"));
        System.out.println("getName: " + oauthUser.getName()); // "userId" 필드의 값
        }*/
