package crud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import crud.dto.CrudDto;

@Mapper
public interface CrudMapper {
	public List<CrudDto> selectAll();
	public void insertCrud(CrudDto cruddto);
	public void updateCrud(CrudDto cruddto);
	public CrudDto selectOne(int num);
	public void deleteCrud(int num);
}
