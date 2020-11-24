package com.chris.mall.util.random;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author Chris Chen
 * @version [mall-admin-ui]
 * @since Created in 2020-11-22
 */
class CaptchaTest {

    @Test
    void writeOut() {
        Captcha captcha = new Captcha(75, 25, 4);
        BufferedImage image = captcha.create();
        File file = new File("src/test/resources/captcha.jpg");
        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream(file));
            Captcha.writeOut(image, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}