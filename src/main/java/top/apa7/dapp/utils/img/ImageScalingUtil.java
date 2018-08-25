package top.apa7.dapp.utils.img;

import com.mortennobel.imagescaling.DimensionConstrain;
import com.mortennobel.imagescaling.ResampleOp;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import top.apa7.dapp.constant.BaseLogger;

/**
 * 图片压缩工具
 * 
 * @author: apa7
 * @date:2016年1月8日
 * @Copyright
 */
public class ImageScalingUtil extends BaseLogger {

    private static ImageScalingUtil imageScalingUtil = null;

    public synchronized static ImageScalingUtil getInstance() {
        if (imageScalingUtil == null) {
            imageScalingUtil = new ImageScalingUtil();
        }
        return imageScalingUtil;
    }

    private ImageScalingUtil() {
    }

    public static void main_test(String[] args) {
        boolean flag = getInstance().scale(new File("d://20160513030419760.jpg"), new File("d:/aa_1.jpg"), "jpg", 360,
                360);
        System.out.println(flag);
    }

    public boolean scale(File src, File dest, String suffix, int width, int height) {
        try {
            BufferedImage apples = ImageIO.read(src);
            ResampleOp resampleOp = new ResampleOp(DimensionConstrain.createMaxDimension(width, height, true));
            BufferedImage rescaled = resampleOp.filter(apples, null);
            ImageIO.write(rescaled, suffix, dest);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            return false;
        }
    }
}
