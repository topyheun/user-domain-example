package topy.project.infra.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import topy.project.common.exception.BadRequestException;
import topy.project.modules.member.Member;
import topy.project.modules.member.MemberRepository;

import static topy.project.common.Const.MEMBER_NOT_FOUND_ACCOUNT;

@Service
@RequiredArgsConstructor
public class SecurityUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(MEMBER_NOT_FOUND_ACCOUNT));

        return new SecurityUserDetails(member);
    }
}
