<%@ WebHandler Language="C#" Class="UploadHandler" %> 
  
using System; 
using System.Web; 
using System.Text.RegularExpressions; 
using System.IO; 
  
public class UploadHandler : IHttpHandler { 
 private string _filedir = ""; //�ļ�Ŀ¼ 
 /// <summary> 
 /// �����ϴ��ļ�(1:�ļ���ʽ����ȷ��2:�ļ���С����ȷ��3:�ϴ�ʧ�ܡ��ļ�����:�ϴ��ɹ�) 
 /// </summary> 
 /// <param name="context"></param> 
 public void ProcessRequest (HttpContext context) { 
 _filedir = context.Server.MapPath(@"/file/temp/"); 
 try
 { 
 string result = "3"; 
 string fileType = context.Request.QueryString["fileType"]; //��ȡ�ϴ��ļ����� 
 if (fileType == "file") 
 { 
 result = UploadFile(context); //�ĵ��ϴ� 
 } 
 else if (fileType == "img") 
 { 
 result = UploadImg(context); //ͼƬ�ϴ� 
 } 
 context.Response.Write(result); 
 } 
 catch
 { 
 context.Response.Write("3");//3�ļ��ϴ�ʧ�� 
 } 
 } 
  
 /// <summary> 
 /// �ĵ��ϴ� 
 /// </summary> 
 /// <param name="context"></param> 
 /// <returns></returns> 
 private string UploadFile(HttpContext context) 
 { 
 int cout = context.Request.Files.Count; 
 if (cout > 0) 
 { 
 HttpPostedFile hpf = context.Request.Files[0]; 
 if (hpf != null) 
 { 
 string fileExt = Path.GetExtension(hpf.FileName).ToLower(); 
 //ֻ���ϴ��ļ������˲����ϴ����ļ����� 
 string fileFilt = ".rar|.zip|.pdf|.pdfx|.txt|.csv|.xls|.xlsx|.doc|.docx......"; 
 if (fileFilt.IndexOf(fileExt) <= -1) 
 { 
  return "1"; 
 } 
   
 //�ж��ļ���С 
 int length = hpf.ContentLength; 
 if (length > 2097152) 
 { 
  return "2"; 
 } 
   
 Random rd = new Random(); 
 DateTime nowTime = DateTime.Now; 
 string newFileName = nowTime.Year.ToString() + nowTime.Month.ToString() + nowTime.Day.ToString() + nowTime.Hour.ToString() + nowTime.Minute.ToString() + nowTime.Second.ToString() + rd.Next(1000, 1000000) + Path.GetExtension(hpf.FileName); 
 if (!Directory.Exists(_filedir)) 
 { 
  Directory.CreateDirectory(_filedir); 
 } 
 string fileName = _filedir + newFileName; 
 hpf.SaveAs(fileName); 
 return newFileName; 
 } 
  
 } 
 return "3"; 
 } 
  
 /// <summary> 
 /// ͼƬ�ϴ� 
 /// </summary> 
 /// <param name="context"></param> 
 /// <returns></returns> 
 private string UploadImg(HttpContext context) 
 { 
 int cout = context.Request.Files.Count; 
 if (cout > 0) 
 { 
 HttpPostedFile hpf = context.Request.Files[0]; 
 if (hpf != null) 
 { 
 string fileExt = Path.GetExtension(hpf.FileName).ToLower(); 
 //ֻ���ϴ��ļ������˲����ϴ����ļ����� 
 string fileFilt = ".gif|.jpg|.php|.jsp|.jpeg|.png|......"; 
 if (fileFilt.IndexOf(fileExt) <= -1) 
 { 
  return "1"; 
 } 
   
 //�ж��ļ���С 
 int length = hpf.ContentLength; 
 if (length > 204800) 
 { 
  return "2"; 
 } 
   
 Random rd = new Random(); 
 DateTime nowTime = DateTime.Now; 
 string newFileName = nowTime.Year.ToString() + nowTime.Month.ToString() + nowTime.Day.ToString() + nowTime.Hour.ToString() + nowTime.Minute.ToString() + nowTime.Second.ToString() + rd.Next(1000, 1000000) + Path.GetExtension(hpf.FileName); 
 if (!Directory.Exists(_filedir)) 
 { 
  Directory.CreateDirectory(_filedir); 
 } 
 string fileName = _filedir + newFileName; 
 hpf.SaveAs(fileName); 
 return newFileName; 
 } 
  
 } 
 return "3"; 
 }
  
 #region IHttpHandler ��Ա 
  
 public bool IsReusable 
 { 
 get { throw new NotImplementedException(); } 
 }
  
 #endregion 
} 