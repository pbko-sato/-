package GoogleMap.Models.HotPepperAPIs.GourmetSearch;

public class GourmetSearchFetchOption {
	// キーワード
	private String keyword;
	// 掲載店名 OR かな
	private String nameAny;
	// 住所
	private String address;
	// 電話番号
	private String tel;
	// お店ジャンルコード
	private String genre;
	// 大サービスエリアコード
	private String largeServiceArea;
	// サービスエリアコード
	private String serviceArea;
	// 大エリアコード
	private String largeArea;
	// 中エリアコード
	private String middleArea;
	// 小エリアコード
	private String smallArea;
	
	// constructor
	public GourmetSearchFetchOption() {}


	// URLに付加するクエリを作成
	public String makeQuery() {
		String options[] = {
				this.getKeyword(),
				this.getNameAny(),
				this.getAddress(),
				this.getTel(),
				this.getGenre(),
				this.getLargeServiceArea(),
				this.getServiceArea(),
				this.getLargeArea(),
				this.getMiddleArea(),
				this.getSmallArea()
		};
		String query = String.join("", options);
		
		return query;
	}


	// getter / setter
	public String getKeyword() {
		return keyword != null ? "&keyword=" + keyword : "";
	}

	public void setKeyword(String keyword) {
		if (keyword.length() > 0) {
			this.keyword = keyword;			
		}
	}

	public String getNameAny() {
		return nameAny != null? "&name_any=" + nameAny : "";
	}

	public void setNameAny(String nameAny) {
		if (nameAny.length() > 0) {
			this.nameAny = nameAny;			
		}
	}

	public String getAddress() {
		return address != null? "&address=" + address : "";
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel != null? "&tel=" + tel : "";
	}

	public void setTel(String tel) {
		if (tel.length() > 0) {
			this.tel = tel;			
		}
	}

	public String getGenre() {
		return genre != null? "&genre=" + genre : "";
	}

	public void setGenre(String genre) {
		if (genre.length() > 0) {
			this.genre = genre;			
		}
	}

	public String getLargeServiceArea() {
		return largeServiceArea != null ? "&large_service_area" + largeServiceArea : "";
	}

	public void setLargeServiceArea(String largeServiceArea) {
		if (largeServiceArea.length() > 0) {
			this.largeServiceArea = largeServiceArea;			
		}
	}

	public String getServiceArea() {
		return serviceArea != null ? "&service_area=" + serviceArea : "";
	}

	public void setServiceArea(String serviceArea) {
		if (serviceArea.length() > 0) {
			this.serviceArea = serviceArea;			
		}
	}

	public String getLargeArea() {
		return largeArea != null ? "&large_area=" + largeArea : "";
	}

	public void setLargeArea(String largeArea) {
		if (largeArea.length() > 0) {
			this.largeArea = largeArea;			
		}
	}

	public String getMiddleArea() {
		return middleArea != null ? "&middle_area=" + middleArea : "";
	}

	public void setMiddleArea(String middleArea) {
		if (middleArea.length() > 0) {
			this.middleArea = middleArea;			
		}
	}

	public String getSmallArea() {
		return smallArea != null ? "&small_area=" + smallArea : "";
	}

	public void setSmallArea(String smallArea) {
		if (smallArea.length() > 0) {
			this.smallArea = smallArea;			
		}
	}
}
