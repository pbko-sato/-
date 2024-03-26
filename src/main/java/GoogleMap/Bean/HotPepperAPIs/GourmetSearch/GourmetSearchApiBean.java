package GoogleMap.Bean.HotPepperAPIs.GourmetSearch;

import java.io.Serializable;

public class GourmetSearchApiBean implements Serializable {
	// お店ID
	private String id;
	// 掲載店名
	private String name;
	// 住所
	private String address;
	// 緯度
	private double lat;
	// 経度
	private double lng;
	// お店ジャンル.お店ジャンル名
	private String genreName;
	// お店ジャンル.お店ジャンルキャッチ
	private String genreCatch;
	// お店キャッチ
	private String shopCatch;
	// 交通アクセス
	private String access;
	// 店舗URL.PC向けURL
	private String urlsPc;
	// 写真.PC向け.大
	private String photoPcL;
	// 写真.PC向け.中
	private String photoPcM;
	// 写真.PC向け.小
	private String photoPcS;
	
	// constructor
	public GourmetSearchApiBean(
			String id,
			String name,
			String address,
			double lat,
			double lng,
			String genreName,
			String genreCatch,
			String shopCatch,
			String access,
			String urlsPc,
			String photoPcL,
			String photoPcM,
			String photoPcS
	) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
		this.genreName = genreName;
		this.genreCatch = genreCatch;
		this.shopCatch = shopCatch;
		this.access = access;
		this.urlsPc = urlsPc;
		this.photoPcL = photoPcL;
		this.photoPcM = photoPcM;
		this.photoPcS = photoPcS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public String getGenreCatch() {
		return genreCatch;
	}

	public void setGenreCatch(String genreCatch) {
		this.genreCatch = genreCatch;
	}

	public String getShopCatch() {
		return shopCatch;
	}

	public void setShopCatch(String shopCatch) {
		this.shopCatch = shopCatch;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getUrlsPc() {
		return urlsPc;
	}

	public void setUrlsPc(String urlsPc) {
		this.urlsPc = urlsPc;
	}

	public String getPhotoPcL() {
		return photoPcL;
	}

	public void setPhotoPcL(String photoPcL) {
		this.photoPcL = photoPcL;
	}

	public String getPhotoPcM() {
		return photoPcM;
	}

	public void setPhotoPcM(String photoPcM) {
		this.photoPcM = photoPcM;
	}

	public String getPhotoPcS() {
		return photoPcS;
	}

	public void setPhotoPcS(String photoPcS) {
		this.photoPcS = photoPcS;
	}
}
