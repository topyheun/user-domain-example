package topy.project.common;

public class Const {

    /**
     * 공통
     */
    public static final int SUCCESS = 0;
    public static final String SUCCESS_MSG = "성공";

    /**
     * 명명 규칙
     * Domain을 접두사로 사용
     */
    public static final String MEMBER_USED_ACCOUNT = "사용중인 계정입니다.";
    public static final String MEMBER_INVALID_EMAIL_FORMAT = "올바르지 않은 이메일 양식입니다.";
    public static final String MEMBER_NOT_FOUND_ACCOUNT = "계정을 찾을 수 없습니다.";

    public static final String MEMBER_DTO_NO_USERNAME = "아이디를 입력해주세요.";
    public static final String MEMBER_DTO_NO_PASSWORD = "비밀번호를 입력해주세요.";
    public static final String MEMBER_DTO_WRONG_PASSWORD_RULE = "숫자, 대문자, 소문자, 특수문자를 포함하여 8 ~ 20자리의 비밀번호를 입력해주세요.";
    public static final String MEMBER_DTO_NO_RECEIVER = "수신받을 이메일을 입력해주세요.";

    public static final String JWT_UNAUTHENTICATED_USER = "접근 권한이 없습니다.";
    public static final String JWT_WITHOUT_ACCESS = "인증되지 않은 사용자입니다.";
    public static final String JWT_INVALID_TOKEN = "유효하지 않은 토큰입니다.";
}
