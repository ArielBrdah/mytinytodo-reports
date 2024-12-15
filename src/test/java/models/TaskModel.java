package models;

/***
 * {@value priority, due, title, note, tags}
 */
public class TaskModel {
	
	private String id;
	private String priority;
	private String due;
	private String title;
	private String note;
	private String tags;
	public TaskModel(String priority, String due, String title, String note, String tags) {
		super();
		setPriority(priority);
		setDue(due);
		setTitle(title);
		setNote(note);
		setTags(tags);
	}
	public TaskModel(String priority, String due, String title, String note, String tags, String id) {
		super();
		setPriority(priority);
		setDue(due);
		setTitle(title);
		setNote(note);
		setTags(tags);
		setId(id);
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getDue() {
		return due;
	}
	public void setDue(String due) {
		this.due = due;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TaskModel get() {
		return this;
	}
	
	public void show() {
		System.out.println("id:\t" + this.getId());
		System.out.println("prio:\t" + this.getPriority());
		System.out.println("due:\t" + this.getDue());
		System.out.println("title:\t" + this.getTitle());
		System.out.println("note:\t" + this.getNote());
		System.out.println("tags:\t" + this.getTags());
	}
	
	public Boolean equals(TaskModel t2) {
		if(
				this.getTitle().equalsIgnoreCase(t2.getTitle()) 
				&& this.getPriority().equalsIgnoreCase(t2.getPriority()) 
				&& this.getDue().equalsIgnoreCase(t2.getDue()) 
				&& this.getNote().equalsIgnoreCase(t2.getNote())
				&& this.getTags().equalsIgnoreCase(t2.getTags())
				) {
			return true;
		}
		return false;
	}

}
