package member.member1.controller;

import member.member1.dto.MemberDto;
import member.member1.entity.Member;
import member.member1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/members") //매핑할 때 앞에 자동으로 /members 붙은 것으로 인식
public class MemberController {
    @Autowired
    private MemberService memberService;

    //회원가입 폼 보여주기
    @GetMapping("/new")
    public String createForm(Model model){
        // 빈 MemberDto 먼저 생성
        model.addAttribute("memberDto", new MemberDto());
        return "members/create";
    }

    @PostMapping("/new")
    public String createF(@ModelAttribute MemberDto dto){
        memberService.create(dto);
        return "redirect:/members";
    }

    //회원목록 보여주기
    @GetMapping
    public String list(Model model){
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "members/list";
    }

    //회원 정보 수정화면 불러오기
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model){
        Member member = memberService.findById(id);
        if (member == null) {
            return "redirect:/members";
        }
        MemberDto dto = new MemberDto(member.getId(), member.getUsername(), member.getEmail(), member.getPassword());
        model.addAttribute("memberDto", dto);
        return "members/edit";
    }

    //회원 정보 수정하기
    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id, @ModelAttribute MemberDto dto){
        memberService.update(id, dto);
        return "redirect:/members";
    }

    //회원 정보 삭제하기
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        memberService.delete(id);
        return "redirect:/members";
    }
}
