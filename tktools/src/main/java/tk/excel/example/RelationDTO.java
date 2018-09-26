package tk.excel.example;


/**
 * 家庭成员关系
 *
 */
public class RelationDTO {

	private String relation; //关系
	private String name;//姓名
	private String birthday;//出生年月
	private String workUnitPost; //工作单位及职务
	private String contactInformation;//联系方式
	
	
	public RelationDTO() {
		super();
	}
	public RelationDTO(String relation, String name, String birthday,
			String workUnitPost, String contactInformation) {
		super();
		this.relation = relation;
		this.name = name;
		this.birthday = birthday;
		this.workUnitPost = workUnitPost;
		this.contactInformation = contactInformation;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getWorkUnitPost() {
		return workUnitPost;
	}
	public void setWorkUnitPost(String workUnitPost) {
		this.workUnitPost = workUnitPost;
	}
	public String getContactInformation() {
		return contactInformation;
	}
	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}
}
