package bit.react.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import bit.react.data.ShopEntity;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ShopDao {
	private ShopRepository shopRepository;
	
	//저장
	public void insertShop(ShopEntity shopEntity) {
		shopRepository.save(shopEntity);//num 값이 포함되어있지 않으면 추가
	}
	
	//전체 목록 얻기
	public List<ShopEntity> getAllShops() {
		return shopRepository.findAll(Sort.by(Sort.Direction.DESC,"num"));
	}
	
	//한개의 데이터 반환
	public ShopEntity getData(int num) {
		return shopRepository.getReferenceById(num);
	}
	
	//삭제
	public void deleteShop(int num) {
		shopRepository.deleteById(num);
	}
	
	//수정
	public void updataShop(ShopEntity shopEntity) {
		if(shopEntity.getPhoto() == null)
			shopRepository.updateShopNoPhoto(shopEntity);//photo 수정에서 제외
		else 
			shopRepository.save(shopEntity);//num 이 포함되어 있으므로 수정됨
	}
}
