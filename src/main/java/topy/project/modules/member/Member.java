package topy.project.modules.member;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_username")
    private String username;

    @Column(name = "member_password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_type")
    private MemberType memberType;
}
