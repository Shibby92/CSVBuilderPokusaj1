import java.io.IOException;

public class User implements CSVInterface {
	private String name;
	private int age;
	private boolean isJavaProgammer;

	public User(String name, int age, boolean isJavaProgammer) {
		super();
		this.name = name;
		this.age = age;
		this.isJavaProgammer = isJavaProgammer;
	}
	public User (){
		this.name = "";
		this.age = -1;
		this.isJavaProgammer =false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isJavaProgammer() {
		return isJavaProgammer;
	}

	public void setJavaProgammer(boolean isJavaProgammer) {
		this.isJavaProgammer = isJavaProgammer;
	}

	private void writeObject(java.io.ObjectOutputStream stream)
			throws IOException {
		stream.writeObject(name);
		stream.writeInt(age);
		stream.writeObject(isJavaProgammer);
	}

	private void readObject(java.io.ObjectInputStream stream)
			throws IOException, ClassNotFoundException {
		name = (String) stream.readObject();
		age = stream.readInt();
		isJavaProgammer = (boolean) stream.readObject();
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", isJavaProgammer="
				+ isJavaProgammer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (isJavaProgammer ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (isJavaProgammer != other.isJavaProgammer)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String objectToCsv() {
		return name + "," + age + "," + isJavaProgammer;
	}

	@Override
	public void CsvToObject(String csv) {
		String[] params = csv.split(",");
		this.name = params[0];
		this.age = Integer.parseInt(params[1]);
		this.isJavaProgammer = Boolean.parseBoolean(params[2]);
	}

}
