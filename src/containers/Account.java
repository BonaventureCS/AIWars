package containers;

public class Account {

	private String firstname, lastname, email, biography, tagline, school, image;
	private int userID;
	
	
	public Account(int id, String f, String l, String e, String bio, String tag, String sch, String img) {
		userID = id;
		firstname = f;
		lastname = l;
		email = e;
		biography = bio;
		tagline = tag;
		school = sch;
		image = img;
	}
	
	public int getID() {
		return userID;
	}
	
	public String getName() {
		return firstname + " " + lastname;
	}
	
	public String getBiography() {
		return biography;
	}
	
	public String getSchool() {
		return school;
	}
	
	public String getTagline() {
		return tagline;
	}
	
	public String getImage() {
		return image;
	}
	
	public String getEmail() {
		return email;
	}
 	
}
