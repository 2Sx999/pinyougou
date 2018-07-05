package cn.porkchop.pinyougou.sms;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Consumer {
    @Autowired
    private SmsUtil smsUtil;

    @JmsListener(destination = "pinyougou-sendSms")
    public void readMessage(Map<String, String> map) {
        try {
            SendSmsResponse response = smsUtil.sendSms(map.get("phoneNumber"), map.get("code"));
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
