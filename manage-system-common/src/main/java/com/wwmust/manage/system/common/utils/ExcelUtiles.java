/*
package com.wwmust.manage.system.common.utils;

import net.sf.jxls.transformer.XLSTransformer;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * 导出excel
 * @ClassName: ExcelUtiles 
 * @Description: 
 * @author caizhu.rao
 * @date 2017年8月31日 上午9:42:39 
 *
 *//*

public class ExcelUtiles {

	private static String LIST_KEY="lists";
			
	*/
/**
	 * 依据模板生成简单的xls到outputstream
	 * 
	 * @param templateName
	 *            在classpath下的exportExcel的文件名
	 * @param datas
	 *            封装的List数据
	 * @param output
	 *            输出的output流
	 *//*

	public static void generateXlsByTemplate(String parentFolder,String templateFileName,
			List<?> datas, OutputStream output)throws Exception {
			
			if (StringUtils.isEmpty(parentFolder)) {
				throw new Exception("模板未找到！");
			}
			if (output==null){
				throw new RuntimeException("获取输出流失败!");
			}
			parentFolder=URLDecoder.decode(parentFolder, "UTF-8");
			
			XLSTransformer transformer = new XLSTransformer();
	
			Map beanParams = new HashMap();
			beanParams.put(LIST_KEY, datas);
		
			transformXLS(transformer, parentFolder, beanParams, output);
	}

	private static void transformXLS(XLSTransformer transformer,
			String srcPath, Map beanParams, OutputStream output)
			throws Exception {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new BufferedInputStream(new FileInputStream(srcPath));
			org.apache.poi.ss.usermodel.Workbook workbook = transformer.transformXLS(is, beanParams);
 
			os = new BufferedOutputStream(output);
			workbook.write(os);
			os.flush();
			os.close();
		} finally {
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
	}
	
	*/
/**
	 * 输出到response中流中
	 * @param parentFolder 父目录，从classloader根目录开始查找
	 * @param templateFileName 模板名称 
	 * @param filename  前台显示名称    专项执法加分项一201601201411123.xls
	 * @param lists 数据
	 * @param response
	 * @throws Exception
	 *//*

	public static void downExcel(String parentFolder,String templateFileName,String filename,List<?> lists,HttpServletResponse response) throws Exception{
		
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		
		filename=filename+DateUtil.getTimestampFull()+".xls";
		String filenameNew = URLEncoder.encode(filename, "UTF-8");
		
		response.setHeader("Content-Disposition", "attachment; filename="+ filenameNew);
		
		setNoCache(response);
		
		generateXlsByTemplate(parentFolder,templateFileName,lists,response.getOutputStream());
		
	}

	*/
/**
	 * 输出到文件中
	 * @param parentFolder 父目录，从classloader根目录开始查找
	 * @param templateFileName 模板名称 
	 * @param lists 数据
	 * @param filePath 文件绝对路径
	 * @throws Exception
	 *//*

	public static void downExcel(String parentFolder,String templateFileName,String filePath,List<?> lists) throws Exception{
		generateXlsByTemplate(parentFolder,templateFileName,lists,new FileOutputStream(filePath));
	}
	
	public static void setNoCache(HttpServletResponse response){
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
	}
	
	*/
/**
	 * 依据模板生成简单的xls到outputstream
	 * 
	 * @param srcFolder 模板在class下的路径
	 * @param templateName
	 *            在classpath下的exportExcel的文件名
	 * @param datas
	 *            封装的List数据
	 *//*

	public static Workbook generateXlsByTemplate(String srcFolder,String templateFileName,
			List<?> datas)throws Exception {
			URL url=ExcelUtiles.class.getClassLoader().getResource(srcFolder +"/"+ templateFileName);
			if (StringUtils.isEmpty(url)) {
				throw new Exception("模板未找到！");
			}
			String srcPath =url.getPath();
			
			if (StringUtils.isEmpty(srcPath)){
				throw new RuntimeException("模板未找到!");
			}
			srcPath=URLDecoder.decode(srcPath, "UTF-8");
			
			XLSTransformer transformer = new XLSTransformer();
	
			Map beanParams = new HashMap();
			beanParams.put(LIST_KEY, datas);
			InputStream is=null;
			try {
			    is=new  FileInputStream(srcPath);
				Workbook wb=transformer.transformXLS(is, beanParams);
				return wb;
			}finally{
				IOUtils.closeQuietly(is);
			}
	}
	
	*/
/**
	 * 工作簿写入输出流
	 * @param wb
	 * @param output
	 * @throws Exception
	 *//*

	public static void  writeOutputStream(Workbook wb,OutputStream output)throws Exception{
		if(output==null){
			throw new RuntimeException("获取输出流失败!");
		}
		try {
			wb.write(output);
			output.flush();
		} finally {
			IOUtils.closeQuietly(output);
		}
	}
	
	*/
/**
	 * 
	 * @param templateFileName 模板名称 
	 * @param filename  前台显示名称    专项执法加分项一201601201411123.xls
	 * @param lists 数据
	 * @param response
	 * @throws Exception
	 *//*

	public static void downExcel(String filename,Workbook wb,HttpServletResponse response) throws Exception{
		
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		
		filename=filename+DateUtil.getTimestampFull()+".xls";
		String filenameNew = URLEncoder.encode(filename, "UTF-8");
		
		response.setHeader("Content-Disposition", "attachment; filename="+ filenameNew);
		
		setNoCache(response);
		
		writeOutputStream(wb,response.getOutputStream());
		
	}
	
	*/
/**
	 * 
	 * @param srcFolder 模板所在class下的文件夹
	 * @param templateFileName 模板名称  如: xx.xls
	 * @param datas  封装模板中的数据 此bean的key作为模板中的key
	 * @return  返回Workbook
	 * @throws Exception
	 *//*

	public static Workbook generateXlsByTemplate(String srcFolder,String templateFileName,
			Map datas)throws Exception {
			URL url=ExcelUtiles.class.getClassLoader().getResource(srcFolder +"/"+ templateFileName);
			String srcPath =url.getPath();
			
			if (StringUtils.isEmpty(srcPath)){
				throw new RuntimeException("模板未找到!");
			}
			srcPath=URLDecoder.decode(srcPath, "UTF-8");
			
			XLSTransformer transformer = new XLSTransformer();
	
			InputStream is=null;
			try {
			    is=new  FileInputStream(srcPath);
				Workbook wb=transformer.transformXLS(is, datas);
				return wb;
			}finally{
				IOUtils.closeQuietly(is);
			}
	}
	public static void main(String[] args) throws Exception {
		List<Map> lists=new ArrayList<Map>() ;
		for(int i=0;i<10;i++){
			Map m1=new HashMap<String, Object>();
			m1.put("name","张三"+i);
			m1.put("age",20+i);
			lists.add(m1);
		}
		//ExcelUtils.downExcel("com/mossle/changneng/templet/excel/", "a.xls", "", lists, response);
		ExcelUtiles.downExcel("com/excel/", "Temp.xls", "d:/123.xls", lists);
	}
}
*/
