package crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.dto.CrudDto;
import crud.mapper.CrudMapper;

@Service
public class CrudService {
	@Autowired
 	CrudMapper crudMapper;
 
	 public List<CrudDto> selectAll() {
		return crudMapper.selectAll();
	 }
	 
	 public void insertCrud(CrudDto cruddto) {
		 crudMapper.insertCrud(cruddto);
	 }
	 
	 public void updateCrud(CrudDto cruddto) {
		 crudMapper.updateCrud(cruddto);
	 }
	 
	 public CrudDto selectOne(int num) {
		 return crudMapper.selectOne(num);
	 }
	 
	 public void deleteCrud(int num) {
		 crudMapper.deleteCrud(num);
	 }
}
