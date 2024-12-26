package com.kosea.project.util;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Utils {
    public static boolean sendMail(String recipientEmail, String userId) {
        // SMTP 서버 설정 (Gmail 사용 예)
        String host = "smtp.gmail.com";
        String from = "koseaproject@gmail.com";  // 보내는 사람 이메일
        String password = "pucr bwuz klje oxuy";  // Gmail 계정의 비밀번호 또는 앱 비밀번호

        // 이메일 전송을 위한 설정
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");  // TLS 보안 연결 사용

        // 세션 생성
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);  // 보내는 사람 인증
            }
        });

        try {
        	
        	String token = UUID.randomUUID().toString();
        	
            // 이메일 제목과 내용 정의
            String subject = "비밀번호 찾기 안내";
            String body = "안녕하세요, " + userId + "님!\n\n"
                        + "비밀번호 찾기 요청을 받았습니다. 아래 링크를 클릭하여 비밀번호를 재설정하십시오.\n\n"
                        + "http://localhost:8080/users/reset-password?userId=" + userId;

            // 메일 메시지 생성
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(body);

            // 메일 전송
            Transport.send(message);

            return true;  // 메일 전송 성공
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;  // 메일 전송 실패
        }
    }
}