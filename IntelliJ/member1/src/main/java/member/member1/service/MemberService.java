package member.member1.service;

import member.member1.dto.MemberDto;
import member.member1.entity.Member;
import member.member1.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public void create(MemberDto dto) {
        Member member = new Member(dto);
        memberRepository.save(member);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public void update(Long id, MemberDto dto) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        // member가 존재할 경우, null이 아닐 경우
        if (memberOptional.isPresent()){
            Member member = memberOptional.get();
            member.updateFromDto(dto);
            memberRepository.save(member);
        }
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }
}
