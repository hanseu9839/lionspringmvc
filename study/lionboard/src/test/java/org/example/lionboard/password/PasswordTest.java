package org.example.lionboard.password;

import org.assertj.core.api.Assertions;
import org.example.lionboard.util.CryptoUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PasswordTest {
    @Test
    @DisplayName("패스워드 해시 테스트")
    void passwordTest(){
        //given
        String password = "1234";

        //when
        String encryption = CryptoUtil.encrypt(password);
        String decryption = CryptoUtil.decrypt(encryption);

        //then
        assertThat(password).isEqualTo(decryption);
    }
}
