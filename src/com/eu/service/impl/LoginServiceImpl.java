package com.eu.service.impl;

import com.eu.pojo.VerificationCode;
import com.eu.service.LoginService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.springframework.stereotype.Service;

/**
 * Created by lip on 17/3/21.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public VerificationCode verifyPhoneNumber(String phone) throws ApiException {

        //随机生成验证码
        Integer randomcode = (int)(Math.random()*10000);

        String code = randomcode.toString();

        // 发送短信
        TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", "23708874", "094ea180fed761b671b3b059aac6f09f");
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend( "" );
        req.setSmsType( "normal" );
        req.setSmsFreeSignName( "EU科技" );
        req.setSmsParamString( "{number:'"+code+"'}" );
        req.setRecNum(phone);
        req.setSmsTemplateCode( "SMS_56610387" );
        AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());

        VerificationCode verificationCode = new VerificationCode(code,"success");

        return verificationCode;
    }
}
