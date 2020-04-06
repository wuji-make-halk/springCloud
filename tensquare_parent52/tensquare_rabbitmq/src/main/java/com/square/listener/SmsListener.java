package com.square.listener;

import com.square.utils.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/8/15
 * Description:
 */
@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

    @Value("${aliyun.sms.template_code}")
    private String template_code;

    @Value("${aliyun.sms.sign_name}")
    private String sign_name;

    @RabbitHandler
    public void executeSms(Map<String, String> map) {
        String mobile = map.get("mobile");
        String checkCode = map.get("checkCode");
        System.out.print("手机号:" + mobile);
        System.out.print("验证码:" + checkCode);
        try {
            smsUtil.sendSms(mobile, template_code, sign_name, "{\"code\":\"" + checkCode + "\"}");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
