package com.springboot.service;

import com.springboot.domain.Member;
import com.springboot.domain.MemberFormDto;
import com.springboot.repository.MemberRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService implements UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Member saveMember(Member member){
        validationDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validationDuplicateMember(Member member) {
        Member findMember = memberRepository.findByMemberId(member.getMemberId());
        if (findMember != null){
            throw new IllegalArgumentException("이미 가입된 회원입니다.");
        }
    }

    public Member getMemberById(String memberId){
        Member member = memberRepository.findByMemberId(memberId);
        System.out.println("반환받은 memberId: " + member.getMemberId());
        return member;
    }

    public void deleteMember(String memberId){
        Member member = memberRepository.findByMemberId(memberId);
        memberRepository.deleteById(member.getNum());
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Member member = memberRepository.findByMemberId(id);
        System.out.println(member);
        if(member == null){
            throw new UsernameNotFoundException(id);
        }

        return User.builder()
                .username(member.getMemberId())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }
//업데이트 1
//    public Member updateMember(Member member){
//        return memberRepository.save(member);
//    }

//    업데이트 2
    public void updateMember(@Valid MemberFormDto dto) {
        Member member = memberRepository.findByMemberId(dto.getMemberId());

        if (member == null){
            throw new IllegalStateException("존재하지 않는 회원");
        }
        member.updateFromDto(dto, passwordEncoder);
//        memberRepository.save(member);
    }
}
