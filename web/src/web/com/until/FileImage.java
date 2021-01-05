package web.com.until;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;
/**
 * ������  
 * �洢�ļ�
 * @author Administrator
 *
 */
public class FileImage {
    /**
     * ��װ �ļ����� ������
     * @param request
     * @param part
     * @return path +"\\"+fileName   ��ַ+�������.��ʽ
     */
    public String getFileName(HttpServletRequest request,Part part) {

        System.out.println("part :" + part );
        // �õ�ʵ��·��
        String path = request.getServletContext().getRealPath("/picture/");
        System.out.println("path :" + path);
        //����һ���µ�ͼƬ����
        String fileName = UUID.randomUUID().toString();
        //��ȡͼƬ��׺
        String contentDispostion = part.getHeader("content-disposition");
        // ��ȡ�ϴ��ļ��ĺ�׺��
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
