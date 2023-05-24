package topy.project.modules.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import topy.project.common.dto.ResultResponse;
import topy.project.modules.member.dto.MemberSignUpRequest;

import static topy.project.common.Const.SUCCESS;
import static topy.project.common.Const.SUCCESS_MSG;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @PostMapping("/member/sign-up")
    public ResultResponse signUp(@RequestBody @Valid MemberSignUpRequest memberSignUpRequest) {
        memberService.createMember(memberSignUpRequest);
        return ResultResponse.result(SUCCESS, SUCCESS_MSG);
    }
}
