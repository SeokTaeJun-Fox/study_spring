package com.app.controller.controller;

import com.app.controller.domain.vo.MemberVO;
import com.app.controller.mapper.MemberMapper;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/members/*")
@RequiredArgsConstructor    //생성자의 매개변수로 주입받겠다.
@Slf4j
public class MemberController {

//   의존성 주입 : 생성자 주입

    private final MemberMapper memberMapper;
    private final HttpSession session;

//    회원 가입
    @GetMapping("/join")
    public void goToJoin(MemberVO memberVO) {;}  //생략 가능

//    값을 받아서 -> DB에 저장 -> 응답
    @PostMapping("/join")
    public RedirectView join(MemberVO memberVO) {
        memberMapper.insert(memberVO);
        return new RedirectView("/members/login");
    }

    @GetMapping("login")
    public void goToLogin(MemberVO memberVO) {;}

//  로그인 실습
//  로그인이 완료되면 /member/my-page로 응답
    @PostMapping("/login")
    public RedirectView loginOk(MemberVO memberVO, RedirectAttributes redirectAttributes) {
        Optional<MemberVO> member = memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
        if(member.isPresent()) {
            session.setAttribute("member", member.get());
            return new RedirectView("/members/my-page");
        }

//        리다이렉트와 세션(session)을 통해 화면에 상태를 관리하면
//        session 과부화 되므로 session에 flash 영역에 주입이 되며 새로운 요청이 들어왔을 때
//        flash 영역은 사라지게 된다. 즉 new Request() 객체를 만나면 사라진다.
//        redirectAttributes.addFlashAttribute("key, value): 컨트롤러에서 사용이 가능
//        redirectAttributes.addAttribute("isLogin", true): 컨트롤러에서 사용이 불가능
        redirectAttributes.addFlashAttribute("isLogin", false);
        return new RedirectView("/members/login");
    }

    @GetMapping("my-page")
    public void goToMyPage(){;}

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

    //    로그아웃
    public RedirectView logout(){
//      invalidate: 세션 값을 초기화
        session.invalidate();
//        session.removeAttribute("member");
        return new RedirectView("/members/login");
    }

    //    회원 탈퇴
    @DeleteMapping("withdraw")
    public RedirectView withdraw(){
        MemberVO member = (MemberVO)session.getAttribute("member");
        memberMapper.delete(member.getId());
        return new RedirectView("/members/login");
    }

//    @PostMapping("updateOk")
//    public RedirectView updateOk(MemberVO memberVO) {
//        MemberVO target = (MemberVO)session.getAttribute("member");
//        target.setMemberName(memberVO.getMemberName());
//        target.setMemberEmail(memberVO.getMemberEmail());
//        target.setMemberPassword(memberVO.getMemberPassword());
//        log.info("memberVO: {}", target);
//        memberMapper.update(target);
//        return new RedirectView("/members/my-page");
//    }

//    @PostMapping("delete")
//    public RedirectView withdraw(MemberVO memberVO) {
//        MemberVO member = (MemberVO)session.getAttribute("member");
//        memberMapper.delete(member.getId());
//        session.removeAttribute("member");
//        return new RedirectView("/members/login");
//    }
}
