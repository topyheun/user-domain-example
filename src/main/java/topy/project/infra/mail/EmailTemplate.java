package topy.project.infra.mail;

import org.springframework.stereotype.Component;

@Component
public class EmailTemplate {

    public String verifyAuthCodeMailTemplate(String authKey) {
        String content = ""
                + "<html><body>"
                + "<h2>[Topy's Marketplace] - Guide to Sending Verification Codes</h2>"
                + "<p><span style='color:red;font-size:23px;font-weight:bold;'>" + authKey + "</span></p>"
                + "</body></html>";
        return content;
    }

    public String reissuePasswordMailTemplate(String authKey) {
        String content = ""
                + "<html><body>"
                + "<h2>[Topy's Marketplace] - Guide to Sending Temporary Password</h2>"
                + "<br>"
                + "<p><span style='color:red;font-size:23px;font-weight:bold;'>" + authKey + "</span></p>"
                + "</body></html>";
        return content;
    }
}
