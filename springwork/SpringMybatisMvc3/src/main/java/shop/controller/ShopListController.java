package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import data.dto.ShopDto;
import data.dto.ShopRepleDto;
import data.service.ShopRepleService;
import data.service.ShopService;
import naver.storage.NcpObjectStorageService;

@Controller
public class ShopListController {
	
	@Autowired
	ShopService shopService;
	
	@Autowired
	ShopRepleService repleService;
	
	@Autowired
	NcpObjectStorageService storageService;

	//버켓이름 
	private String bucketName = "bitcamp-bucket-121";
	
	@GetMapping("/shop/list")
	public String shopList(Model model) {
		// 총 상품 갯수
		int totalCount = shopService.getTotalCount();
		// 전체 상품
		List<ShopDto> list = shopService.getAllSangpum();
		// 메인사진 등록
//		for (ShopDto dto : list) {
//			String mainPhoto = dto.getSphoto().split(",")[0];// ,로 연결된 사진 중 첫번째 사진
//			dto.setSphoto(mainPhoto);
//		}
	
		for(int i=0;i<list.size();i++) {
			ShopDto dto = list.get(i);
			String mainPhoto = dto.getSphoto().split(",")[0];
			dto.setMainPhoto(mainPhoto);
			
			//댓글 수 저장
			int replecount = repleService.getRepleByNum(dto.getNum()).size();
			dto.setReplecount(replecount);
		}
		// 모델에 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		model.addAttribute("fronturl", "https://hit24cex8733.edge.naverncp.com/e0XP0bC7Fl");
		model.addAttribute("backurl", "?type=f&w=100&h=100&ttype=jpg");
		// 포워드
		return "shop/shoplist";
	}
	
	
}
