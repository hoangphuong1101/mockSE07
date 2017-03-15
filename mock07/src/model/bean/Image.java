package model.bean;

public class Image {
	int imageId;
	int threadId;
	String src;
	String content;
	boolean image360;

	public Image() {
		super();
	}

	public Image(int imageId, int threadId, String src, String content, boolean image360) {
		super();
		this.imageId = imageId;
		this.threadId = threadId;
		this.src = src;
		this.content = content;
		this.image360 = image360;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isImage360() {
		return image360;
	}

	public void setImage360(boolean image360) {
		this.image360 = image360;
	}

}
