package bit.react.data;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ShopDto {

	private int num;
	private String sangpum;
	private String color;

    @Column(name = "price")  // DB는 price 컬럼
	private int price;
	private String photo;
	private String sangguip;
}
