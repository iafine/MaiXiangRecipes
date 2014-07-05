package org.recipe.domain;

public class Recipe {
	/*
	 * 食谱实体类
	 * */
	
	private int id ;					//食谱id
	private String title ;				//抓取到的标题
	private String url ;					//做法步骤
	private String desp ;			//食谱简单介绍
	private String method ;		//食谱做法
	private String imageUrl ;				//食谱介绍图片链接
	private String difficulty ;			//制作难度
	private String taste ;				//口味
	private String time ;			//烹饪时间
	private String materials ;		//食材
	
	
	//食谱类中各属性的 setter和getter方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDesp() {
		return desp;
	}
	public void setDesp(String desp) {
		this.desp = desp;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMaterials() {
		return materials;
	}
	public void setMaterials(String materials) {
		this.materials = materials;
	}
}
