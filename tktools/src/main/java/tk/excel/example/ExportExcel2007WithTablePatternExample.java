package tk.excel.example;


import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Type;
import java.util.List;




import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ResourceUtils;

import com.alibaba.fastjson.JSONArray;

/***
 * 导出带表格格式的Excel2007
 *
 */
public class ExportExcel2007WithTablePatternExample {

	
	public static void main(String[] args) {
		exportExcelByExcelTemplate(null, "classpath:tuixiu_template.xlsx", "e:\\市级机关事业单位退休干部职工情况登记表.xlsx");
	}

	
	public static String  exportExcelByExcelTemplate(List<String[]> data,String templatePath,String excelPath){
		XSSFWorkbook xwb = null;
        try {
        	//构造工作簿
            xwb = new XSSFWorkbook(ResourceUtils.getFile(templatePath));
            //构造目标文件
            File targetFile = new File(excelPath);
            if(!targetFile.exists()){
            	targetFile.createNewFile();
            }
            targetFile.setLastModified(System.currentTimeMillis());
            FileOutputStream os = new FileOutputStream(targetFile);
            
            String unit = "台州科技职业技术学院";
            String xm="张加正";
            String sex="男";
            String nation="汉族";
			String jg="浙江温岭";
			String birth="1965-08-07";
			String workTime="1984-08-01";
			String zzmm="中国共产党党员";
			String rdsj="1985-12-01";
			String retireTime="1995-12-01";
			String card="332623196508070273";
			String zhiwu="厅局长";
			String treatment="省一级待遇";
			String education="本科";
			String graduation="浙江林业学校宁波分校林学专业";
			String txzhiwu="厅局长";
			String workExperience="1959—1964 清华大学水利工程系学习\n1964—1965 清华大学水利工程系学习，并任政治辅导员\n1965—1968 清华大学水利工程系参加科研工作，并任政治辅导员（“文化大革命”开始后终止）\n"
		          		+ "1968—1969 水电部刘家峡工程局房建队劳动\n";
            String commonAddress="海淀区上地九街数码科技大厦";
            String homeTel="010-56892330";
            String homeAddres="昌平区回龙观338号";
			String phone="18501019885";
			String relationshipJson="[{'relation':'妻子','name':'李明敏','birthday':'1967-09-21','workUnitPost':'北医三院','contactInformation':'18901019887'},{'relation':'儿子','name':'张智慧','birthday':'1987-09-21','workUnitPost':'百度','contactInformation':'18601015689'},{'relation':'女儿','name':'张丽','birthday':'1989-09-21','workUnitPost':'北医三院','contactInformation':'18501016547'}]";
			String recentSituation="中共第十二届中央候补委员、中央委员，十三届、十四届、十五届、十六届、十七届中央委员，十四届、十五届中央政治局委员、常委、中央书记处书记，十六届、十七届中央政治局委员、常委、中央委员会总书记。十五届四中全会增补为中央军事委员会副主席。第九届全国人大第一次会议当选为中华人民共和国副主席。第九届全国人大常委会第十二次会议任命为中华人民共和国中央军事委员会副主席。第十届全国人大第一次会议当选为中华人民共和国主席。十六届四中全会任中央军事委员会主席。第十届全国人大第三次会议当选为中华人民共和国中央军事委员会主席。十七届一中全会任中央军事委员会主席。第十一届全国人大第一次会议当选为中华人民共和国主席、中华人民共和国中央军事委员会主席。第六届全国政协常务委";
            
            setFirstSheetData(xwb,0,unit,xm,sex,nation,jg,birth,workTime,zzmm,rdsj,retireTime,card,zhiwu,treatment,education,graduation,txzhiwu,workExperience);
            setSecondSheetRetireData(xwb,1,commonAddress,homeTel,homeAddres,phone,relationshipJson,recentSituation);
            
            os.flush();
           //将Excel写出
            xwb.write(os);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return excelPath;
}

	/**
	   * 取出每列的值
	   *
	   * @param xCell 列
	   * @return
	   */
	  private static String getValue(XSSFCell xCell) {
	    if (xCell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
	      return String.valueOf(xCell.getBooleanCellValue());
	    } else if (xCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
	      return String.valueOf(xCell.getNumericCellValue());
	    } else {
	      return String.valueOf(xCell.getStringCellValue());
	    }
	  }
	  
	/***
	 * 设置第一个sheet数据
	 * @param xwb
	 * @param sheet  sheet号 从0开始
	 * @throws Exception
	 */
	private static void setFirstSheetData(XSSFWorkbook xwb, int sheet,String unit,String xm,String sex,String nation,
			String jg,String birth,String workTime,String zzmm,String rdsj,String retireTime,String card,
			String zhiwu,String treatment,String education,String graduation,String  txzhiwu,String workExperience) throws Exception{
		 //获取工作sheet 
		 XSSFSheet sh = xwb.getSheetAt(sheet);
         
         //获取左上角单元格及样式
		 XSSFCell cell = sh.getRow(1).getCell(0);
         //修改所在单位单元格
         cell.setCellValue(getValue(cell).concat(unit));
         
         //解析姓名单元格样式 
         XSSFCell nameCell = sh.getRow(2).getCell(0);
         CellStyle nameCellFormat = nameCell.getCellStyle();
         //构造姓名内容
         XSSFCell nameXSSFCell = sh.getRow(2).getCell(1);
         //设置样式
         nameXSSFCell.setCellStyle(nameCellFormat);
         nameXSSFCell.setCellValue(xm);
         
         //构造性别内容
         XSSFCell sexXSSFCell = sh.getRow(2).getCell(3);
         //设置样式
         sexXSSFCell.setCellStyle(nameCellFormat);
         sexXSSFCell.setCellValue(sex);
        
         //构造民族内容
         XSSFCell nationXSSFCell = sh.getRow(2).getCell(5);
         //设置样式
         nationXSSFCell.setCellStyle(nameCellFormat);
         nationXSSFCell.setCellValue(nation);
         
         
         //构造籍贯内容
         XSSFCell jgXSSFCell = sh.getRow(3).getCell(1);
         //设置样式
         jgXSSFCell.setCellStyle(nameCellFormat);
         jgXSSFCell.setCellValue(jg);
       
         //构造出生年月内容
         XSSFCell birthXSSFCell = sh.getRow(3).getCell(3);
         //设置样式
         birthXSSFCell.setCellStyle(nameCellFormat);
         birthXSSFCell.setCellValue(birth);
         
         //构造参加工作时间内容
         XSSFCell workTimeXSSFCell = sh.getRow(3).getCell(5);
         //设置样式
         workTimeXSSFCell.setCellStyle(nameCellFormat);
         workTimeXSSFCell.setCellValue(workTime);
         
         //构造政治面貌内容
         XSSFCell zzmmXSSFCell = sh.getRow(4).getCell(1);
         //设置样式
         zzmmXSSFCell.setCellStyle(nameCellFormat);
         zzmmXSSFCell.setCellValue(zzmm);
       
         //构造入党时间内容
         XSSFCell rdsjXSSFCell = sh.getRow(4).getCell(3);
         //设置样式
         rdsjXSSFCell.setCellStyle(nameCellFormat);
         rdsjXSSFCell.setCellValue(rdsj);
         
         //构造退休时间内容
         XSSFCell retireTimeXSSFCell = sh.getRow(4).getCell(5);
         //设置样式
         retireTimeXSSFCell.setCellStyle(nameCellFormat);
         retireTimeXSSFCell.setCellValue(retireTime);
         
         //构造身份证内容
         XSSFCell cardXSSFCell = sh.getRow(5).getCell(1);
         //设置样式
         cardXSSFCell.setCellStyle(nameCellFormat);
         cardXSSFCell.setCellValue(card);
         
         //构造现任职务内容
         XSSFCell zhiwuXSSFCell = sh.getRow(5).getCell(5);
         //设置样式
         zhiwuXSSFCell.setCellStyle(nameCellFormat);
         zhiwuXSSFCell.setCellValue(zhiwu);
         
         //构造享受待遇内容
         XSSFCell treatmentXSSFCell = sh.getRow(6).getCell(1);
         //设置样式
         treatmentXSSFCell.setCellStyle(nameCellFormat);
         treatmentXSSFCell.setCellValue(treatment);
         
         //构造学历内容
         XSSFCell educationXSSFCell = sh.getRow(6).getCell(3);
         //设置样式
         educationXSSFCell.setCellStyle(nameCellFormat);
         educationXSSFCell.setCellValue(education);
         
         //构造毕业院系及专业内容
         XSSFCell graduationXSSFCell = sh.getRow(6).getCell(5);
         //设置样式
         graduationXSSFCell.setCellStyle(nameCellFormat);
         graduationXSSFCell.setCellValue(graduation);
        
         //构造退休时职务内容
         XSSFCell txzhiwuXSSFCell = sh.getRow(7).getCell(2);
         //设置样式
         txzhiwuXSSFCell.setCellStyle(nameCellFormat);
         txzhiwuXSSFCell.setCellValue(txzhiwu);
         
         //构造主要工作经历内容
         XSSFCell workExperienceXSSFCell = sh.getRow(8).getCell(1);
         //设置样式
         workExperienceXSSFCell.setCellStyle(nameCellFormat);
         workExperienceXSSFCell.setCellValue(workExperience);
	}
	

	
	/***
	 * 设置第二个sheet退休信息数据
	 * @param XSSFWorkbook 工作簿
	 * @param sheet sheet号 从0开始
	 * @param commonAddress 常用地址
	 * @param homeTel 家庭电话
	 * @param homeAddres 家庭住址
	 * @param phone 手机号码
	 * @param relationshipJson 主要家庭成员
	 * @param recentSituation 最近情况
	 * @throws Exception
	 */
	private static void setSecondSheetRetireData(XSSFWorkbook xwb, int sheet,String commonAddress,String homeTel,String homeAddress,
			String phone,String relationshipJson,String recentSituation) throws Exception{
		 XSSFSheet sh = xwb.getSheetAt(sheet);
         
		///解析常用地址单元格样式
		 XSSFCell cydzCell =   sh.getRow(0).getCell(0);
		 CellStyle cf = cydzCell.getCellStyle();
         
         //构造常用地址内容
         XSSFCell commonAddresslabel = sh.getRow(0).getCell(1);
         //设置样式
         commonAddresslabel.setCellStyle(cf);
         commonAddresslabel.setCellValue(commonAddress);
         
         //构造家庭电话内容
         XSSFCell telXSSFCell = sh.getRow(0).getCell(6);
         //设置样式
         telXSSFCell.setCellStyle(cf);
         telXSSFCell.setCellValue(homeTel);
         
         //构造家庭地址内容
         XSSFCell homeAddrssXSSFCell = sh.getRow(1).getCell(1);
         //设置样式
         homeAddrssXSSFCell.setCellStyle(cf);
         homeAddrssXSSFCell.setCellValue(homeAddress);
         
         //构造手机内容
         XSSFCell phoneXSSFCell = sh.getRow(1).getCell(6);
         //设置样式
         phoneXSSFCell.setCellStyle(cf);
         phoneXSSFCell.setCellValue(phone);
         
         
         //解析主要家庭成员
         if(relationshipJson!=null && !"".equals(relationshipJson)){
             List<RelationDTO> relationList = JSONArray.parseArray(relationshipJson, RelationDTO.class);
             
             for(int i = 0 ;i < relationList.size();i++){
            	 RelationDTO relation = relationList.get(i);
            	 //构造关系内容
                 XSSFCell realationXSSFCell = sh.getRow(i+3).getCell(1);
                 //设置样式
                 realationXSSFCell.setCellStyle(cf);
                 realationXSSFCell.setCellValue(relation.getRelation());
                 
                //构造姓名内容
                 XSSFCell nameXSSFCell = sh.getRow(i+3).getCell(2);
                 //设置样式
                 nameXSSFCell.setCellStyle(cf);
                 nameXSSFCell.setCellValue(relation.getName());
                 
                 //构造出生年月内容
                 XSSFCell birthXSSFCell = sh.getRow(i+3).getCell(3);
                 //设置样式
                 birthXSSFCell.setCellStyle(cf);
                 birthXSSFCell.setCellValue(relation.getBirthday());
                 
                 //构造工作单位及职务内容
                 XSSFCell workUnitPostXSSFCell = sh.getRow(i+3).getCell(4);
                 //设置样式
                 workUnitPostXSSFCell.setCellStyle(cf);
                 workUnitPostXSSFCell.setCellValue(relation.getWorkUnitPost());
                 
                 //构造联系方式内容
                 XSSFCell contactInformationXSSFCell = sh.getRow(i+3).getCell(6);
                 //设置样式
                 contactInformationXSSFCell.setCellStyle(cf);
                 contactInformationXSSFCell.setCellValue(relation.getContactInformation());
            	 
             }
        
         }
         
         //构造最近情况内容
         XSSFCell recentSituationXSSFCell = sh.getRow(9).getCell(1);
         //设置样式
         recentSituationXSSFCell.setCellStyle(cf);
         recentSituationXSSFCell.setCellValue(recentSituation);
	}
	
	
	
	/***
	 * 根据合并单元格左上角和右下角坐标返回单元格区域
	 * @param sh 
	 * @param firstCol 单元格左上角列号
	 * @param firstRow 单元格左上角行号
	 * @param lastCol  单元格右下角列号
	 * @param lastRow 单元格右下角行号
	 * @return
	 */
	private static CellRangeAddress getRange(XSSFSheet sh ,int firstCol,int firstRow,  int lastCol, int lastRow){
		 List<CellRangeAddress> regions = sh.getMergedRegions();
		  for(CellRangeAddress region:regions){
			  if(region.getFirstRow()==firstRow && region.getFirstColumn() == firstCol && region.getLastRow() == lastRow
					  && region.getLastColumn() == lastCol){
				  return region;
			  }
			 
		  }
		  return null;
	}
	
	
}
