package loginBoard.board2.service;

import loginBoard.board2.dto.MemberDto;
import loginBoard.board2.entity.Member;
import loginBoard.board2.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member register(MemberDto dto) {
        Member member = new Member();
        member.setUsername(dto.getUsername());
        member.setPassword(dto.getPassword());
        return memberRepository.save(member);
    }

    public Member login(MemberDto dto) {
        return memberRepository.findByUsername(dto.getUsername())
                .filter(m -> m.getPassword().equals(dto.getPassword()))
                .orElse(null);
    }
}
