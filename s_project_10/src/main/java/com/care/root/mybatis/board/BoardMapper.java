package com.care.root.mybatis.board;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;

public interface BoardMapper {
	public List<BoardDTO> boardAllList(@Param("s") int start,@Param("e") int end); // 두 개 이상 매개변수를 넣을 시 param 넣어야 함
	public int writeSave(BoardDTO dto);
	public BoardDTO contentView(int writeNo);
	public void upHit(int writeNo);
	public BoardDTO getData(int writeNo);
	public int modify(BoardDTO dto);
	public int delete(int writeNo);
	public void addReply(BoardRepDTO dto);
	public List<BoardRepDTO> getRepList(int write_group);
	public int selectBoardCount();
}
