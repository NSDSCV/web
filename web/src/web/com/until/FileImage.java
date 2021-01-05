package web.com.until;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;
/**
 * 工具类  
 * 存储文件
 * @author Administrator
 *
 */
public class FileImage {
    /**
     * 封装 文件储存 工具类
     * @param request
     * @param part
     * @return path +"\\"+fileName   地址+随机名称.格式
     */
    public String getFileName(HttpServletRequest request,Part part) {

        System.out.println("part :" + part );
        // 得到实际路径
        String path = request.getServletContext().getRealPath("/picture/");
        System.out.println("path :" + path);
        //定义一个新的图片名称
        String fileName = UUID.randomUUID().toString();
        //提取图片后缀
        String contentDispostion = part.getHeader("content-disposition");
        // 获取上传文件的后缀名
        String suffix = contentDispostion.substring(contentDispostion.lastIndexOf("."), contentDispostion.length() - 1);
        fileName+=suffix;

//        String picpath = part.getSubmittedFileName();
        try {
            System.out.println(path +"\\"+fileName);
            part.write(path +"\\"+fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path +"\\"+fileName;

    }



}
