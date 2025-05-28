package RestingapiBoard.board1.repository;

import RestingapiBoard.board1.dto.BoardDto;
import RestingapiBoard.board1.entity.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    List<Board> findAll();
}
