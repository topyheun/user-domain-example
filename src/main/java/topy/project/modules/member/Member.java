package topy.project.modules.member;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import topy.project.common.BaseTimeEntity;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_username")
    private String username;

    @Column(name = "member_password")
    private String password;

    @Column(name = "member_contact")
    private String contact;

    @Column(name = "delete_at")
    private LocalDateTime disableAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_type")
    private MemberType memberType;

    @Builder
    public Member(String username, String password, String contact) {
        this.username = username;
        this.password = password;
        this.contact = contact;
    }

    public void setEncodePassword(String hashPassword) {
        this.password = hashPassword;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateDisableAt() {
        this.disableAt = LocalDateTime.now();
    }

    public boolean isWithdrawalAccount() {
        return this.disableAt != null;
    }
}
