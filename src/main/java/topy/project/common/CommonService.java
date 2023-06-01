package topy.project.common;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import topy.project.common.exception.BadRequestException;
import topy.project.modules.member.Member;
import topy.project.modules.member.MemberRepository;

import static topy.project.common.Const.MEMBER_NOT_FOUND_ACCOUNT;
import static topy.project.common.Const.MEMBER_WITHDRAWAL_ACCOUNT;

@Service
@RequiredArgsConstructor
public class CommonService {

    private final MemberRepository memberRepository;

    public void checkWithdrawalAccount(String username) {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(MEMBER_NOT_FOUND_ACCOUNT));

        if (member.isWithdrawalAccount()) {
            throw new BadRequestException(MEMBER_WITHDRAWAL_ACCOUNT);
        }
    }
}
