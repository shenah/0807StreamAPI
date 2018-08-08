
public class StudentDTO {

	private String num;
	private String name;
	private String major;
	private int score;
	private int age;
	private String gender;
	
	public StudentDTO() {
		super();
	}
	public StudentDTO(String num, String name, String major, int score, int age, String gender) {
		super();
		this.num = num;
		this.name = name;
		this.major = major;
		this.score = score;
		this.age = age;
		this.gender = gender;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "StudentDTO [num=" + num + ", name=" + name + ", major=" + major + ", score=" + score + ", age=" + age
				+ ", gender=" + gender + "]";
	}
	

}
