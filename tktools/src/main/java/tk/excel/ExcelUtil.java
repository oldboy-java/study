package tk.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.UnderlineStyle;
import jxl.write.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

/***
 * Excel处理工具类
 */
public class ExcelUtil {

	/**
	 * Excel导入 (2003格式)
	 * @param formFile
	 *            要解析的excel文件（Excel列表数据）
	 * @param columnNum
	 *            excel的列数
	 * @return 返回解析好的数据 (封装为list)
	 * @throws Exception
	 */
	public static List<String[]> generateExcelData(MultipartFile formFile, int columnNum)throws Exception {
		InputStream in = formFile.getInputStream();
		Workbook wb = null;
		ArrayList<String[]> list = new ArrayList<String[]>();
		wb = Workbook.getWorkbook(in);
		try {
			// 通过workbook对象获取sheet对象，获取的是一个数组对象
			Sheet sheet[] = wb.getSheets();
			if (sheet != null) {
				for (int i = 0; i < sheet.length; i++) {
					// sheet[i].getRows():使用sheet获取sheet中的行
					for (int j = 1; j < sheet[i].getRows(); j++) {
						// 定义数组存放数据项的值
						String[] valStr = new String[columnNum + 1];
						// sheet[i].getColumns():使用sheet获取sheet中的列
						for (int k = 0; k < sheet[i].getColumns(); k++) {
							// getCell(int column, int row) column表示列，row表示行
							// 通过行和列的索引获取单元格，下标从0开始
							Cell cell = sheet[i].getCell(k, j);
							String content = "";
							if (cell.getType() == CellType.DATE) {
								DateCell dateCell = (DateCell) cell;
								java.util.Date importdate = dateCell.getDate();
								/** 如果excel是日期格式的话需要减去8小时 */
								long eighthour = 8 * 60 * 60 * 1000;
								SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								/** 在当前日期上减8小时 */
								long time = importdate.getTime() - eighthour;
								java.util.Date date = new java.util.Date();
								date.setTime(time);
								content = simpledate.format(date);
							} else {
								// cell.getContents()：获取单元格的内容
								String tempcontent = (cell.getContents() == null ? "": cell.getContents());
								content = tempcontent.trim();
							}
							valStr[k] = content;
						}
						list.add(j - 1, valStr);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (wb != null) {
				wb.close();
			}
			if (in != null) {
				in.close();
			}
		}
		return list;
	}
	
	/**
	 * Excel导入 (2003格式)
	 * @param formFile
	 *            要解析的excel文件（Excel列表数据）
	 * @param columnNum
	 *            excel的列数
	 * @param sheetNum 需读取的sheet号，从0开始，第一个sheet值为0，依次类推
	 * @return 返回解析好的数据 (封装为list)
	 * @throws Exception
	 */
	public static List<String[]> generateExcelData(MultipartFile formFile, int columnNum,int sheetNum)throws Exception {
		InputStream in = formFile.getInputStream();
		Workbook wb = null;
		ArrayList<String[]> list = new ArrayList<String[]>();
		wb = Workbook.getWorkbook(in);
		try {
			// 通过workbook对象获取sheet对象，获取的是一个数组对象
			Sheet sheet[] = wb.getSheets();
			if (sheet != null) {
				for (int i = 0; i < sheet.length; i++) {
					if( i == sheetNum) {
						// sheet[i].getRows():使用sheet获取sheet中的行
						for (int j = 1; j < sheet[i].getRows(); j++) {
							// 定义数组存放数据项的值
							String[] valStr = new String[columnNum + 1];
							// sheet[i].getColumns():使用sheet获取sheet中的列
							for (int k = 0; k < sheet[i].getColumns(); k++) {
								// getCell(int column, int row) column表示列，row表示行
								// 通过行和列的索引获取单元格，下标从0开始
								Cell cell = sheet[i].getCell(k, j);
								String content = "";
								if (cell.getType() == CellType.DATE) {
									DateCell dateCell = (DateCell) cell;
									java.util.Date importdate = dateCell.getDate();
									/** 如果excel是日期格式的话需要减去8小时 */
									long eighthour = 8 * 60 * 60 * 1000;
									SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									/** 在当前日期上减8小时 */
									long time = importdate.getTime() - eighthour;
									java.util.Date date = new java.util.Date();
									date.setTime(time);
									content = simpledate.format(date);
								} else {
									// cell.getContents()：获取单元格的内容
									String tempcontent = (cell.getContents() == null ? "": cell.getContents());
									content = tempcontent.trim();
								}
								valStr[k] = content;
							}
							list.add(j - 1, valStr);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (wb != null) {
				wb.close();
			}
			if (in != null) {
				in.close();
			}
		}
		return list;
	}
	
	
	/**
	 * Excel导入 (2003格式)
	 * @param in
	 *            要解析的excel文件输入流（Excel列表数据）
	 * @param columnNum
	 *            excel的列数
	 * @return 返回解析好的数据 (封装为list)
	 * @throws Exception
	 */
	public static List<String[]> generateExcelData(InputStream in , int columnNum)throws Exception {
		Workbook wb = null;
		ArrayList<String[]> list = new ArrayList<String[]>();
		wb = Workbook.getWorkbook(in);
		try {
			// 通过workbook对象获取sheet对象，获取的是一个数组对象
			Sheet sheet[] = wb.getSheets();
			if (sheet != null) {
				for (int i = 0; i < sheet.length; i++) {
					// sheet[i].getRows():使用sheet获取sheet中的行
					for (int j = 1; j < sheet[i].getRows(); j++) {
						// 定义数组存放数据项的值
						String[] valStr = new String[columnNum + 1];
						// sheet[i].getColumns():使用sheet获取sheet中的列
						for (int k = 0; k < sheet[i].getColumns(); k++) {
							// getCell(int column, int row) column表示列，row表示行
							// 通过行和列的索引获取单元格，下标从0开始
							Cell cell = sheet[i].getCell(k, j);
							String content = "";
							if (cell.getType() == CellType.DATE) {
								DateCell dateCell = (DateCell) cell;
								java.util.Date importdate = dateCell.getDate();
								/** 如果excel是日期格式的话需要减去8小时 */
								long eighthour = 8 * 60 * 60 * 1000;
								SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								/** 在当前日期上减8小时 */
								long time = importdate.getTime() - eighthour;
								java.util.Date date = new java.util.Date();
								date.setTime(time);
								content = simpledate.format(date);
							} else {
								// cell.getContents()：获取单元格的内容
								String tempcontent = (cell.getContents() == null ? "": cell.getContents());
								content = tempcontent.trim();
							}
							valStr[k] = content;
						}
						list.add(j - 1, valStr);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (wb != null) {
				wb.close();
			}
			if (in != null) {
				in.close();
			}
		}
		return list;
	}
	
	/***
	 *  Excel数据导出，此功能只支持excel模版仅支持列表展示的情形(2003格式)
	 * @param data  需要导出的集合数据，这里data 数据在填充时需要注意与excel导出模版一一对应
	 * @param templatePath excel导出模版
	 * @param excelPath  生成的excel文件位置
	 * @return
	 */
	public static String  exportExcelByExcelTemplate(List<String[]> data,String templatePath,String excelPath){
            WritableWorkbook wwb = null;
            Workbook wb = null ;
            WritableSheet ws = null;
            
            try {
                wb = Workbook.getWorkbook(new File(templatePath));
                File targetFile = new File(excelPath);
                wwb = Workbook.createWorkbook(targetFile, wb);
                ws = wwb.getSheet("Sheet1");
                //设置单元格格式2：字体样式，水平居中，垂直靠底,自动换行，边框
                WritableCellFormat format= new WritableCellFormat();
                format.setAlignment(jxl.format.Alignment.CENTRE);
                format.setVerticalAlignment(jxl.format.VerticalAlignment.BOTTOM);
                format.setWrap(true);
                format.setBorder(Border.ALL, BorderLineStyle.THIN);
                Label lable;
                //定位开始插入的行表
                int row=1; 
                for(int  i = 0 ;i<data.size();i++){
                	//插入一行
                	ws.insertRow(i+row);
                	//获取集合中每条记录
                	String values[] = data.get(i);
                	//遍历每条记录的每个值
                	for(int k = 0; k < values.length; k++){
                		lable = new Label(k,row+i,values[k],format);  //写入第row+i行，第k列的单元格的值
                     	ws.addCell(lable);
                	}
                }
                wwb.write();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
            	   try {
            		   if(wwb!=null){
            			   wwb.close(); 
            		   }
            	   } catch (Exception e) {
            		   e.printStackTrace();
            	   }		
			}
            return excelPath;
    }

	
	/***
	 *  Excel数据导出，此功能只支持excel模版仅支持列表展示的情形(2003格式)
	 * @param data  需要导出的集合数据，这里data 数据在填充时需要注意与excel导出模版一一对应
	 * @param templatePath excel导出模版
	 * @param excelPath  生成的excel文件位置
	 * @param row 从第几行开始插入数据
	 * @return
	 */
	public static String  exportExcelByExcelTemplate(List<String[]> data,String templatePath,String excelPath,int row){
            WritableWorkbook wwb = null;
            Workbook wb = null;
            WritableSheet ws = null;
            try {
                wb = Workbook.getWorkbook(new File(templatePath));
                File targetFile = new File(excelPath);
                wwb = Workbook.createWorkbook(targetFile, wb);
                ws = wwb.getSheet("Sheet1");
                //设置单元格格式2：字体样式，水平居中，垂直靠底,自动换行，边框
                WritableCellFormat format= new WritableCellFormat();
                format.setAlignment(jxl.format.Alignment.CENTRE);
                format.setVerticalAlignment(jxl.format.VerticalAlignment.BOTTOM);
                format.setWrap(true);
                format.setBorder(Border.ALL, BorderLineStyle.THIN);
                Label lable;
                //定位开始插入的行表
                if(row < 1){
                	row = 1;
                } 
                for(int  i = 0 ;i<data.size();i++){
                	//插入一行
                	ws.insertRow(i+row);
                	//获取集合中每条记录
                	String values[] = data.get(i);
                	//遍历每条记录的每个值
                	for(int k = 0; k < values.length; k++){
                		lable = new Label(k,row+i,values[k],format);  //写入第row+i行，第k列的单元格的值
                     	ws.addCell(lable);
                	}
                }
                wwb.write();		
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
            	if(wwb!=null){
            		try {
						wwb.close();
					} catch (Exception e) {
						e.printStackTrace();
					}  
            	}
            }
            return excelPath;
    }
	
	/***
	 *  Excel文件下载
	 * @param filePath 下载路径
	 * @param response
	 * @param fileName 下载后显示的文件名
	 */
	public static void downloadExcel(String filePath,HttpServletResponse response,String fileName){
		    try {
		    	fileName = new String(fileName.getBytes("GB2312"), "ISO_8859_1"); //中文文件名处理
		     } catch (UnsupportedEncodingException e1) {
		    	e1.printStackTrace();
		    }
	      	response.addHeader("Content-Disposition", "attachment; filename="+fileName);
	      	response.setContentType("application/vnd.ms-excel;charset=UTF-8");
	        ServletOutputStream output;
			try {
				output = response.getOutputStream();
				File excel = new File(filePath);
				FileUtils.copyFile(excel, output);
				output.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	/**
	 * 动态导出数据并生成动态表头（2003）
	 * @param response  HttpServletResponse
	 * @param fileName  导出的Excel文件名 
	 * @param data      导出的数据集
	 * @param headerColumns Excel表头列表
	 */
	public static void  exportExcelWithDynamicHeader(HttpServletResponse response,String fileName,List<String[]> data,String[] headerColumns){
	   try {
			fileName = new String(fileName.getBytes("GB2312"), "ISO_8859_1");  	//中文文件名处理
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.addHeader("Content-Disposition", "attachment; filename="+fileName);//设置附件下载
	    response.setContentType("application/vnd.ms-excel;charset=UTF-8");//设置响应头
			   
		WritableSheet ws = null;
        WritableWorkbook wwb = null;
        ServletOutputStream os = null;
        try {
	        	os = response.getOutputStream();
	            wwb = Workbook.createWorkbook(os);
	            ws = wwb.createSheet("Sheet1", 0);
	            ws.getSettings().setDefaultColumnWidth(15); //设置默认列宽
	            
	            WritableFont font = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.BLACK);  
	            WritableFont rowFont = new WritableFont(WritableFont.ARIAL,10,WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.BLACK);  
	            
	            WritableCellFormat headerFormat= new WritableCellFormat(font);
	            headerFormat.setAlignment(jxl.format.Alignment.CENTRE);
	            headerFormat.setVerticalAlignment(jxl.format.VerticalAlignment.BOTTOM);
	            headerFormat.setWrap(true);
	            headerFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
	            
	            //设置单元格格式：字体样式，水平居中，垂直靠底,自动换行，边框
	            WritableCellFormat format= new WritableCellFormat(rowFont);
	            format.setAlignment(jxl.format.Alignment.CENTRE);
	            format.setVerticalAlignment(jxl.format.VerticalAlignment.BOTTOM);
	            format.setWrap(true);
	            format.setBorder(Border.ALL, BorderLineStyle.THIN);
	            
	            Label lable;
	            
	            //第0行生成表头行
	            ws.insertRow(0);
	            
	            //给第0行生成指定表头
	        	for(int k = 0; k < headerColumns.length; k++){
	        		lable = new Label(k,0,headerColumns[k],headerFormat);  
	             	ws.addCell(lable);
	        	}
            
	            //导出的结果集从第1行开始写
	            int row  =1; 
	            for(int  i = 0 ;i<data.size();i++){
	            	//插入一行
	            	ws.insertRow(i+1);
	            	
	            	//获取集合中每条记录
	            	String values[] = data.get(i);
	            
	            	//遍历每条记录的每个值
	            	for(int k = 0; k < values.length; k++){
	            		//写入第row+i行，第k列的单元格的值
	            		lable = new Label(k,row+i,values[k],format);  
	                 	ws.addCell(lable);
	                 	
	                 	/*//设置单元格自适应宽度
	                 	CellView cellView = new CellView();
		             	cellView.setAutosize(true);
		             	ws.setColumnView(k, cellView);*/
	            	}
	            }
	            os.flush();
	            wwb.write();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
			 if(wwb!=null){
	    		try {
					wwb.close();
				} catch (Exception e) {
					e.printStackTrace();
				}  
	        }
		}
}
	
	/***
	 *  导出下载(2003格式)
	 * @param data
	 * @param templatePath 模版路径
	 * @param excelPath 下载excel路径
	 * @param filename 下载excel文件名
	 */
	public static void doExport(List<String[]> data,String templatePath,String excelPath,String filename,HttpServletResponse response){
		ExcelUtil.exportExcelByExcelTemplate(data, templatePath, excelPath);
		ExcelUtil.downloadExcel(excelPath, response,filename);
		new File(excelPath).delete();
	}
	
	
	/***
	 *  Excel2007数据导出，此功能只支持excel模版仅支持列表展示的情形 （POI实现）
	 * @param data  需要导出的集合数据，这里data 数据在填充时需要注意与excel导出模版一一对应
	 * @param templatePath excel导出模版
	 * @param excelPath  生成的excel文件位置
	 * @param row 从第几行开始插入数据  参考：http://blog.sina.com.cn/s/blog_8297f0d001018w13.html  | http://www.cnblogs.com/dtts/p/4741575.html
	 * @return
	 */
	public static String  exportExcel2007DataList(List<String[]> data,String templatePath,String excelPath,int row) throws Exception{
			 XSSFWorkbook xwb = null;
			 FileOutputStream fos = null;
			 File templateBak = null;
            try {
            	
            	File template = ResourceUtils.getFile(templatePath);
            	templateBak = new File(template.getAbsolutePath().substring(0,template.getAbsolutePath().lastIndexOf(template.getName()))+System.currentTimeMillis()+".xlsx");
            	FileUtils.copyFile(template, templateBak);
            	
            	//构造工作簿
                xwb = new XSSFWorkbook(templateBak);
                
                
                //构造目标文件
                File targetFile = new File(excelPath);
                targetFile.createNewFile();
                
                //构建目标输出流
                fos = new FileOutputStream(targetFile);
                XSSFSheet sheet = xwb.getSheetAt(0);
            	XSSFRow firstRow = sheet.getRow(row);
                for(int i = 0 ;i<data.size();i++){
                	XSSFRow xssfRow = sheet.getRow(row+i);
                	if(xssfRow == null) { //模板中的行不够，需要生产Row
                		xssfRow = sheet.createRow(row+i);
                		xssfRow.setHeight((short)360); //设置行高   Excel的高度（默认磅）  = POI高度 /20
                		xssfRow.setRowStyle(firstRow.getRowStyle());
                	}
                
                	//获取集合中每条记录
                	String values[] = data.get(i);
                	
                	 XSSFCellStyle ztStyle = (XSSFCellStyle) xwb.createCellStyle();
                	 ztStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//对齐方式
                	 //设置边框线条样式
                	 ztStyle.setBorderBottom(CellStyle.BORDER_THIN);   
                	 ztStyle.setBorderTop(CellStyle.BORDER_THIN);   
                	 ztStyle.setBorderLeft(CellStyle.BORDER_THIN);   
                	 ztStyle.setBorderRight(CellStyle.BORDER_THIN); 
                	 //设置边框线颜色
                	 ztStyle.setBottomBorderColor(new XSSFColor(java.awt.Color.BLACK));   
                	 ztStyle.setTopBorderColor(new XSSFColor(java.awt.Color.BLACK));   
                	 ztStyle.setLeftBorderColor(new XSSFColor(java.awt.Color.BLACK));
                	 ztStyle.setRightBorderColor((new XSSFColor(java.awt.Color.BLACK)));
                	//遍历每条记录的每个值
                	for(int k = 0; k < values.length; k++){
                		//获取每个单元格
                		XSSFCell cell = xssfRow.getCell(k);
                		if(cell == null) {//模板中的行不够，需要生产Row
                			cell = xssfRow.createCell(k);
                			cell.setCellStyle(ztStyle);
                		}
                     	//设置单元格内容
                		cell.setCellValue(values[k]);
                	}
                }
                
                fos.flush();
                xwb.write(fos);
               
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
            	if(xwb!=null){
            		xwb.close();
            	}
            	if(fos!=null) {
					fos.close();
            	}
            	templateBak.delete();
            }
            return excelPath;
    } 
	
	/***
	 *  下载Excel
	 * @param data
	 * @param excelPath 下载excel路径
	 * @param filename 下载excel文件名
	 */
	public static void doDownloadExcel(String excelPath,String filename,HttpServletResponse response){
		ExcelUtil.downloadExcel(excelPath, response,filename);
		new File(excelPath).delete();
	}
}
