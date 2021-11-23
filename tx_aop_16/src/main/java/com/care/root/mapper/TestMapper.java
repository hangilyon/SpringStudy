package com.care.root.mapper;

import java.util.List;

import com.care.root.dto.SystemDTO;
import com.care.root.dto.UserDTO;

public interface TestMapper {
	public int userInsert(int num);
	public int systemInsert(int num);
	public List<UserDTO> userDBResult();
	public List<SystemDTO> systemDBResult();
}
