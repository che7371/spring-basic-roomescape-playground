package roomescape.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class AdminInterceptor implements HandlerInterceptor {

    private final MemberService memberService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = memberService.extractTokenFromCookie(request.getCookies());
        System.out.println("token = " + token);
        Member member = memberService.extractMemberFromToken(token);
        System.out.println("member = " + member);
        System.out.println("member.getRole() = " + member.getRole());
        System.out.println("member.getName() = " + member.getName());

        if (member == null || !member.getRole().equals("ADMIN")) {
            response.setStatus(401);
            return false;
        }
        return true;
    }
}