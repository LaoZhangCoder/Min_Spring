package untils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import Exception.AutowiredException;
import annotation.Component;
/*
 * @author cwt
 * @since  2017-02-03
 * @description  通过包名返回该包下所有的类名
 */
@Component
public class PackageUtil {
	@SuppressWarnings("unused")
	public static List<String> getallclassname(String packname) {
		//获取注解文件下的绝对路径
		String getabsoutepath = getabsoutepath(packname);
		String currentpath=packname;
		File file = new File(getabsoutepath);
		 if(file==null) {
			 throw new AutowiredException("你配置的自动注入包是否路径正确");
		 }
		File[] files = file.listFiles();
		ArrayList<String> list = new ArrayList<String>();
		 if(files==null) {
			 throw new AutowiredException("你配置的自动注入包是否路径正确");
		 }
		getAutowiredclassname(files, list,currentpath);
		return list;
	}
	 @SuppressWarnings("unused")
	public static String getabsoutepath(String a){
		 File file2 = new File(a);
		 if(file2==null) {
			 throw new AutowiredException("你配置的自动注入包是否路径正确");
		 }
		  String string = a.replace(file2.getPath(),"");
		  String finalstring=string+"target"+"\\"+"classes";
		  String all = finalstring.replaceAll("\\\\", "\\\\\\\\");
		  String aaa=all+"\\\\"+file2.getPath();		
		  String all2 = aaa.replaceAll("\\.", "\\\\\\\\");		 
		return all2;
	 }    
	 public static void getAutowiredclassname(File[] files,List<String> list,String packname) { 
		 for (File f : files) {		 
				//如果是文件，直接输出名字
		
					if(f.isFile()) {
					
					list.add(packname+"."+f.getName().replace(".class", ""));
					}
					//如果是文件夹，递归调用
					else if(f.isDirectory()) {
					packname=packname+"."+f.getName();
						getAutowiredclassname(f.listFiles(),list,packname);
						 packname=packname.substring(0, packname.lastIndexOf("."));
					}		
					
	               }
	    }  
	
}
