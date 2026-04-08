package com.app.ncs.controller;

import com.app.ncs.domain.vo.MemberVO;
import com.app.ncs.mapper.MemberMapper;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/members/*")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberMapper memberMapper;
    private final HttpSession session;

    @GetMapping("/join")
    public void goToJoin(MemberVO memberVO) {;}

    @PostMapping("/join")
    public RedirectView join(MemberVO memberVO) {
        memberMapper.insert(memberVO);
        return new RedirectView("/members/login");
    }

    @GetMapping("/login")
    public void goToLogin(MemberVO memberVO) {;}

    @PostMapping("/login")
    public RedirectView login(MemberVO memberVO, RedirectAttributes redirectAttributes) {
        Optional<MemberVO> member = memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
        //log.info("member : {}", member);
        if(member.isPresent()) {
            session.setAttribute("member", member.get());
            return new RedirectView("/members/my-page");
        }

        redirectAttributes.addFlashAttribute("isLogin", false);
        return new RedirectView("/members/login");
    }

    @GetMapping("/my-page")
    public void goToMyPage() {;}

    @GetMapping("update")
    public void goToUpdate(Model model){
        model.addAttribute("member", session.getAttribute("member"));
    }

    @PostMapping("update")
    public RedirectView update(MemberVO memberVO){
        memberMapper.update(memberVO);
        Optional<MemberVO> foundMember = memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
        if(foundMember.isPresent()){
            session.setAttribute("member", foundMember.get());
        }
        return new RedirectView("/members/my-page");
    };

    @PostMapping("logout")
    public RedirectView logout(){
        session.invalidate();
        return new RedirectView("/members/login");
    }

    @PostMapping("withdraw")
    public RedirectView withdraw(){
        MemberVO member = (MemberVO)session.getAttribute("member");
        memberMapper.delete(member.getId());
        session.invalidate();
        return new RedirectView("/members/join");
    }
}
