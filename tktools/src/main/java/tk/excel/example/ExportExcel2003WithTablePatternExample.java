package tk.excel.example;


import java.io.File;
import java.util.List;

import jxl.Cell;
import jxl.Range;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.util.ResourceUtils;

import com.alibaba.fastjson.JSONArray;


public class ExportExcel2003WithTablePatternExample {

	
	public static void main(String[] args) {
		exportExcelByExcelTemplate(null, "classpath:tuixiu_template.xls", "e:\\市级机关事业单位退休干部职工情况登记表.xls");
	}

	
	public static String  exportExcelByExcelTemplate(List<String[]> data,String templatePath,String excelPath){
        WritableWorkbook wwb = null;
        Workbook wb = null ;
        WritableSheet ws = null;
        
        try {
            wb = Workbook.getWorkbook(ResourceUtils.getFile(templatePath));
            File targetFile = new File(excelPath);
            if(!targetFile.exists()){
            	targetFile.createNewFile();
            }
            wwb = Workbook.createWorkbook(targetFile, wb);
            
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
            
            setFirstSheetData(wwb,ws,0,unit,xm,sex,nation,jg,birth,workTime,zzmm,rdsj,retireTime,card,zhiwu,treatment,education,graduation,txzhiwu,workExperience);
            setSecondSheetRetireData(wwb,ws,1,commonAddress,homeTel,homeAddres,phone,relationshipJson,recentSituation);
            
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
	 * 设置第一个sheet数据
	 * @param wwb
	 * @param ws
	 * @param sheet  sheet号 从0开始
	 * @throws Exception
	 */
	private static void setFirstSheetData(WritableWorkbook wwb,WritableSheet ws, int sheet,String unit,String xm,String sex,String nation,
			String jg,String birth,String workTime,String zzmm,String rdsj,String retireTime,String card,
			String zhiwu,String treatment,String education,String graduation,String  txzhiwu,String workExperience) throws Exception{
		 ws = wwb.getSheet(sheet);
         
         //解析所在单位
         Range range = getRange(ws, 0, 1, 6, 1);
         //获取左上角单元格及样式
         Cell CellTop =   range.getTopLeft();
         jxl.format.CellFormat cf = CellTop.getCellFormat();
         //构造所在单位单元格
         Label label = new Label(0,1,CellTop.getContents().concat(unit));
         //设置样式
         label.setCellFormat(cf);
         //合并单元格，第一个参数：要合并的单元格最左上角的列号，第二个参数：要合并的单元格最左上角的行号，第三个参数：要合并的单元格最右角的列号，第四个参数：要合并的单元格最右下角的行号
         ws.mergeCells(0, 1, 6, 1);
         ws.addCell(label);
         
         //解析姓名单元格样式 getCell(x,y)   第y行的第x列 
         Cell nameCell = ws.getCell(0, 2);
         jxl.format.CellFormat nameCellFormat = nameCell.getCellFormat();
         
         //构造姓名内容
         Label nameLabel = new Label(1,2,xm);
         //设置样式
         nameLabel.setCellFormat(nameCellFormat);
         ws.addCell(nameLabel);
       
         //构造性别内容
         Label sexLabel = new Label(3,2,sex);
         //设置样式
         sexLabel.setCellFormat(nameCellFormat);
         ws.addCell(sexLabel);
         
         //构造性别内容
         Label nationLabel = new Label(5,2,nation);
         //设置样式
         nationLabel.setCellFormat(nameCellFormat);
         ws.addCell(nationLabel);
         
         //构造籍贯内容
         Label jgLabel = new Label(1,3,jg);
         //设置样式
         jgLabel.setCellFormat(nameCellFormat);
         ws.addCell(jgLabel);
       
         //构造出生年月内容
         Label birthLabel = new Label(3,3,birth);
         //设置样式
         birthLabel.setCellFormat(nameCellFormat);
         ws.addCell(birthLabel);
         
         //构造参加工作时间内容
         Label workTimeLabel = new Label(5,3,workTime);
         //设置样式
         workTimeLabel.setCellFormat(nameCellFormat);
         ws.addCell(workTimeLabel);
         
         //构造政治面貌内容
         Label zzmmLabel = new Label(1,4,zzmm);
         //设置样式
         zzmmLabel.setCellFormat(nameCellFormat);
         ws.addCell(zzmmLabel);
       
         //构造入党时间内容
         Label rdsjLabel = new Label(3,4,rdsj);
         //设置样式
         rdsjLabel.setCellFormat(nameCellFormat);
         ws.addCell(rdsjLabel);
         
         //构造退休时间内容
         Label retireTimeLabel = new Label(5,4,retireTime);
         //设置样式
         retireTimeLabel.setCellFormat(nameCellFormat);
         ws.addCell(retireTimeLabel);
         
         //构造身份证内容
         Label cardLabel = new Label(1,5,card);
         //设置样式
         cardLabel.setCellFormat(nameCellFormat);
         ws.mergeCells(1, 5, 3, 5);
         ws.addCell(cardLabel);
         
         //构造现任职务内容
         Label zhiwuLabel = new Label(5,5,zhiwu);
         //设置样式
         zhiwuLabel.setCellFormat(nameCellFormat);
         ws.addCell(zhiwuLabel);
         
         //构造享受待遇内容
         Label treatmentLabel = new Label(1,6,treatment);
         //设置样式
         treatmentLabel.setCellFormat(nameCellFormat);
         ws.addCell(treatmentLabel);
         
         //构造学历内容
         Label educationLabel = new Label(3,6,education);
         //设置样式
         educationLabel.setCellFormat(nameCellFormat);
         ws.addCell(educationLabel);
         
         //构造毕业院系及专业内容
         Label graduationLabel = new Label(5,6,graduation);
         //设置样式
         graduationLabel.setCellFormat(nameCellFormat);
         ws.addCell(graduationLabel);
        
         //构造退休时职务内容
         Label txzhiwuLabel = new Label(2,7,txzhiwu);
         //设置样式
         txzhiwuLabel.setCellFormat(nameCellFormat);
         ws.mergeCells(2, 7, 5, 7);
         ws.addCell(txzhiwuLabel);
         
       //  Label workExperienceLabel = new Label(1,8,"1959—1964 清华大学水利工程系学习\n1964—1965 清华大学水利工程系学习，并任政治辅导员\n1965—1968 清华大学水利工程系参加科研工作，并任政治辅导员（“文化大革命”开始后终止）\n"
          	//	+ "1968—1969 水电部刘家峡工程局房建队劳动\n");
         //构造主要工作经历内容
         Label workExperienceLabel = new Label(1,8,workExperience);
         //设置样式
         workExperienceLabel.setCellFormat(nameCellFormat);
         ws.mergeCells(1, 8, 5, 8);
         ws.addCell(workExperienceLabel);
	}
	

	
	/***
	 * 设置第二个sheet退休信息数据
	 * @param wwb
	 * @param ws
	 * @param sheet sheet号 从0开始
	 * @param commonAddress 常用地址
	 * @param homeTel 家庭电话
	 * @param homeAddres 家庭住址
	 * @param phone 手机号码
	 * @param relationshipJson 主要家庭成员
	 * @param recentSituation 最近情况
	 * @throws Exception
	 */
	private static void setSecondSheetRetireData(WritableWorkbook wwb,WritableSheet ws, int sheet,String commonAddress,String homeTel,String homeAddres,
			String phone,String relationshipJson,String recentSituation) throws Exception{
		 ws = wwb.getSheet(sheet);
         
		 //解析常用地址单元格样式
         Cell cydzCell =   ws.getCell(0, 0);
         jxl.format.CellFormat cf = cydzCell.getCellFormat();
         
         //构造常用地址内容
         Label commonAddresslabel = new Label(1,0,commonAddress);
         //设置样式
         commonAddresslabel.setCellFormat(cf);
         //合并单元格，第一个参数：要合并的单元格最左上角的列号，第二个参数：要合并的单元格最左上角的行号，第三个参数：要合并的单元格最右角的列号，第四个参数：要合并的单元格最右下角的行号
         ws.mergeCells(1, 0, 4, 0);
         ws.addCell(commonAddresslabel);
         
         //构造家庭电话内容
         Label telLabel = new Label(6,0,homeTel);
         //设置样式
         telLabel.setCellFormat(cf);
         ws.addCell(telLabel);
         
         //构造家庭地址内容
         Label homeAddrssLabel = new Label(1,1,homeAddres);
         //设置样式
         homeAddrssLabel.setCellFormat(cf);
         //合并单元格，第一个参数：要合并的单元格最左上角的列号，第二个参数：要合并的单元格最左上角的行号，第三个参数：要合并的单元格最右角的列号，第四个参数：要合并的单元格最右下角的行号
         ws.mergeCells(1, 1, 4, 1);
         ws.addCell(homeAddrssLabel);
         
         //构造手机内容
         Label phoneLabel = new Label(6,1,phone);
         //设置样式
         phoneLabel.setCellFormat(cf);
         ws.addCell(phoneLabel);
         
         
         //解析主要家庭成员
         if(relationshipJson!=null && !"".equals(relationshipJson)){
        	  
             List<RelationDTO> relationList = JSONArray.parseArray(relationshipJson, RelationDTO.class);
             
             for(int i = 0 ;i < relationList.size();i++){
            	 RelationDTO relation = relationList.get(i);
            	 //构造关系内容
                 Label realationLabel = new Label(1,i+3,relation.getRelation());
                 //设置样式
                 realationLabel.setCellFormat(cf);
                 ws.addCell(realationLabel);
                 
                //构造姓名内容
                 Label nameLabel = new Label(2,i+3,relation.getName());
                 //设置样式
                 nameLabel.setCellFormat(cf);
                 ws.addCell(nameLabel);
                 
                 //构造出生年月内容
                 Label birthLabel = new Label(3,i+3,relation.getBirthday());
                 //设置样式
                 birthLabel.setCellFormat(cf);
                 ws.addCell(birthLabel);
                 
                 //构造工作单位及职务内容
                 Label workUnitPostLabel = new Label(4,i+3,relation.getWorkUnitPost());
                 //设置样式
                 workUnitPostLabel.setCellFormat(cf);
                 ws.mergeCells(4, i+3, 5, i+3);
                 ws.addCell(workUnitPostLabel);
                 
                 //构造联系方式内容
                 Label contactInformationLabel = new Label(6,i+3,relation.getContactInformation());
                 //设置样式
                 contactInformationLabel.setCellFormat(cf);
                 ws.addCell(contactInformationLabel);
            	 
             }
        
         }
         
         //构造最近情况内容
         Label recentSituationLabel = new Label(1,9,recentSituation);
         //设置样式
         recentSituationLabel.setCellFormat(cf);
         ws.mergeCells(1, 9, 5, 9);
         ws.addCell(recentSituationLabel);
	}
	
	
	
	/***
	 * 根据合并单元格左上角和右下角坐标返回单元格区域
	 * @param ws 
	 * @param colTop 单元格左上角列号
	 * @param rowTop 单元格左上角行号
	 * @param colBottom  单元格右下角列号
	 * @param colRow 单元格右下角行号
	 * @return
	 */
	private static Range getRange(WritableSheet ws,int colTop,int rowTop,int colBottom,int colRow){
		  Range[] ranges = ws.getMergedCells();
		  for(Range range:ranges){
			  if(range.getBottomRight().getColumn() == colBottom && range.getBottomRight().getRow()==colRow  && range.getTopLeft()
					  .getColumn() == colTop && range.getTopLeft().getRow() == rowTop){
				  return range;
			  }
		  }
		  return null;
	}
	
	
}
