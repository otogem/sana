package my.Sana.Model;

public class PostFileVO {
	//파일저장된 경로
	private String uploadPath;
	//업로드 파일명
	private String fileName;
	//uuid 정보
	private String uuid;
	//업로드된 파일이 이미지 파일인지 분류용 정보
	private boolean image;
	//게시판 번호
	private int product_number;
	
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public boolean isImage() {
		return image;
	}
	public void setImage(boolean image) {
		this.image = image;
	}
	public int getProduct_number() {
		return product_number;
	}
	public void setProduct_number(int product_number) {
		this.product_number = product_number;
	}
	@Override
	public String toString() {
		return "PostFileVO [uploadPath=" + uploadPath + ", fileName=" + fileName + ", uuid=" + uuid + ", image=" + image
				+ ", product_number=" + product_number + "]";
	}
	
}
