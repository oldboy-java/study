package com.qtrmoon.common;

import java.io.Serializable;
import java.util.Date;

import com.qtrmoon.toolkit.DateTransfer;


/********************************************************************************************
 *  @author Javamao
 *  可以使用单字段排序，默认正序排列，可定义倒叙。
 *  例如：addOrderCol(colName);descOrder();
 *  也可使用多字段排序:
 *  例如按照colName1,colName2正序：
 *  addOrderCol(colName1);addOrderCol(colName2);
 *  再例如addOrderCol(colName1);addOrderCol(colName2);descOrder();
 *  此时为colName1正序，colName2倒叙，调用descOrder()后只会指定按照最后addOrderCol方法加入的字段倒叙。
 *  如果要指定多字段都倒叙可以使用：
 *  addOrderDescCol(colName1);addOrderDescCol(colName2);
 *  注意如果最后添加的排序字段使用了addOrderDescCol，又调用了ascOrder方法。
 *  则优先考虑addOrderDescCol而忽略ascOrder方法，即最后字段仍为倒叙排列。
 ********************************************************************************************/
public class PageForm implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 总的数据条数0
    private long datasize = 0;

    // 请求的URL地址
    private String strUrl = "";

    // 查询条件
    private String condition = "";

    private String orderCol = ",";

    private String orderType = "";

    private int page = 1;

    private int pagesize = 10;
    
    //sort：排序列字段名。
    //order：排序方式，可以是 'asc' 或者 'desc'，默认值是 'asc'。
    private String sort,order;//for easyUI,
    
    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int currentPage) {
        this.page = currentPage;
    }

    public long getDatasize() {
        return datasize;
    }
    public void setDatasize(long datasize) {
        //查询时检查currentPage。删除末页所有记录后上翻一页。
        if(datasize<=(page-1)*pagesize){
            page--;
        }
        if(datasize>0&&page==0){//首次进入currentPage=0的后续处理。
            page=1;
        }
        this.datasize = datasize;
    }

    public int getPagesize() {
        return pagesize;
    }
    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
    
    public void setRows(int pagesize){
        this.pagesize = pagesize;
    }
    public int getRows() {
        return pagesize;
    }
    
    public long getPageNum(){
        long pageNum;
        if (datasize % pagesize > 0) {
            pageNum = datasize / pagesize + 1;
        } else {
            pageNum = datasize / pagesize;
        }
        if (pageNum == 0) {
            pageNum = 1;
        }
        return pageNum;
    }
    public int getOffset(){
        return (page-1)*pagesize;
    }
    public String getStrUrl() {
        return strUrl;
    }

    public void setStrUrl(String strUrl) {
        this.strUrl = strUrl;
    }

    public String getOrderCol() {
        //如果末尾排列字段定义了反序，则清空orderType。
        if(!orderCol.equals(",")){
            String order = orderCol.substring(1, orderCol.length() - 1);
            if(!orderType.equals("")){
                if(order.lastIndexOf("DESC")==order.length()-4){
                    orderType="";
                }
            }
            return orderCol.substring(1, orderCol.length() - 1);
        }
        return "";
    }

    public void addOrderCol(String ord) {
        if (ord != null && !ord.equals("")) {
            if (this.orderCol.indexOf("t." + ord + " ") < 0) {
                this.orderCol += "t." + ord + " ,";
            }
        }
    }
    public void setOrderCol(String ord) {
        if (ord != null && !ord.equals("")) {
            this.orderCol = ",t." + ord + " ,";
        }
    }
    public void addOrderDescCol(String ord) {
        if (ord != null && !ord.equals("")) {
            if (this.orderCol.indexOf("t." + ord + " ") < 0) {
                this.orderCol += "t." + ord + " DESC,";
            }
        }
    }

    public void clearOrderCol() {
        orderCol = ",";
    }

    public String getOrderType() {
        return this.orderType;
    }

    public void ascOrder() {
        this.orderType = "ASC";
    }

    public void descOrder() {
        this.orderType = "DESC";
    }

    public void reverseOrder() {
        if (this.orderType.equals("ASC")) {
            this.orderType = "DESC";
        } else {
            this.orderType = "ASC";
        }
    }

    public void setSort(String col) {
        sort=col;
        setSandO();
    }
    public void setOrder(String orderType) {
        order=orderType.toUpperCase();
        setSandO();
    }
    private void setSandO(){
        if(order!=null&&sort!=null&&!order.equals("")&&!sort.equals("")){
            if("DESC".equals(order)){
                setOrderCol(sort);
            }else{
                addOrderDescCol(sort);
            }
        }
    }
    
    
    /**
     * @param dob 日期字符串
     * @return
     */
    protected Date _getTime(String dob) {
        if(dob!=null&&!dob.equals("")){
            if(dob.length()>10){
                return DateTransfer.stringToTime(dob);
            }else{
                return DateTransfer.stringToDate(dob);
            }
        }
        return null;
    }
    
    /**
     * 设定查询条件起始时间，将时间设定为0时
     * @param dBegin
     * @return
     */
    protected Date _getBegDate(String dBegin) {
        if(dBegin!=null&&!dBegin.equals("")){
            if(dBegin.indexOf(" ")>0){
                dBegin=dBegin.substring(0,dBegin.indexOf(" ")).trim();//去掉时间后缀
            }
            dBegin+=" 00:00:00.000";
            return DateTransfer.toTime(dBegin,"yyyy-MM-dd HH:mm:ss.SSS");
        }
        return null;
    }
    
    /**
     * 设定查询条件结束时间，将时间设定为23:59:59
     * @param dEnd
     * @return
     */
    protected Date _getEndDate(String dEnd) {
        if(dEnd!=null&&!dEnd.equals("")){
            if(dEnd.indexOf(" ")>0){
                dEnd=dEnd.substring(0,dEnd.indexOf(" ")).trim();//去掉时间后缀
            }
            dEnd+=" 23:59:59.999";
            return DateTransfer.toTime(dEnd,"yyyy-MM-dd HH:mm:ss.SSS");
        }
        return null;
    }
    
    protected void assignLike(String colname) {
        try {
            colname=colname.substring(0, 1).toUpperCase()+colname.substring(1);
            String val=(String)getClass().getMethod("get"+colname, null).invoke(this, null);
            if(val!=null&&!val.equals("")){
                getClass().getMethod("set"+colname,String.class).invoke(this,"%"+val+"%");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void assLike(String... cn){
        for(String name:cn){
            assignLike(name);
        }
    }
    
    public void unAssignLike(String colname) {
        try {
            colname=colname.substring(0, 1).toUpperCase()+colname.substring(1);
            String val=(String)getClass().getMethod("get"+colname, null).invoke(this, null);
            val = val.replaceAll("%", "");
            if(val!=null&&!val.equals("")){
                getClass().getMethod("set"+colname,String.class).invoke(this,val);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
