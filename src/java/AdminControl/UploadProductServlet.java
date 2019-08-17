/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminControl;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author admin
 */
@WebServlet(name = "UploadProductServlet", urlPatterns = {"/UploadProductServlet"})
public class UploadProductServlet extends HttpServlet {

    
    private static String getRootName(String path){
        int t = path.lastIndexOf("\\");
        String name = path.substring(t+1);
        return name;
    }
    
    private static String createFileInfo(String fileName){
        fileName = getRootName(fileName);
        int t = fileName.lastIndexOf('.');
        String name = fileName.substring(0, t);
        return name + "-info.txt";
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadFileDemoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            try{
                List<FileItem> listFile = upload.parseRequest(request);
                String fileName = "";
                for(FileItem fileItem : listFile){
                    if(fileItem.isFormField() == false){
                        fileName = fileItem.getName();
                        
                        String saveFileDir = request.getServletContext().getInitParameter("file-upload");
                        File pathSaved = new File(saveFileDir + getRootName(fileName));
                        
                        out.println("<h1> Successful </h1>");
                        fileItem.write(pathSaved);
                    }
                    else{
                        File f = new File(request.getServletContext().getInitParameter("file-upload") + createFileInfo(fileName));
//                          out.print(request.getServletContext().getInitParameter("file-upload") + createFileInfo(fileName));
                        if(f.createNewFile()){
                            System.out.println("Success create new file");
                            try(
                                FileWriter fw = new FileWriter(request.getServletContext().getInitParameter("file-upload") + createFileInfo(fileName));
                                BufferedWriter bw = new BufferedWriter(fw);
                                    ){
                            
                            bw.write(fileItem.getString());}
                        }
                        else{
                            System.out.println("File existed");
                        }
                    }
                }
            }catch(Exception ex){
                out.println("<h1>"+ ex.getMessage() +"</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
