package com.chris.mall.util.random;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.collections.CollectionUtils;

/**
 * 功能描述
 *
 * @author Chris Chen
 * @version [mall-admin-ui]
 * @since Created in 2020-11-22
 */
public class Captcha {
    /**
     * 默认可选字体
     */
    private static final List<String> DEFAULT_FONT_NAMES = Arrays.asList("宋体", "微软雅黑", "楷体_GB2312",
        "Georgia");

    /**
     * 图片内边距
     */
    private final int padding = 2;

    /**
     * 图片宽度
     */
    private int width;

    /**
     * 图片高度
     */
    private int height;

    /**
     * 字符数量
     */
    private int count;

    /**
     * 干扰线数量
     */
    private int interference = 10;

    /**
     * 可选字体
     */
    private List<String> fontNameList = Arrays.asList("宋体", "微软雅黑", "楷体_GB2312", "Georgia");

    /**
     * 可选字符
     */
    private char[] codes =
        {'2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C',
            'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z'};

    /**
     * 随机对象
     */
    private Random random = new Random();

    /**
     * 存储画笔
     */
    private Graphics2D graphics;

    /**
     * 字符文本
     */
    private String text;

    /**
     * 无参构造
     */
    public Captcha(int count) {
        this.width = 50;
        this.height = 10;
        this.count = count;
    }

    /**
     * 构造函数
     *
     * @param width  图片宽度
     * @param height 图片高度
     * @param count  字符数量
     */
    public Captcha(int width, int height, int count) {
        this.width = Math.max(width, 50);
        this.height = Math.max(height, 10);
        this.count = count;
    }

    /**
     * 设置可选字体
     *
     * @param fontNameList 字体列表
     * @return this
     */
    public Captcha setFontNameList(List<String> fontNameList) {
        this.fontNameList = CollectionUtils.isEmpty(fontNameList) ? DEFAULT_FONT_NAMES
            : fontNameList;
        return this;
    }

    /**
     * 设置干扰线数量
     *
     * @param interference 数量
     * @return this
     */
    public Captcha setInterference(int interference) {
        this.interference = Math.max(interference, 8);
        return this;
    }

    /**
     * 获取生成的校验码
     *
     * @return 校验码
     */
    public String getText() {
        return text;
    }

    /**
     * 将图片进行输出
     *
     * @param image        图片缓存
     * @param outputStream 输出流
     * @throws IOException IO异常
     */
    public static void writeOut(BufferedImage image, OutputStream outputStream) throws IOException {
        ImageIO.write(image, "jpg", outputStream);
    }

    /**
     * 生成校验码图片缓存
     *
     * @return image
     */
    public BufferedImage create() {
        BufferedImage image = drawImage();
        drawCodes();
        interference();
        return image;
    }

    /**
     * 画图片
     *
     * @return image
     */
    private BufferedImage drawImage() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        graphics = (Graphics2D)image.getGraphics();
        graphics.setBackground(new Color(255, 255, random.nextInt(235) + 20));
        graphics.fillRect(0, 0, width, height);
        return image;
    }

    /**
     * 画字符
     */
    private void drawCodes() {
        StringBuilder builder = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            char c = randomChar();
            builder.append(c);
            graphics.setFont(randomFont());
            graphics.setColor(randomColor());
            graphics.drawString(c + "", padding + i * ((width - 2F * padding) / count),
                height / 1.4F);
        }
        this.text = builder.toString();
    }

    /**
     * 画干扰线
     */
    private void interference() {
        int inter = random.nextInt(interference);
        for (int i = 0; i < inter; i++) {
            graphics.setColor(randomColor());
            graphics.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width),
                random.nextInt(height));
        }
    }

    private Color randomColor() {
        return new Color(random.nextInt(225), random.nextInt(225), random.nextInt(225));
    }

    /**
     * 随机字符，设置字体、字号和样式
     * 保证可见性，字号在 1/3 范围内可变化
     *
     * @return 字体
     */
    private Font randomFont() {
        String name = fontNameList.get(random.nextInt(fontNameList.size()));
        int style = random.nextInt(4);
        int midSize = (height - 2 * padding) / 3;
        int size = random.nextInt(midSize) + 2 * midSize;
        return new Font(name, style, size);
    }

    private char randomChar() {
        return codes[random.nextInt(codes.length)];
    }

}
